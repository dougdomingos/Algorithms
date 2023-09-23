package com.dougdomingos.sorts.bubbleSort;

import com.dougdomingos.sorts.AbstractSort;
import com.dougdomingos.util.Util;

/**
 * Bubble Sort.
 * 
 * The Bubble Sort algorithm works by successively pushing the biggest
 * elements to the end of the array, until the array is completely sorted.
 * 
 * Time Complexity: O(n^2) | Space Complexity: O(1) | Stability: stable
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSort<T> {

    @Override
    public void sort(T[] array, int left, int right) {
        boolean hasSwapped;
        int lastIndex = right;

        // keeps pushing elements until no swap occurs
        do {
            hasSwapped = false;

            // pushes the biggest element to the end of the partition
            for (int i = left; i < lastIndex; i++) {
                T nextElement = array[i + 1];

                if (array[i].compareTo(nextElement) > 0) {
                    Util.swap(array, i, i + 1);
                    hasSwapped = true;
                }
            }

            lastIndex--;
        } while (hasSwapped);
    }
}
