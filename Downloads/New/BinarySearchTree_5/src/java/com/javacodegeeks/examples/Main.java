package com.javacodegeeks.examples;

public class Main {

    public static void main(String[] args) {
        String numbers = "//[***][%]\n1***2%3";
        System.out.println(" numbers = " + numbers);
        System.out.println(" args[0] = " + args[0]);

        StringCalculator calculator = new StringCalculator();
        int output = calculator.add(numbers);
        System.out.println(" output = " + output);
    }
}
