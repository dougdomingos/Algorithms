package com.dougdomingos.sorts.selectionSort;

import com.dougdomingos.sorts.AbstractSort;
import com.dougdomingos.util.Util;

/**
 * Selection Sort.
 * 
 * The Selection Sort algorithm works by successfully putting the N-th smallest
 * element at the start of the unsorted partition of the array, until the array
 * is fully sorted.
 * 
 * Time complexity: O(n^2) | Space complexity: O(1)
 * Stability: Non-stable
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSort<T> {
    @Override
    public void sort(T[] array, int left, int right) {
        if (left >= right || left < 0 || right >= array.length)
            // Does nothing if the limits are invalid
            return;

        for (int i = left; i <= right; i++) {
            int smallest = i;

            for (int j = i + 1; j <= right; j++) {
                if (array[j].compareTo(array[smallest]) < 0)
                    smallest = j;
            }

            Util.swap(array, smallest, i);
        }
    }
}
