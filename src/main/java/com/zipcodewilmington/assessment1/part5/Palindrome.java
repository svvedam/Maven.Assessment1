package com.zipcodewilmington.assessment1.part5;

public class Palindrome {

    public Integer countPalindromes(String input){

        int n = input.length();
        int result = 0;
        for(int center = 0; center <= 2*n-1; ++center){
            int left = center/2;
            int right = left + center%2;
            while(left>=0 && right <n && input.charAt(left)==input.charAt(right)){
                result++;
                left--;
                right++;
            }
        }
        return result;
    }
}
