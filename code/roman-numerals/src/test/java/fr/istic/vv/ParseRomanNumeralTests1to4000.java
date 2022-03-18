package fr.istic.vv;
import net.jqwik.api.*;

public class ParseRomanNumeralTests1to4000 {

    //Ending with 1 - I
    @Property
    boolean every_number_from_one_to_four_thousands(@ForAll("oneTo4000") int i) throws OutOfBoundException {
        String romanNumeral = RomanNumeraUtils.toRomanNumeral(i);
        Integer backToInt = RomanNumeraUtils.parseRomanNumeral(romanNumeral);
        
        //System.out.println(i+"\t-> "+romanNumeral+"\t->"+backToInt);
        return backToInt.equals(i);
    }
    @Provide
    Arbitrary<Integer> oneTo4000() throws Exception {
        return Arbitraries.integers().between(1,3999);
    }


}
