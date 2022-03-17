package fr.istic.vv;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumeraUtils {

    //Map containing letters and values
    public static Map<Character,Integer> NUMBERS_MAP;

    /**
     * Constructor
     */
    public RomanNumeraUtils() {
        NUMBERS_MAP = new HashMap<>();
        NUMBERS_MAP.put('I',1);
        NUMBERS_MAP.put('V',5);
        NUMBERS_MAP.put('X',10);
        NUMBERS_MAP.put('L',50);
        NUMBERS_MAP.put('C',100);
        NUMBERS_MAP.put('D',500);
        NUMBERS_MAP.put('M',1000);
    }

    /**
     * Check if input is a correct roman numeral
     * @param value roman number as string
     * @return true if valid, else false
     */
    public static boolean isValidRomanNumeral(String value) {
    //1. Only symbols M, D, C, X, V, I can be used. Their values are shown below:
        Pattern p = Pattern.compile("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$\n");
        Matcher m = p.matcher(value);
        boolean b = m.matches();

        return b;
    }

    /**
     * Convert roman numeral from string to int
     * @param numeral, the roman numeral as string
     * @return the value as int
     */
    public static int parseRomanNumeral(String numeral) {
        //Init result
        int result=0;

        //For each char in roman numeral, left to right
        for(int i=0;i<numeral.length();i++)
        {
            // Current Roman Character
            char ch = numeral.charAt(i);

            //Case 1 - Check for subtraction
            if(i>0 && NUMBERS_MAP.get(ch) > NUMBERS_MAP.get(numeral.charAt(i-1)))
            {
                result += NUMBERS_MAP.get(ch) - 2* NUMBERS_MAP.get(numeral.charAt(i-1));
            }

            // Case 2: just add the corresponding number to result.
            else
                result += NUMBERS_MAP.get(ch);
        }

        return result;
    }

    /**
     * Convert int number into roman numeral
     * @param number, int number to convert
     * @return roman numeral as string
     */
    public static String toRomanNumeral(int number) throws OutOfBoundException {
        if(number <0 || number >= 4000){
            throw new OutOfBoundException();
        }

        //Declare each step
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        //Empty string
        StringBuilder roman = new StringBuilder();

        //For each value, decreasing
        for(int i=0;i<values.length;i++) {
            //If value appears multiple time
            while(number >= values[i]) {
                number -= values[i];
                roman.append(romanLiterals[i]);
            }
        }

        //Return value
        return roman.toString();
    }

}
