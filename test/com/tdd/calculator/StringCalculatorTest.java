package com.tdd.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Test
    public void testAdd() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.Add(""));
        assertEquals(1,stringCalculator.Add("1"));
        assertEquals(3,stringCalculator.Add("1,2"));
    }
}