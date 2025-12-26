package com.sparkcodes.sparkfirstprogram;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import static org.apache.spark.sql.functions.sum;
import static spark.Spark.*;

public class HelloWorldService {
    public static void main(String[] args) {
        System.out.println("LOADING APIS");
        port(4567);
        get("/hello", (req, res)->"Hello, world");
        //awaitInitialization();
        System.out.println("API LOADED");

//        get("/hello/:name", (req,res)->{
//            return "Hello, "+ req.params(":name");
//        });

        // Block until server is fully initialized

        System.out.println("Server started on http://localhost:4567/hello");
    }

    public static class Scratch_2 {
        public static void main(String[] args) {
            String salesUrl = "src/main/resources/sales_1.csv";
            String sales2Url = "src/main/resources/sales_2.csv";
            SparkSession spark = SparkSession
                    .builder()
                    .appName("SocgenJava")
                    .master("local[*]")
                    .getOrCreate();

            Dataset<Row> productDf = spark.read()
                    .option("inferSchema", "true")
                    .option("header", "true")
                    .csv(salesUrl);
            productDf.show();

            Dataset<Row> sales1Df = readSales(spark, salesUrl);
            Dataset<Row> sales2Df = readSales(spark, sales2Url);
            sales1Df.show();
            sales1Df.printSchema();
            sales1Df.explain(true);
            sales2Df.show();
            sales2Df.printSchema();
            sales2Df.explain(true);

            Dataset<Row> unionsales = sales2Df.union(sales1Df);
            System.out.println("unionsales");
            unionsales.show();
            System.out.println("sales1 count ={}" + sales1Df.count()+"sales2 count ={}"+ sales2Df.count()+"Unionsales count:{}"+unionsales.count());


            Dataset<Row> joinedDf = unionsales.join(
                    productDf,
                    unionsales.col("item_id").equalTo(productDf.col("item_id"))
                            //.and(unionsales.col("date_of_sale").geq("2020-09-02"))
            );


            Dataset<Row> groupedDF= joinedDf.groupBy("date_of_sale")
                    .agg(sum("total_price").as("TotalPrice"));
            groupedDF.show();

            //.and(unionsales.col("somecolumn").equalTo(productDf.col("someothercolumn"))));
            System.out.println("joinedDf");
            joinedDf.show();




        }
        public static Dataset<Row> readSales(SparkSession spark, String filePath) {
            //create customised metadata
            StructType schema = DataTypes.createStructType(new StructField[] {
                    DataTypes.createStructField("item_id",  DataTypes.IntegerType, true),
                    DataTypes.createStructField("item_qty", DataTypes.IntegerType, true),
                    DataTypes.createStructField("unit_price", DataTypes.FloatType, true),
                    DataTypes.createStructField("total_amount", DataTypes.IntegerType, true),
                    DataTypes.createStructField("date_of_sale", DataTypes.DateType, true)
            });

            Dataset<Row> productDf = spark.read()
                    .schema(schema)
                    .option("header", "true")
                    .csv(filePath);

            return productDf;
        }
    }
}