package com.dougdomingos.util;

/**
 * Utility methods for array manipulation.
 */
public class Util {

    /**
     * Swaps the elements of two positions in an array;
     *
     * @param array The array to be modified
     * @param i     First target position
     * @param j     Second target position
     */
    public static void swap(Object[] array, int i, int j) {
        if (array == null)
            throw new IllegalArgumentException("Array is null");

        Object tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
