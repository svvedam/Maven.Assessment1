package com.zipcodewilmington.assessment1.part1;

/**
 * Created by leon on 2/16/18.
 */
public class BasicStringUtils {
    /**
     * @param str string input from client
     * @return string with identical content, and the first character capitalized
     */
    public static String camelCase(String str) {
       String cap = str.substring(0, 1).toUpperCase() + str.substring(1);

       return cap;
    }

    /**
     * @param str string input from client
     * @return string with identical contents, in the reverse order
     */
    public static String reverse(String str) {
        StringBuilder sbr = new StringBuilder(str);
        StringBuilder reverseSbr = sbr.reverse();
        return reverseSbr.toString();
    }

    /**
     * @param str string input from client
     * @return string with identical contents, in reverse order, with first character capitalized
     */
    public static String reverseThenCamelCase(String str) {
        StringBuilder sbr = new StringBuilder(str);
        StringBuilder reverseSbr = sbr.reverse();
        String reversedString = reverseSbr.toString();

        reversedString = reversedString.substring(0, 1).toUpperCase() + reversedString.substring(1);

        return reversedString;
    }


    /**
     * @param str a string input from user
     * @return string with identical contents excluding first and last character
     */
    public static String removeFirstAndLastCharacter(String str) {
        int length = str.length()-1;
        str = str.substring(1, length);
        return str;
    }

    /**
     * @param str a string input from user
     * @return string with identical characters, each with opposite casing
     */
    public static String invertCasing(String str) {
        StringBuilder sbr = new StringBuilder();
        for(char ch: str.toCharArray()){
            if(Character.isLowerCase(ch)){
                sbr.append(Character.toUpperCase(ch));
            }else {
                sbr.append(Character.toLowerCase(ch));
            }
        }
        return sbr.toString();
    }
}
