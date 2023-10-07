package com.dougdomingos.sorts.shakerSort;

import com.dougdomingos.sorts.AbstractSort;

/**
 * Shaker Sort.
 * Shaker Sort, also known as Bidirectional Bubble Sort or Cocktail Shaker Sort,
 * is a variation of the Bubble Sort
 * algorithm. It works by repeatedly stepping through the list, comparing
 * adjacent elements in both directions, and
 * swapping them if they are in the wrong order until the entire array is
 * sorted.
 * Time Complexity: O(n^2) | Space Complexity: O(1) Stability: Stable
 */
public class ShakerSort<T extends Comparable<T>> extends AbstractSort<T> {

	@Override
	public void sort(T[] array, int left, int right) {
		boolean hasSwapped;
		int high = right;
		int low = left;

		// keeps pushing elements until no swap occurs
		do {
			hasSwapped = false;

			// pushes the biggest element to the end of the partition
			for (int i = left; i < high; i++) {
				T nextElement = array[i + 1];

				if (array[i].compareTo(nextElement) > 0) {
					swap(array, i, i + 1);
					hasSwapped = true;
				}
			}

			// pushes the smallest element to the start of the partition
			for (int i = right; i > low; i--) {
				T previousElement = array[i - 1];

				if (array[i].compareTo(previousElement) < 0) {
					swap(array, i, i - 1);
					hasSwapped = true;
				}
			}

			high--;
			low++;
		} while (hasSwapped);
	}
}
