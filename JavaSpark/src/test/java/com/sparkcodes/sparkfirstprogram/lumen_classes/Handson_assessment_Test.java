package com.sparkcodes.sparkfirstprogram.lumen_classes;

import org.apache.spark.sql.*;
import org.apache.spark.sql.types.*;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.apache.spark.sql.functions.*;
import static org.junit.jupiter.api.Assertions.*;

public class Handson_assessment_Test {

    private static SparkSession spark;

    @BeforeAll
    public static void setup() {
        spark = SparkSession.builder()
                .appName("UnitTest")
                .master("local[*]")
                .getOrCreate();
    }

    @AfterAll
    public static void stop() {
        spark.stop();
    }

    @Test
    public void testExcludeReturnedOrders() {

        // ---------- Sales Test Data ----------
        StructType salesSchema = new StructType()
                .add("Order ID", "string")
                .add("Category", "string")
                .add("Sub-Category", "string")
                .add("Quantity", "int")
                .add("Profit", "double")
                .add("OrderDate", "string");

        List<Row> salesRows = Arrays.asList(
                RowFactory.create("A1", "Furniture", "Chairs", 2, 50.0, "1/1/2014"),
                RowFactory.create("A2", "Tech", "Phones", 1, 100.0, "1/2/2014"),
                RowFactory.create("A3", "Office", "Paper", 5, 25.0, "1/3/2014") // This gets returned
        );

        Dataset<Row> salesDf = spark.createDataFrame(salesRows, salesSchema)
                .withColumn("OrderDate", to_date(col("OrderDate"), "M/d/yyyy"))
                .withColumn("Year", year(col("OrderDate")))
                .withColumn("Month", month(col("OrderDate")));


        // ---------- Returns Test Data ----------
        StructType returnsSchema = new StructType().add("Order ID", "string");

        List<Row> returnRows = Arrays.asList(
                RowFactory.create("A3") // returned order
        );

        Dataset<Row> returnsDf = spark.createDataFrame(returnRows, returnsSchema)
                .withColumnRenamed("Order ID", "Returned_Order_ID");


        // ---------- LEFT ANTI JOIN ----------
        Dataset<Row> validSales = salesDf.join(
                returnsDf,
                salesDf.col("Order ID").equalTo(returnsDf.col("Returned_Order_ID")),
                "left_anti"
        );

        // ---------- ASSERTIONS ----------
        // Only A1 and A2 must remain
        assertEquals(2, validSales.count(), "Returned orders must be removed");

        // Check that returned order A3 is not present
        List<String> remainingIDs =
                validSales.select("Order ID").as(Encoders.STRING()).collectAsList();

        assertFalse(remainingIDs.contains("A3"));
    }
}
