package com.tdd.calculator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
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

    @Test()
    public void invalidInput() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Invalid input.");
        stringCalculator.Add("1,\n2");
        stringCalculator.Add("1,\n");
    }

    @Test()
    public void negativeTest() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("negatives not allowed");
        stringCalculator.Add("-1,2,3");
    }

    @Test()
    public void multipleNegativeTest() throws Exception {
        StringCalculator stringCalculator = new StringCalculator();
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("-1,-3,-5");
        stringCalculator.Add("-1,2,-3,4,-5");
    }
}