package com.dougdomingos.binarysearch;

public abstract class AbstractSearch<T> implements Searching<T> {

	@Override
	public int search(T[] array, T target) {
		return search(array, target, 0, array.length - 1);
	}

	/**
	 * Searchs for a given value in an arbitrary closed interval.
	 *
	 * @param array
	 *            The target array of the algorithm
	 * @param target
	 *            The value that we want to find
	 * @param left
	 *            The start index of the sort
	 * @param right
	 *            The end index of the sort
	 * @return The index of the value, of -1 if the value is not found
	 */
	public abstract int search(T[] array, T target, int left, int right);
}
