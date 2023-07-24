package com.example.calculator1;

import org.springframework.stereotype.Service;

@Service
public class Calculator {
    public String sum(String num1, String num2){
        checkArgument(num1,num2);
        return num1 + " + " + num2 + " = " + (Float.parseFloat(num1) + Float.parseFloat(num2));

    }

    public String minus(String num1, String num2){
        checkArgument(num1,num2);
        return num1 + " - " + num2 + " = " + (Float.parseFloat(num1) - Float.parseFloat(num2));

    }

    public String multiply(String num1, String num2){
        checkArgument(num1,num2);
        return num1 + " * " + num2 + " = " + (Float.parseFloat(num1) * Float.parseFloat(num2));

    }

    public String divide(String num1, String num2){
            float num01 = Integer.parseInt(num1);
            float num02 = Integer.parseInt(num2);
            checkArgument(num1,num2);
            checkSecondArgument(num2);
        float result1 = num01/num02;
            return num1 + " / " + num2 + " = " + result1;

    }
    private void checkArgument(String str1, String str2){
        if (str1.equals("") || str2.equals("")){
            throw new IllegalArgumentException();
        }
    }
    private void checkSecondArgument(String str2){
        int num = Integer.parseInt(str2);
        if (num == 0){
            throw new IllegalArgumentException();
        }
    }
}
