/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ips;

import java.math.BigInteger;

/**
 * @version 1.0
 * @author YasinR
 * @see Class Handles data conversion.
 */
public class Parser {

    /**
     * Takes a binary string and converts it to int[] with a binary value on
     * each position.
     * @param binaryString Binary string to be converted.
     * @return Integer array with a binary value on each position.
     */
    public static int[] stringToBinary(String binaryString) {
        char[] c = binaryString.toCharArray();
        int[] value = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            value[i] = Character.getNumericValue(c[i]);
        }
        return value;
    }

    /**
     * Takes a decimal string, converts it to decimal and then converts the
     * decimal value to binary and stores each binary value in an int[].
     * @param decimalString Decimal string to be converted.
     * @return Integer array with a binary value on each position.
     */
    public static int[] stringToDecimalToBinary(String decimalString) {
        int x = Integer.parseInt(decimalString);
        char[] c = Integer.toBinaryString(x).toCharArray();
        int[] value = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            value[i] = Character.getNumericValue(c[i]);
        }
        return value;
    }

    /**
     * Takes a hex string, converts it to hex and then converts the hex value
     * to binary and stores each binary value in an int[].
     * @param hexString Hex string to be converted.
     * @return Integer array with a binary value on each position.
     */
    public static int[] stringToHexToBin(String hexString) {
        String hex = Integer.toHexString(Integer.parseInt(hexString, 16));
        char[] c = new BigInteger(hex, 16).toString(2).toCharArray();
        int[] value = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            value[i] = Character.getNumericValue(c[i]);
        }
        return value;
    }

    /**
     * Converts a binary value to its decimal equivalent.
     * @param bin Binary value to be converted.
     * @return Integer value of the binary number.
     */
    public static int binaryToDecimal(int bin) {
        return Integer.parseInt(Integer.toString(bin), 2);
    }
    
    /**
     * Converts a binary string to its decimal equivalent.
     * @param binString Binary string to be converted.
     * @return Integer value of the binary string.
     */
    public static int binaryStringToDecimal(String binString) {
        return Integer.parseInt(binString, 2);
    }

    /**
     * Converts a binary value to its hex equivalent.
     * @param bin Binary value to be converted.
     * @return Hex string equivalent of the binary value.
     */
    public static String binaryToHex(int bin) {
        return Integer.toHexString(bin);
    }
    
    /**
     * Converts a binary string to its hex equivalent.
     * @param binString Binary string to be converted.
     * @return Hex string equivalent of the binary string value.
     */
    public static String binaryToHex(String binString){
        return binaryToHex(Integer.parseInt(binString, 2));
    }
    
    /**
     * Converts a binary number to a binary string.
     * @param bin Binary number to be converted.
     * @return String of the binary value.
     */
    public static String binaryToString(int bin){
        return Integer.toString(bin);
    }

    /**
     * Tests if a string is a numeric value or not.
     * @param s String to be tested.
     * @return True if it's a number. False if it's not.
     */
    public static boolean isNumeric(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
