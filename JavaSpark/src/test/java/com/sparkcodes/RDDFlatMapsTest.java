package com.sparkcodes;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RDDFlatMapsTest {
    @Test
    @DisplayName("Test flatMap() method in Spark RDD")
    void testFlatMapInSparkRDD() {
        final var conf = new SparkConf().setAppName("RDDFlatMapsTest").setMaster("local[*]");
        try (final var sc = new JavaSparkContext(conf)) {
            final String testFilePath = Path.of("src", "test", "resources", "magna-carta.txt.gz").toString();
            final var lines = sc.textFile(testFilePath);
            System.out.printf("Total lines in file %d%n", lines.count());

            final var list_of_words = lines.map(line -> line.split("\\s"));
            System.out.printf("Total lines in file %d%n", list_of_words .count());
            assertEquals(lines.count(), list_of_words .count());

            final var flatMapped_words =  lines.flatMap(line->List.of(line.split("\\s")).iterator());
            System.out.println(flatMapped_words);
            System.out.printf("Total number of words in the file~>%d%n", flatMapped_words.count());

            System.out.println("First few words:");
            flatMapped_words.take(15).forEach(System.out::println);
            System.out.println("--------------------");
        }
    }
}
