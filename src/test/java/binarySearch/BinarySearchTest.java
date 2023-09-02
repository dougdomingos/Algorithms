package binarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Generic test class for binary search algorithms.
 */
public class BinarySearchTest {

    /**
     * The algorithm under testing.
     */
    private AbstractSearch<Integer> algorithm;

    private final Integer[] mixedValues = { -91, -75, -42, -27, -9, 18, 30, 56, 63, 84 };

    private final Integer[] evenSize = { -48, -11, 13, 16, 25, 76 };

    private final Integer[] oddSize = { -89, -5, 29, 42, 67 };

    private final Integer[] empty = {};

    /**
     * Create an instance of the algorithm for testing.
     */
    @BeforeEach
    void setUp() {
        // Change the algorithm to test other sorts
        this.algorithm = new BinarySearch<>();
    }

    @Test
    public void testMixedValues() {
        runSearchTest(mixedValues, 30, 6);
    }

    @Test
    public void testEvenSize() {
        runSearchTest(evenSize, 16, 3);
    }

    @Test
    public void testOddSize() {
        runSearchTest(oddSize, 29, 2);
    }

    @Test
    public void testEmpty() {
        runSearchTest(empty, 0, -1);
    }

    @Test
    public void testValueOnLeftLimit() {
        runSearchTest(mixedValues, -91, 0);
    }
    
    @Test
    public void testValueOnRightLimit() {
        runSearchTest(mixedValues, 84, 9);
    }

    /**
     * Tests if the algorithm works as expected.
     * 
     * @param array    The target array of the algorithm
     * @param target   The value we want to find
     * @param expected The expected return of the algorithm
     */
    private void runSearchTest(Integer[] array, Integer target, Integer expected) {
        int indexTarget = algorithm.search(array, target);

        Assertions.assertEquals(expected, indexTarget);
    }
}
