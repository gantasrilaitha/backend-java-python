package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;//Assertions is a class,assertEquals is a method

public class CalculatorTest {

    @Test
    void testAddition() {
        Calculator calculator = new Calculator();
        // doing static import of a method, so it can be called by class name,need not
        // have obects mandatorily
        assertEquals(5, calculator.add(2, 3));// (expected_res,actual_res)
    }
}