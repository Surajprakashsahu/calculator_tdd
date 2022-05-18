package com.tdd.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    final String INVALID_INP = "Invalid input.";
    public int Add(String numbers) throws RuntimeException {

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
            throw new RuntimeException(INVALID_INP);
        }

        List<Integer> numberList = Arrays.asList(numbers.split(delimiters)).stream().map((numstr -> {
            try {
                return parseToInt(numstr);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        })).collect(Collectors.toList());
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();
        for(Integer num: numberList){
            if(num < 0){
                negatives.add(num);
            }
            sum += num;
        }
        if(negatives.size() > 0){
            if(negatives.size() == 1)
                throw new RuntimeException("negatives not allowed");

            throw new RuntimeException(negatives.stream().map(a -> a+"").collect(Collectors.joining(",")));
        }
        return sum;
    }

    public int parseToInt(String numStr)throws RuntimeException{
        try{
            return Integer.parseInt(numStr);
        }catch (Exception e){
            throw new RuntimeException(INVALID_INP);
        }
    }
}
