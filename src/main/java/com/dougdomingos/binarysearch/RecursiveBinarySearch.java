package com.dougdomingos.binarysearch;

/**
 * Recursive Binary Search.
 * <p>
 * The Binary Search algorithm, given a previously sorted array, works by
 * successfully dividing the array by half. Then,
 * it has three conditions:
 * - If the middle value is less than the target, repeat the binary search to
 * the left half of the array
 * - If the middle value is greater than the target, repeat the binary search to
 * the right half of the array
 * - If the middle value is equal to the target, return the index of the value
 * This implementation uses the recursive approach.
 */
public class RecursiveBinarySearch<T extends Comparable<T>>
		extends AbstractSearch<T> {

	@Override
	public int search(T[] array, T target, int left, int right) {
		int index = -1;

		if (left <= right) {
			int middle = (left + right) / 2;

			if (target.compareTo(array[middle]) < 0) {
				index = search(array, target, left, middle);
			} else if (target.compareTo(array[middle]) > 0) {
				index = search(array, target, middle + 1, right);
			} else {
				index = middle;
			}
		}

		return index;
	}

}
