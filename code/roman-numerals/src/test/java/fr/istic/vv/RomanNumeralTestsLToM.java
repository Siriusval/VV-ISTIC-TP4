package fr.istic.vv;
import net.jqwik.api.*;

public class RomanNumeralTestsLToM {

    /* ----------
   ENDINGS WITH 10
    ---------- */
    //Ending with 10 - X
    @Property
    boolean every_number_endingWith10_end_with_X(@ForAll("endingWith10") int i) {
        return RomanNumeraUtils.toRomanNumeral(i).endsWith("X");
    }
    @Provide
    Arbitrary<Integer> endingWith10() throws Exception {
        return Arbitraries.of(10,20,30,60,70,80,110);
    }

    /* ----------
   ENDINGS WITH 50
       ---------- */
    //Ending with 50 - L
    @Property
    boolean every_number_endingWith50_end_with_L(@ForAll("endingWith50") int i) {
        return RomanNumeraUtils.toRomanNumeral(i).endsWith("L");
    }
    @Provide
    Arbitrary<Integer> endingWith50() throws Exception {
        return Arbitraries.of(50,150,250,350,450,550,650,750,850,950);
    }

    /* ----------
   ENDINGS WITH 100
       ---------- */
    //Ending with 100 - C
    @Property
    boolean every_number_endingWith100_end_with_C(@ForAll("endingWith100") int i) {
        return RomanNumeraUtils.toRomanNumeral(i).endsWith("C");
    }
    @Provide
    Arbitrary<Integer> endingWith100() throws Exception {
        return Arbitraries.of(100,200,300,600,700,800);
    }

    /* ----------
       ENDINGS WITH 500
           ---------- */
    //Ending with 500 - D
    @Property
    boolean every_number_endingWith500_end_with_C(@ForAll("endingWith500") int i) {
        return RomanNumeraUtils.toRomanNumeral(i).endsWith("D");
    }
    @Provide
    Arbitrary<Integer> endingWith500() throws Exception {
        return Arbitraries.of(500,1500,2500,3500);
    }

    /* ----------
       ENDINGS WITH 1000
           ---------- */
    //Ending with 1000 - M
    @Property
    boolean every_number_endingWith1000_end_with_C(@ForAll("endingWith1000") int i) {
        return RomanNumeraUtils.toRomanNumeral(i).endsWith("M");
    }
    @Provide
    Arbitrary<Integer> endingWith1000() throws Exception {
        return Arbitraries.of(1000,2000,3000);
    }

}
