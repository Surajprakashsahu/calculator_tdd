package com.tdd.calculator;

import java.util.List;

public class StringCalculator {

    public int Add(String numbers){
        if(numbers.equals(""))
            return 0;
        if(numbers.length() == 1){
            return Integer.parseInt(numbers);
        }

        return 0;
    }
}
