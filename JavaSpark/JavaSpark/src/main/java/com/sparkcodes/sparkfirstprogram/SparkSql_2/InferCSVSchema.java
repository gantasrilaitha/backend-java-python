package com.sparkcodes.sparkfirstprogram.SparkSql_2;

import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public class InferCSVSchema {

    public void printSchema() {


        SparkSession sparkSession = SparkSession.builder().appName("Convert CSV to dataframe").master("local[*]").getOrCreate();

        Dataset<Row> df = sparkSession.read().format("csv")
                .option("header", true)
                .option("sep", ";")
                .option("multiline", true)// consider all lines in column value explands to multiple lines
                .option("quote", "^")//treat "^" as quote when encountered
                .option("dateFormat", "M/d/y")//consider date in the format mentioned
                .option("inferSchema", true)
                .load("src/main/resources/amazonProducts.txt");

        System.out.println("Excerpt of the dataframe content:");
        //df.show(7);
        df.show(7, 90); // truncate after 90 chars
        System.out.println("Dataframe's schema:");
        df.printSchema();

    }
}
