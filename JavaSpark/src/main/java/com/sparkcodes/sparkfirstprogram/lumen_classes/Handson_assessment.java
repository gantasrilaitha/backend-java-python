package com.sparkcodes.sparkfirstprogram.lumen_classes;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.*;


//unext codes
public class Handson_assessment {
    public static void main(String[] args) {

//        if (args.length < 2) {
//            System.err.println("Usage: ReportApp <sales_csv_path> <returns_csv_path>");
//            System.exit(1);
//        }

//        String salesPath = args[0];//"src/main/resources/Global Superstore Sales - Global Superstore Sales.csv"
//        String returnsPath = args[1];//"src/main/resources/Global Superstore Sales - Global Superstore Returns.csv"

        SparkSession spark = SparkSession.builder()
                .appName("Read CSV ")
                .master("local[*]")
                .getOrCreate();

        // Read first CSV
        Dataset<Row> returns_df = spark.read()
                .option("header", "true")     // use first row as header
                .option("inferSchema", "true") // infer column types
                .csv("src/main/resources/Global Superstore Sales - Global Superstore Returns.csv");
        returns_df.show(false);

        // Read second CSV
        Dataset<Row> sales_df = spark.read()
                .option("header", "true")
                .option("inferSchema", "true")
                .csv("src/main/resources/Global Superstore Sales - Global Superstore Sales.csv");
        sales_df.show(false);

        // Print schema
        System.out.println("=== SCHEMA OF RETURNS CSV ===");
        returns_df.printSchema();

        System.out.println("=== SCHEMA OF SALES CSV ===");
        sales_df.printSchema();

        //1. That contains the aggregate (sum) Profit and Quantity, based on Year, Month, Category, Sub Category.
        Dataset<Row> cleanedSales = sales_df
                .withColumn(
                        "OrderDate",
                        when(to_date(col("Order Date"), "M/d/yyyy").isNotNull(),
                                to_date(col("Order Date"), "M/d/yyyy"))
                                .otherwise(to_date(col("Order Date"), "MM/dd/yyyy"))
                )
                .withColumn("Year", year(col("OrderDate")))
                .withColumn("Month", month(col("OrderDate")))
                .withColumn("Profit",
                        expr("try_cast(regexp_replace(regexp_replace(`Profit`, '[$,()]', ''), '\\\\(', '-') as double)")
                )
                .withColumn("Sales",
                        expr("try_cast(regexp_replace(regexp_replace(`Sales`, '[$,()]', ''), '\\\\(', '-') as double)")
                );

        Dataset<Row> joined = cleanedSales.join(
                returns_df,
                cleanedSales.col("Order ID").equalTo(returns_df.col("Order ID")),
                "left"
        );
        Dataset<Row> report = joined
                .groupBy(
                        col("Year"),
                        col("Month"),
                        col("Category"),
                        col("Sub-Category")
                )
                .agg(
                        sum("Quantity").alias("Total_Quantity_Sold"),
                        sum("Profit").alias("Total_Profit")
                )
                .orderBy("Year", "Month", "Category", "Sub-Category");
        System.out.println("=== REPORT ===");
        report.show(false);


        //2. This data has to be stored in a partition based on year month. like year=2014/month=11
        report
                .write()
                .mode(SaveMode.Overwrite)
                .partitionBy("Year", "Month")
                .format("parquet")
                .save("output/sales_report/");

        //3.For the total profit and total quantity calculations the returns data should be used to exclude all returns
        Dataset<Row>returnsDf = returns_df
                .select(col("Order ID"))
                .withColumnRenamed("Order ID", "Returned_Order_ID");
        Dataset<Row> validSales = cleanedSales // this is your cleaned + date parsed + numeric cleaned DF
                .join(returnsDf,
                        cleanedSales.col("Order ID")
                                .equalTo(returnsDf.col("Returned_Order_ID")),
                        "left_anti"
                );
        Dataset<Row> finalReport =
                validSales.groupBy("Year", "Month", "Category", "Sub-Category")
                        .agg(
                                sum("Quantity").alias("Total_Quantity_Sold"),
                                sum("Profit").alias("Total_Profit")
                        )
                        .orderBy("Year", "Month", "Category", "Sub-Category");
        finalReport.write()
                .mode(SaveMode.Overwrite)
                .partitionBy("Year", "Month")
                .parquet("output/sales_report/");


    }
}
