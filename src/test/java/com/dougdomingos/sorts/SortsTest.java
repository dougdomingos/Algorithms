package com.dougdomingos.sorts;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.dougdomingos.sorts.linear.CountingSort;
import com.dougdomingos.sorts.logarithmic.MergeSort;
import com.dougdomingos.sorts.logarithmic.QuickSort;
import com.dougdomingos.sorts.quadratic.BubbleSort;
import com.dougdomingos.sorts.quadratic.InsertionSort;
import com.dougdomingos.sorts.quadratic.SelectionSort;
import com.dougdomingos.sorts.quadratic.ShakerSort;

/**
 * Generic test class for sorting algorithms.
 */
public class SortsTest {

	private final Integer[] positives = { 57, 12, 89, 34, 76, 23, 41, 65, 98,
			5 };

	private final Integer[] negatives = { -45, -78, -92, -6, -23, -67, -34, -89,
			-56, -10 };

	private final Integer[] mixed = { -75, 56, 18, -91, 30, -42, 84, -27, 63,
			-9 };

	private final Integer[] evenSize = { 25, -48, 13, 76, -11, 16 };

	private final Integer[] oddSize = { -89, 42, -5, 67, 29 };

	private final Integer[] repeated = { 7, 7, 2, 1, 4, 2, 7, 8, 8, 4, 9 };

	private final Integer[] empty = {};

	@ParameterizedTest
	@MethodSource("sorts")
	public void testPositives(AbstractSort<Integer> algorithm) {
		runSortTest(algorithm, positives);
	}

	@ParameterizedTest
	@MethodSource("sorts")
	public void testNegatives(AbstractSort<Integer> algorithm) {
		runSortTest(algorithm, negatives);
	}

	@ParameterizedTest
	@MethodSource("sorts")
	public void testMixed(AbstractSort<Integer> algorithm) {
		runSortTest(algorithm, mixed);
	}

	@ParameterizedTest
	@MethodSource("sorts")
	public void testEvenSize(AbstractSort<Integer> algorithm) {
		runSortTest(algorithm, evenSize);
	}

	@ParameterizedTest
	@MethodSource("sorts")
	public void testOddSize(AbstractSort<Integer> algorithm) {
		runSortTest(algorithm, oddSize);
	}

	@ParameterizedTest
	@MethodSource("sorts")
	public void testRepeated(AbstractSort<Integer> algorithm) {
		runSortTest(algorithm, repeated);
	}

	@ParameterizedTest
	@MethodSource("sorts")
	public void testEmpty(AbstractSort<Integer> algorithm) {
		runSortTest(algorithm, empty);
	}

	/**
	 * Tests if the algorithm correctly sorts the array.
	 *
	 * @param array
	 *            The target array of the algorithm
	 */
	private void runSortTest(AbstractSort<Integer> algorithm, Integer[] array) {
		Integer[] copy = Arrays.copyOf(array, array.length);

		algorithm.sort(array);
		Arrays.sort(copy);

		Assertions.assertArrayEquals(array, copy);
	}

	/**
	 * Set up the algorithms to be tested.
	 *
	 * @return A stream with the targeted algorithms
	 */
	private static Stream<AbstractSort<Integer>> sorts() {
		return Stream.of(new SelectionSort<>(), new InsertionSort<>(),
				new BubbleSort<>(), new ShakerSort<>(),
				new QuickSort<>(), new MergeSort<>(), new CountingSort());
	}
}
