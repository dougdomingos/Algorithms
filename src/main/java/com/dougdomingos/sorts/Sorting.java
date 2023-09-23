package com.dougdomingos.sorts;

/**
 * Interface for implementing a sorting algorithm.
 *
 * @param <T> The type of objects in the array
 */
public interface Sorting<T extends Comparable<T>> {

    /**
     * Sorts the array in increasing order.
     *
     * @param array The target array of the algorithm
     */
    public void sort(T[] array);
}
