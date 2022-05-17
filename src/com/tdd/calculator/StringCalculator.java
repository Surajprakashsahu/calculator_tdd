package com.tdd.calculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public int Add(String numbers){
        if(numbers.equals(""))
            return 0;
        if(numbers.length() == 1){
            return Integer.parseInt(numbers);
        }
        List<String> numberList = Arrays.asList(numbers.split(","));
        int sum = 0;
        for(String num: numberList){
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}
