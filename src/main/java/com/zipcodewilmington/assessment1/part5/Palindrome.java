package com.zipcodewilmington.assessment1.part5;

public class Palindrome {

    public Integer countPalindromes(String input) {
        int palindromeCount = 0;
        for (int i = 0; i < input.length(); i++) {
            for (int j = i+1; j <= input.length(); j++) {
                if(reverse(input.substring(i,j)).equals(input.substring(i,j))) {
                    palindromeCount++;
                }
            }
        }
        return palindromeCount;
    }

    public static String reverse(String input) {
        StringBuilder sbr = new StringBuilder(input);
        sbr.reverse();
        return sbr.toString();
    }
}
