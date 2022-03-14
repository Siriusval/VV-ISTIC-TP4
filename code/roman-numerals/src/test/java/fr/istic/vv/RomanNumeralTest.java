package fr.istic.vv;
import net.jqwik.api.*;

public class RomanNumeralTest {

    @Property
    boolean absoluteValueOfAllNumbersIsPositive(@ForAll int anInteger) {
        return Math.abs(anInteger) >= 0;
    }

    //Ending with 1 - I
    @Property
    boolean every_number_endingWith1_end_with_I(@ForAll("endingWith1") int i) {
        return RomanNumeraUtils.toRomanNumeral(i).endsWith("I");
    }

    @Provide
    Arbitrary<Integer> endingWith1() {
        return Arbitraries.integers().between(1, 101).filter(i -> i % 10 == 1);
    }
}
