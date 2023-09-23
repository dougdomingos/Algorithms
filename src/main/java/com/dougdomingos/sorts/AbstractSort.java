package com.dougdomingos.sorts;

public abstract class AbstractSort<T extends Comparable<T>> implements Sorting<T> {
    @Override
    public void sort(T[] array) {
        sort(array, 0, array.length - 1);
    }

    /**
     * Sorts the array at an arbitrary closed interval.
     *
     * @param array The target array of the algorithm
     * @param left  The start index of the sort
     * @param right The end index of the sort
     */
    public abstract void sort(T[] array, int left, int right);
}
