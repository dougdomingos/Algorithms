package sorts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sorts.selectionSort.SelectionSort;

import java.util.Arrays;

/**
 * Generic test class for sorting algorithms.
 */
public class SortsTest {

    /**
     * The algorithm under testing.
     */
    private AbstractSort<Integer> algorithm;

    private final Integer[] positives = {57, 12, 89, 34, 76, 23, 41, 65, 98, 5};

    private final Integer[] negatives = {-45, -78, -92, -6, -23, -67, -34, -89, -56, -10};

    private final Integer[] mixed = {-75, 56, 18, -91, 30, -42, 84, -27, 63, -9};

    private final Integer[] evenSize = {25, -48, 13, 76, -11, 16};

    private final Integer[] oddSize = {-89, 42, -5, 67, 29};

    private final Integer[] repeated = {7, 7, 2, 1, 4, 2, 7, 8, 8, 4, 9};

    private final Integer[] empty = {};

    /**
     * Create an instance of the algorithm for testing.
     */
    @BeforeEach
    void setUp() {
        // Change the algorithm to test other sorts
        this.algorithm = new SelectionSort<>();
    }

    @Test
    public void testPositives() {
        runSortTest(positives);
    }

    @Test
    public void testNegatives() {
        runSortTest(negatives);
    }

    @Test
    public void testMixed() {
        runSortTest(mixed);
    }

    @Test
    public void testEvenSize() {
        runSortTest(evenSize);
    }

    @Test
    public void testOddSize() {
        runSortTest(oddSize);
    }

    @Test
    public void testRepeated() {
        runSortTest(repeated);
    }

    @Test
    public void testEmpty() {
        runSortTest(empty);
    }

    /**
     * Tests if the algorithm correctly sorts the array.
     *
     * @param array The target array of the algorithm
     */
    private void runSortTest(Integer[] array) {
        Integer[] copy = Arrays.copyOf(array, array.length);

        algorithm.sort(array);
        Arrays.sort(copy);

        Assertions.assertArrayEquals(array, copy);
    }
}

