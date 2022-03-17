package fr.istic.vv;
import net.jqwik.api.*;
import net.jqwik.api.lifecycle.PerProperty;
import net.jqwik.api.lifecycle.PropertyExecutionResult;
import org.assertj.core.api.Assertions;
import org.opentest4j.TestAbortedException;

public class RomanNumeralTestOutOfBounds {

    /**
     * Test negative values for 'toRomanNumeral'
     * @param aNumber, number to test
     * @throws OutOfBoundException exception should be thrown
     */
    @Property
    @PerProperty(SucceedIfThrowsOutOfBoundError.class)
    void expectToFailNegative(@ForAll("negativeValues") int aNumber) throws OutOfBoundException {
        RomanNumeraUtils.toRomanNumeral(aNumber);
        throw new TestAbortedException();
     }

    /**
     * Test >= 4000 values for 'toRomanNumeral'
     * @param aNumber, number to test
     * @throws OutOfBoundException exception should be thrown
     */
    @Property
    @PerProperty(SucceedIfThrowsOutOfBoundError.class)
    void expectToFailOver4000(@ForAll("over4000") int aNumber) throws OutOfBoundException {
        RomanNumeraUtils.toRomanNumeral(aNumber);
        throw new TestAbortedException();
    }

    /**
     * Listener handling exception
     */
    private class SucceedIfThrowsOutOfBoundError implements PerProperty.Lifecycle {
        @Override
        public PropertyExecutionResult onFailure(PropertyExecutionResult propertyExecutionResult) {
            if (propertyExecutionResult.throwable().isPresent() &&
                    propertyExecutionResult.throwable().get() instanceof OutOfBoundException) {
                return propertyExecutionResult.mapToSuccessful();
            }
            return propertyExecutionResult;
        }
    }

    /**
     * Provider for negative input
     * @return list of negative integers
     */
    @Provide
    Arbitrary<Integer> negativeValues() {
        return Arbitraries.of(-2,-1);
    }

    /**
     * Provider for input over 4000 (incl.)
     * @return list of integers
     */
    @Provide
    Arbitrary<Integer> over4000() {
        return Arbitraries.of(4000,4001,5000,5002);
    }

}
