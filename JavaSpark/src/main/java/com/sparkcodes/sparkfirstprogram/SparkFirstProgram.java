package com.sparkcodes.sparkfirstprogram;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SparkFirstProgram {
    public static void main(String[] args) {
        try(final var sparkSession= SparkSession.builder()//start spark session[entry point to sparksql & dataframes]
                                .appName("Spark First Program") // name of appln to show on cluster ui
                                .master("local[*]") //master node: spark /yarn cluster url
                                                    //local[*]: run as many worker threads as logical cores in your machine
                                .getOrCreate();//Creates a new SparkSession if none exists, otherwise returns the existing one.
            final var sc =new JavaSparkContext(sparkSession.sparkContext())){

            final var data = Stream.iterate(1, n->n+1).limit(5).collect(Collectors.toList());
            final  var myRdd = sc.parallelize(data);
            data.forEach(System.out::println);
            System.out.printf("Total elements in RDD: %d%n", myRdd.count());//NO.OF ELEMENTS IN RDD
            System.out.printf("Default no. of partitions in rdd: %d%n", myRdd.getNumPartitions());//NO.OF PARTITIONS IN RDD
            final var max = myRdd.reduce(Integer::max); //REDUCE(TRANSFORMATION) PERFORMING SUM(ACTION): EVALUATES EXPRESSION TO A SINGLE VALUE
            final var sum = myRdd.reduce(Integer::sum);
            System.out.printf("MAX~>%d,  SUM~>%d%n", max, sum);

            try (final var scanner = new Scanner(System.in)) {
                scanner.nextLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
