package com.javacodegeeks.examples;

public class InputNormalizer {
    public String[] normalize(String input) {
        String delimiters = "\n|,";
        if(input.contains("//")) {
            delimiters = getDelimiters(input, delimiters);
            input = stripDelimiters(input);
        }
        return input.split(delimiters);
    }

    private String getDelimiters(String numbers, String defaultDelimiters) {
        StringBuilder delimiters = new StringBuilder(defaultDelimiters);
        while(numbers.indexOf("[") >= 0) {
            delimiters.append("|");
            String delimiter = numbers.substring(numbers.indexOf("[") + 1,numbers.indexOf("]"));
            for(char delimiterChar:  delimiter.toCharArray()) {
                delimiters.append("\\").append(delimiterChar);
            }
            numbers = numbers.substring(numbers.indexOf("]") + 1);
        }
        System.out.println(" delimiters.toString() = " + delimiters.toString());
        return delimiters.toString();
    }

    private String stripDelimiters(String numbers) {
        return numbers.substring(numbers.indexOf("\n") + 1);
    }
}
