package com.java.learning;

import java.text.NumberFormat;

public class Learning {
    public static void main(String[] args) {

//        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        NumberFormat  currencyFormat = NumberFormat.getPercentInstance();
        String result= currencyFormat.format(1.3);
        System.out.println(result);

    }

}
