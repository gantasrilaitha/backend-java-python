package com.sparkcodes.sparkfirstprogram;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.*;
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

    public static class Scratch {
        public static void main(String[] args) {
            //functional programming: pass code to data (main priority is code)
            //paradigm programming: normal loops: pass data to code
            //oops programming: attach code to data
            List<Integer> original_list= Arrays.asList(1,2,3,4,5);
            List<Integer> new_list= original_list.stream()
                    .filter(e->e%2==0)
                    .map(e->e*e)
                    .collect(Collectors.toList());
    //        l.add(10);
    //        l.add(20);
    //        l.add(30);

            //stream(): takes 1 object at a time from a collection: do less space, fast
            //lambdas & predicates are optimised in java, cheap & fast
            original_list.stream().map(e->e*e).forEach(System.out::println);
            System.out.println("stream object"+original_list.stream());
            System.out.println("original_list"+original_list);
            System.out.println("new_list"+new_list);

            //functional interfaces
            @FunctionalInterface //function-a single “thing you can do.”
            interface Transformer<T,R> { //take T and return R
                R apply(T t);  // single abstract method[SAM]
            }
            Transformer<String,Integer> len = s -> s.length();
            int n = len.apply("hello"); // 5
            System.out.println("len:"+n);

    //                How does Java know what s -> s.length() means?
    //                It looks at the target type (Transformer<String, Integer>).
    //                That interface has only one abstract method, apply(T t).
    //                So the compiler maps the lambda to that method.

            Function<Integer,Integer> f = x -> x + 1;
            Function<Integer,Integer> g = x -> x * 2;
            Function<Integer, Integer> square = x -> x * x;
            Function<Integer,Integer> h = f.compose(g); // f(g(x))
            System.out.println("h:"+h);
            System.out.println("square:"+square.apply(10));
            //Combinators are small, reusable function patterns (like map, flatMap, compose, andThen, pipe).

            //composition on functional interfaces : create chain/pipeline using functional interfaces
            Function<String,String> trim = String::trim;
            Function<String,String> lower = String::toLowerCase;
            Function<String,String> pipeline = trim.andThen(lower);
            String result = pipeline.apply("  HeLLo ");
            System.out.println("result:"+result);

            Function<Integer, Function<Integer, Integer>> add = a -> (b -> a + b); //add   = a -> (b -> a + b)
            Function<Integer, Integer> add5 = add.apply(5); // partially applied //b->5+b
            System.out.println(add5.apply(3)); // 8 //5+3=8


            BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
            Function<Integer, Integer> doubleIt = b -> multiply.apply(2, b);
            Function<Integer, Integer> tripleIt = b -> multiply.apply(3, b);
            System.out.println(doubleIt.apply(10)); // 20
            System.out.println(tripleIt.apply(10)); // 30
            System.out.println(multiply.apply(5,7));//35

            //supplier(no input, only return) & consumer(take input, nothing return)
            Supplier<String> messageSupplier = () -> "Hello from Supplier!";
            Consumer<String> messagePrinter = message -> System.out.println("Consumed: " + message);
            String message = messageSupplier.get();   // get data from Supplier
            messagePrinter.accept(message);           // pass it to Consumer


            //Partial function : A partial function can fail or be undefined for some inputs.(unsafe)
            Function<Integer, Integer> divide100By = x -> 100 / x; // partial function
            System.out.println(divide100By.apply(5)); // 20
            //System.out.println(divide100By.apply(0)); // ⚠️ ArithmeticException


    //        Function<T,R> — takes T returns R
    //        Predicate<T> — takes T returns boolean
    //        Consumer<T> — takes T, returns void (side-effect)
    //        Supplier<T> — returns T (no input)

            Predicate<Integer> isEven = i->i%2==0;
            Predicate<Integer> ismorethan4 = i->i>4;
            Predicate<Integer> isEvenismorethan4 = isEven.or(ismorethan4);
            System.out.println("ismorethan4"+ismorethan4);
            System.out.println("isEven"+isEven);
            original_list.stream().filter(isEvenismorethan4).forEach(System.out::println);
            original_list.stream().filter(i->isEvenismorethan4.test(i)).forEach(System.out::println);

        }
    }
}
