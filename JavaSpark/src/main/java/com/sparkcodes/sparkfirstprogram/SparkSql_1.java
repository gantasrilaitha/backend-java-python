package com.sparkcodes.sparkfirstprogram;
//import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.*;
import org.apache.spark.sql.SparkSession;
import static org.apache.spark.sql.functions.concat;
import static org.apache.spark.sql.functions.lit;

public class SparkSql_1 {
    public static void main(String[] args) {

        //setting spark session
        SparkSession sparkSession = new SparkSession.Builder().appName("CSV to DB migration").master("local[*]").getOrCreate();

        //Dataframe: Dataset<Row> just like RDBMS TABLE; type-safe(only system defined/implicit data types are used)
        //Dataset:Dataset<T> java class with attributes ->transformed to a RDBMS TABLE; not-type-safe(user-defined types are used)

        //reading input file
        Dataset<Row> df = sparkSession.read().format("csv")//file format to read(optional)
                .option("sep", ",")//separator to use(optional)
                .option("header", true)//include headers(optional)
                .option("inferSchema",true)//determine schema of columns automatically(optional)
                .load("src/main/resources/name_and_comments.txt");//src path of file to load

        df.show();// displays all rows of table
        df.show(2);//displays first 2 rows of table
        df.printSchema();//schema of all columns
        df.select("first_name").show();//display rows of specific column

        //Transformation[dataframes are immutable, so assigning is needed]
        //1
        df = df.withColumn("full_name",concat(df.col("last_name"),lit(", "),df.col("first_name")));//withColumn: create new column
        //concat: the specified columns with operator mention in lit() ~ join()
        df.show();

        //Transformation
        //2
        df = df.filter(df.col("comment").rlike("\\d+")).orderBy(df.col("last_name").asc());//display only rows that match regular exp in rlike(containing 1 or more than 1 digits ) in comment column & order by last_name in asc order
        df.show();

        // 1 + 2 can be combined in this way:
        Dataset<Row> new_ds = df.withColumn("full_name",
                        concat(df.col("last_name"), lit(", "), df.col("first_name")))
                .filter(df.col("comment").rlike("\\d+"))
                .orderBy(df.col("last_name").asc());

        new_ds.show();
    }
}
