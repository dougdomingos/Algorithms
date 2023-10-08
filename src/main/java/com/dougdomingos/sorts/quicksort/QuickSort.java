package com.dougdomingos.sorts.quicksort;

import com.dougdomingos.sorts.AbstractSort;

/**
 * Quick Sort.
 * The Quick Sort algorithm works by choosing an arbitrary element of the array
 * (the pivot) and partition it in a way
 * that no element in the first partition is greater than any element of the
 * second partition.
 * Time Complexity: O(n * log n) | Space Complexity: O(1) Stability: non-stable
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSort<T> {

	@Override
	public void sort(T[] array, int left, int right) {
		if (left < 0 || right >= array.length || left >= right)
			// does nothing if the limits are invalid
			return;

		int indexPivot = lomutoPartition(array, left, right);
		sort(array, left, indexPivot - 1);
		sort(array, indexPivot + 1, right);
	}

	/**
	 * Implementation of the Lomuto's partition scheme.
	 *
	 * @return The final index of the pivot
	 */
	private int lomutoPartition(T[] array, int left, int right) {
		// move the chosen pivot to the start of the array
		int indexPivot = getRandomPivot(left, right);
		swap(array, left, indexPivot);
		indexPivot = left;

		// place the elements that are less than or equal to the pivot at its
		// right
		int indexLastSmallest = left;
		for (int i = left + 1; i <= right; i++) {
			if (array[i].compareTo(array[indexPivot]) <= 0) {
				indexLastSmallest++;
				swap(array, indexLastSmallest, i);
			}
		}

		// swap the pivot with the last smallest
		swap(array, indexPivot, indexLastSmallest);

		return indexLastSmallest;
	}

	/**
	 * Chooses a random pivot from the array.
	 *
	 * @return The index of the chosen pivot
	 */
	private int getRandomPivot(int left, int right) {
		int range = right - left + 1;

		return (int) (Math.random() * range) + left;
	}
}
