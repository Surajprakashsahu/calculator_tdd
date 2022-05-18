package com.tdd.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Test
    public void testAdd() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.Add(""));
        assertEquals(1,stringCalculator.Add("1"));
        assertEquals(3,stringCalculator.Add("1,2"));
        assertEquals(10, stringCalculator.Add("1,2,3,4"));
        assertEquals(20, stringCalculator.Add("1,2,3,4,10"));
        assertEquals(6, stringCalculator.Add("1\n2,3"));
        assertEquals(20, stringCalculator.Add("1\n2,3,4\n10"));
        assertEquals(3, stringCalculator.Add("//;\n1;2"));
    }

    @Test(expected = Exception.class)
    public void invalidInput() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        stringCalculator.Add("1,\n2");
        stringCalculator.Add("1,\n");
    }
}