package com.tdd.calculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public int Add(String numbers) throws Exception {
        String delimiters = ",|\n";


        if(numbers.equals(""))
            return 0;
        if(numbers.length() == 1){
            return parseToInt(numbers);
        }
        String b = numbers.substring(0,2);
        if(numbers.substring(0,2).equals("//")){
            delimiters += "|"+numbers.substring(2,3);
            numbers = numbers.substring(4, numbers.length());
        }

        if(numbers.contains(",\n") || numbers.contains("\n,")){
            throw new Exception("Invalid Input.");
        }

        List<String> numberList = Arrays.asList(numbers.split(delimiters));
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
