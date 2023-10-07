package com.dougdomingos.sorts.insertionSort;

import com.dougdomingos.sorts.AbstractSort;

/**
 * Insertion Sort.
 * The Insertion Sort algorithm works by iterating from the second element of
 * the array to the last. For each element,
 * it checks if its less than the previous and swaps their positions, until the
 * previous element is equal to or greater
 * than the current element.
 * Time Complexity: O(n^2) | Space Complexity: O(1) Stability: Stable
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSort<T> {

	@Override
	public void sort(T[] array, int left, int right) {
		// iterates from the 2nd position to the end of the partition
		for (int i = left + 1; i <= right; i++) {
			int indexSorted = i - 1;
			int indexValue = i;
			boolean isGreater = false;

			// shift the element to the left until the previous element is
			// smaller
			while (indexSorted >= 0 && !isGreater) {
				if (array[indexValue].compareTo(array[indexSorted]) < 0) {
					swap(array, indexValue, indexSorted);
					indexValue--;
				} else {
					isGreater = true;
				}

				indexSorted--;
			}
		}
	}

}
