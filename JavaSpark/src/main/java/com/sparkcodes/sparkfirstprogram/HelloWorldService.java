package com.sparkcodes.sparkfirstprogram;

import static spark.Spark.*;

//spark first code using java
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
}