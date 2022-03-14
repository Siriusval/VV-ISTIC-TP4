package fr.istic.vv;
import net.jqwik.api.*;

import java.util.List;

public class RomanNumeralTest {

    //Ending with 1 - I
    @Property
    boolean every_number_endingWith1_end_with_I(@ForAll("endingWith1") int i) {
        return RomanNumeraUtils.toRomanNumeral(i).endsWith("I");
    }
    @Provide
    Arbitrary<Integer> endingWith1() throws Exception {
        return endingWith(1);
    }

    //Ending with 2 - II
    @Property
    boolean every_number_endingWith2_end_with_II(@ForAll("endingWith2") int i) {
        return RomanNumeraUtils.toRomanNumeral(i).endsWith("II");
    }
    @Provide
    Arbitrary<Integer> endingWith2() throws Exception {
        return endingWith(2);
    }

    //Ending with 3 - III
    @Property
    boolean every_number_endingWith3_end_with_III(@ForAll("endingWith3") int i) {
        return RomanNumeraUtils.toRomanNumeral(i).endsWith("III");
    }
    @Provide
    Arbitrary<Integer> endingWith3() throws Exception {
        return endingWith(3);
    }

    //Ending with 4 - IV
    @Property
    boolean every_number_endingWith4_end_with_IV(@ForAll("endingWith4") int i) {
        return RomanNumeraUtils.toRomanNumeral(i).endsWith("IV");
    }
    @Provide
    Arbitrary<Integer> endingWith4() throws Exception {
        return endingWith(4);
    }

    //Ending with 5 - V
    @Property
    boolean every_number_endingWith5_end_with_V(@ForAll("endingWith5") int i) {
        return RomanNumeraUtils.toRomanNumeral(i).endsWith("V");
    }
    @Provide
    Arbitrary<Integer> endingWith5() throws Exception {
        return endingWith(5);
    }

    //Ending with 6 - VI
    @Property
    boolean every_number_endingWith6_end_with_VI(@ForAll("endingWith6") int i) {
        return RomanNumeraUtils.toRomanNumeral(i).endsWith("VI");
    }
    @Provide
    Arbitrary<Integer> endingWith6() throws Exception {
        return endingWith(6);
    }

    //Ending with 7 - VII
    @Property
    boolean every_number_endingWith7_end_with_VII(@ForAll("endingWith7") int i) {
        return RomanNumeraUtils.toRomanNumeral(i).endsWith("VII");
    }
    @Provide
    Arbitrary<Integer> endingWith7() throws Exception {
        return endingWith(7);
    }

    //Ending with 8 - VIII
    @Property
    boolean every_number_endingWith8_end_with_VIII(@ForAll("endingWith8") int i) {
        return RomanNumeraUtils.toRomanNumeral(i).endsWith("VIII");
    }
    @Provide
    Arbitrary<Integer> endingWith8() throws Exception {
        return endingWith(8);
    }

    //Ending with 9 - IX
    @Property
    boolean every_number_endingWith9_end_with_IX(@ForAll("endingWith9") int i) {
        return RomanNumeraUtils.toRomanNumeral(i).endsWith("IX");
    }
    @Provide
    Arbitrary<Integer> endingWith9() throws Exception {
        return endingWith(9);
    }

    //Ending with 10 - X
    @Property
    boolean every_number_endingWith10_end_with_X(@ForAll("endingWith10") int i) {
        return RomanNumeraUtils.toRomanNumeral(i).endsWith("X");
    }
    @Provide
    Arbitrary<Integer> endingWith10() throws Exception {
        return Arbitraries.of(10,20,30,60,70,80,110);
    }

    /**
     * Helper method to generate all numbers from 1 -> 10x ending with 'number'
     * @param number is in bound 0 < x < 10
     * @return list of numbers ending with 'number'
     * @throws Exception if requested number is out of bound
     */
    private Arbitrary<Integer> endingWith(int number) throws Exception {
        if(number <= 0 || number > 9){
            throw new Exception("Out of bound");
        }
        return Arbitraries.integers().between(number, 100 + number).filter(i -> i % 10 == number);
    }
}
