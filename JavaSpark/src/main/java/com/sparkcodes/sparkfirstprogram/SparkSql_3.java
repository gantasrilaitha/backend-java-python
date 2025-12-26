package com.sparkcodes.sparkfirstprogram;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;

import org.apache.spark.Partition;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;

import static org.apache.spark.sql.functions.*;

public class SparkSql_3 {

    public static void main(String[] args) {
        SparkSession sparkSession = SparkSession.builder()
                .appName("Learning Spark SQL Dataframe API")
                .master("local")
                .getOrCreate();

        String[] stringList = new String[] {"Banana", "Car", "Glass", "Banana", "Banana", "Computer", "Car", "IS", "HE"};
        List<String> words = Arrays.asList(stringList);

        //Encoders: convert JVM Objects to respective  Spark's internal  binary representation
        //i.e convert jvm objects to Spark objects(rdd, datafames)..
        //Encoders enable serialisation( Converting a Java String object into Spark's internal binary representation for storage and processing.) & de-serialisation(Converting Spark's internal binary representation back into a Java String object when retrieving data from a Dataset.)
        Dataset<Row> words_df = sparkSession.createDataset(words,Encoders.STRING()).toDF();
        String filter = "('HE')";
        words_df.filter("value not in "+ filter);
        //words_df.show();

        Dataset<Row> durhamDf = buildDurhamParksDataFrame(sparkSession);

        Dataset<Row> philDf = buildPhilParksDataFrame(sparkSession);

        combineDataframes(durhamDf, philDf);
    }

    public static void combineDataframes(Dataset<Row> df1, Dataset<Row> df2) {
        // Match by column names using the unionByName() method.
        //union(): matches columns by position (order).
        //unionByName() :matches columns by column name.

        Dataset<Row> res_ds = df1.unionByName(df2);

        //In Short:
        //All rows from both tables are combined.
        //All columns are matched by name.
        // Missing values are filled with NULL.
        // No danger of mixing up columns due to order.

        res_ds.show(20);

        res_ds.printSchema();
        System.out.println("We have " + res_ds.count() + " records.");

        res_ds = res_ds.repartition(5);
        Partition[] partitions = res_ds.rdd().partitions();
        System.out.println("Total number of Partitions: "+ partitions.length);
    }

    public static Dataset<Row> buildPhilParksDataFrame(SparkSession sparkSession) {
        Dataset<Row> df = sparkSession.read().format("csv").option("multiline", true)
                .option("header", true)
                .load("src/main/resources/philadelphia_recreations.csv");

        df.filter(lower(df.col("USE_")).like("%park%")); //or: df.filter("lower(USE_) like '%park%' ");

        df = df.withColumn("park_id", concat(lit("phil_"), df.col("OBJECTID")))
                .withColumnRenamed("ASSET_NAME", "park_name")// rename existing column
                .withColumn("city", lit("Philadelphia"))
                .withColumn("has_playground", lit("UNKNOWN"))
                .withColumnRenamed("ZIPCODE", "zipcode")
                .withColumnRenamed("ACREAGE", "land_in_acres")
                .withColumn("geoX",  lit(null).cast(DataTypes.DoubleType))
                .withColumn("geoY",  lit(null).cast(DataTypes.DoubleType))
                .drop("SITE_NAME")
                .drop("OBJECTID")
                .drop("CHILD_OF")
                .drop("TYPE")
                .drop("USE_")
                .drop("DESCRIPTION")
                .drop("SQ_FEET")
                .drop("ALLIAS")
                .drop("CHRONOLOGY")
                .drop("NOTES")
                .drop("DATE_EDITED")
                .drop("EDITED_BY")
                .drop("OCCUPANT")
                .drop("TENANT")
                .drop("LABEL");

        df.show(10);
        return df;
    }

    public static Dataset<Row> buildDurhamParksDataFrame(SparkSession sparkSession) {
        Dataset<Row> df = sparkSession.read().format("json").option("multiline", true)
                .load("src/main/resources/durham-parks.json");

        //transformation
        df = df.withColumn("park_id",concat(df.col("datasetid"),lit("_"),df.col("fields.objectid"),lit("_Dhuram")))
                .withColumn("park_name", df.col("fields.park_name"))
                .withColumn("city", lit("Dhuram"))
                .withColumn("address", df.col("fields.address"))
                .withColumn("has_playground", df.col("fields.playground"))
                .withColumn("zipcode" ,  df.col("fields.zip"))
                .withColumn("land_in_acres", df.col("fields.acres"))
                .withColumn("geoX", df.col("geometry.coordinates").getItem(0))
                .withColumn("geoY", df.col("geometry.coordinates").getItem(1))
                .drop("fields") . drop("geometry"). drop("record_timestamp").drop("recordid")
                .drop("datasetid");

        df.show(10);
        return df;
    }
}
