package com.dougdomingos.sorts.linear;

import com.dougdomingos.sorts.AbstractSort;

/**
 * The Counting Sort algorithm works by counting the frequency of each element
 * in the input array and then using this information to place each element in
 * its correct sorted position.
 * 
 * Time Complexity: O(n + k) | Space Complexity: O(k)
 * - n is the number of elements in the input array.
 * - k is the range of input values (maximum value - minimum value + 1).
 *
 * Stability: Stable
 */
public class CountingSort extends AbstractSort<Integer> {

    @Override
    public void sort(Integer[] array, int left, int right) {
        if ((left >= 0) && (right < array.length) && (left < right)
                && (array != null)) {
            int[] sorted = countingSort(array, left, right);

            for (int i = 0; i <= right; i++) {
                array[i] = sorted[i];
            }
        }
    }

    /**
     * Implementation of Counting Sort.
     * This implementation considers the smallest element of the array as the
     * first element of the sorted array. Thus,
     * the counting array size is given by: biggest - smallest + 1, where the +1
     * represents the space for zero.
     *
     * @param array
     *            The array to be sorted
     * @param leftIndex
     *            The low limit of the array
     * @param rightIndex
     *            The high limit of the array
     * @return An sorted copy of the array
     */
    private int[] countingSort(Integer[] array, int left, int right) {
        int biggest = array[getIndexBiggest(array, left, right)];
        int smallest = array[getIndexSmallest(array, left, right)];

        int[] counting = new int[biggest - smallest + 1];
        int[] sorted = new int[array.length];

        for (int i = 0; i <= right; i++) {
            counting[array[i] - smallest] += 1;
        }

        for (int j = 1; j < counting.length; j++) {
            counting[j] += counting[j - 1];
        }

        for (int c = right; c >= left; c--) {
            sorted[counting[array[c] - smallest] - 1] = array[c];
            counting[array[c] - smallest] -= 1;
        }

        return sorted;
    }

    /**
     * Find the index of the biggest value of the array.
     *
     * @param array
     *            The targeted array
     * @param leftIndex
     *            The low limit of the array
     * @param rightIndex
     *            The high limit of the array
     * @return The index of the biggest element
     */
    private int getIndexBiggest(Integer[] array, int leftIndex,
            int rightIndex) {
        int indexBiggest = leftIndex;

        for (int i = leftIndex + 1; i <= rightIndex; i++) {
            if (array[indexBiggest].compareTo(array[i]) < 0) {
                indexBiggest = i;
            }
        }

        return indexBiggest;
    }

    /**
     * Find the index of the smallest value of the array.
     *
     * @param array
     *            The targeted array
     * @param leftIndex
     *            The low limit of the array
     * @param rightIndex
     *            The high limit of the array
     * @return The index of the smallest element
     */
    private int getIndexSmallest(Integer[] array, int leftIndex,
            int rightIndex) {
        int indexSmallest = leftIndex;

        for (int i = leftIndex + 1; i <= rightIndex; i++) {
            if (array[indexSmallest].compareTo(array[i]) > 0) {
                indexSmallest = i;
            }
        }

        return indexSmallest;
    }

}
