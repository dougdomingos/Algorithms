package com.dougdomingos.sorts.mergeSort;

import com.dougdomingos.sorts.AbstractSort;

/**
 * Merge Sort.
 * 
 * The Merge Sort algorithm works by dividing an array into two halves,
 * recursively sorting them, and then merges the sorted halves to produce a
 * sorted array.
 * 
 * Time Complexity: O(n * log n) | Space Complexity: O(1)
 * Stability: Non-stable
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSort<T> {

    @Override
    public void sort(T[] array, int left, int right) {
        if (left < 0 || right >= array.length || left >= right) {
            // does nothing if the limits are invalid
            return;
        }

        int middle = (left + right) / 2;
        sort(array, left, middle);
        sort(array, middle + 1, right);
        merge(array, left, middle, right);
    }

    /**
     * Merges two partitions of the array in non-decreasing order.
     * 
     * @param array  The targeted array
     * @param left   The start index of the left partition
     * @param middle The start index of the right partition
     * @param right  The end index of the right partition
     */
    @SuppressWarnings("unchecked")
    private void merge(T[] array, int left, int middle, int right) {
        // creates a copy of the original array
        T[] helper = (T[]) new Comparable[array.length];
        for (int i = 0; i < array.length; i++) {
            helper[i] = array[i];
        }

        // start indexes of the partitions
        int leftPart = left;
        int rightPart = middle + 1;
        int insertIndex = left;

        // inserts the values into the original array
        while ((leftPart <= middle) && (rightPart <= right)) {
            if (helper[leftPart].compareTo(helper[rightPart]) <= 0) {
                array[insertIndex] = helper[leftPart++];
            } else {
                array[insertIndex] = helper[rightPart++];
            }

            insertIndex++;
        }

        // inserts the remaining values of the left partition, if any
        while (leftPart <= middle) {
            array[insertIndex++] = helper[leftPart++];
        }

        // inserts the remaining values of the right partition, if any
        while (rightPart <= right) {
            array[insertIndex++] = helper[rightPart++];
        }
    }
}
