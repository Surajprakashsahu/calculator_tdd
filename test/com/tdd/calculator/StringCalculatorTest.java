package com.tdd.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Test
    public void testAdd() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.Add(""));
    }
}