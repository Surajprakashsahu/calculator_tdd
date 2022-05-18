package com.tdd.calculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public int Add(String numbers) throws Exception {
        if(numbers.contains(",\n") || numbers.contains("\n,")){
            throw new Exception("Invalid Input.");
        }
        if(numbers.equals(""))
            return 0;
        if(numbers.length() == 1){
            return Integer.parseInt(numbers);
        }
        List<String> numberList = Arrays.asList(numbers.split(",|\n"));
        int sum = 0;
        for(String num: numberList){
            sum += parseToInt(num);
        }
        return sum;
    }

    public int parseToInt(String numStr)throws Exception{
        try{
            return Integer.parseInt(numStr);
        }catch (Exception e){
            throw new Exception("Invalid input.");
        }
    }
}
