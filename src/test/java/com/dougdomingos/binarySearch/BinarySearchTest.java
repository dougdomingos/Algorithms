package com.dougdomingos.binarySearch;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Generic test class for binary search algorithms.
 */
public class BinarySearchTest {

	private final Integer[] mixedValues = { -91, -75, -42, -27, -9, 18, 30, 56,
			63, 84 };

	private final Integer[] evenSize = { -48, -11, 13, 16, 25, 76 };

	private final Integer[] oddSize = { -89, -5, 29, 42, 67 };

	private final Integer[] empty = {};

	@ParameterizedTest
	@MethodSource("searchs")
	public void testMixedValues(AbstractSearch<Integer> algorithm) {
		runSearchTest(algorithm, mixedValues, 30, 6);
	}

	@ParameterizedTest
	@MethodSource("searchs")
	public void testEvenSize(AbstractSearch<Integer> algorithm) {
		runSearchTest(algorithm, evenSize, 16, 3);
	}

	@ParameterizedTest
	@MethodSource("searchs")
	public void testOddSize(AbstractSearch<Integer> algorithm) {
		runSearchTest(algorithm, oddSize, 29, 2);
	}

	@ParameterizedTest
	@MethodSource("searchs")
	public void testEmpty(AbstractSearch<Integer> algorithm) {
		runSearchTest(algorithm, empty, 0, -1);
	}

	@ParameterizedTest
	@MethodSource("searchs")
	public void testValueOnLeftLimit(AbstractSearch<Integer> algorithm) {
		runSearchTest(algorithm, mixedValues, -91, 0);
	}

	@ParameterizedTest
	@MethodSource("searchs")
	public void testValueOnRightLimit(AbstractSearch<Integer> algorithm) {
		runSearchTest(algorithm, mixedValues, 84, 9);
	}

	/**
	 * Tests if the algorithm works as expected.
	 *
	 * @param array
	 *            The target array of the algorithm
	 * @param target
	 *            The value we want to find
	 * @param expected
	 *            The expected return of the algorithm
	 */
	private void runSearchTest(AbstractSearch<Integer> algorithm,
			Integer[] array, Integer target, Integer expected) {
		int indexTarget = algorithm.search(array, target);

		Assertions.assertEquals(expected, indexTarget);
	}

	/**
	 * Set up the algorithms to be tested.
	 *
	 * @return A stream with the targeted algorithms
	 */
	private static Stream<AbstractSearch<Integer>> searchs() {
		return Stream.of(new BinarySearch<>(), new RecursiveBinarySearch<>());
	}
}
