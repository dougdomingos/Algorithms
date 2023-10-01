package com.dougdomingos.sorts;

/**
 * An abstract base class for implementing a sorting algorithm.
 * 
 * This class provides a default `sort` method (that sorts the entire array) and
 * an abstract `sort` method that sorts a specified interval within the array.
 */
public abstract class AbstractSort<T extends Comparable<T>> implements Sorting<T> {

    @Override
    public void sort(T[] array) {
        sort(array, 0, array.length - 1);
    }

    /**
     * Sorts the array within an arbitrary closed interval.
     *
     * @param array The target array of the algorithm
     * @param left  The start index of the sort
     * @param right The end index of the sort
     */
    public abstract void sort(T[] array, int left, int right);

    /**
     * Swaps the elements of two positions in an array;
     *
     * @param array The array to be modified
     * @param i     First target position
     * @param j     Second target position
     */
    protected void swap(T[] array, int i, int j) {
        if (array == null)
            throw new IllegalArgumentException("Array is null");

        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
