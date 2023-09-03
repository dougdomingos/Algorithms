package sorts.quickSort;

import sorts.AbstractSort;
import util.Util;

/**
 * Quick Sort.
 * <p>
 * The Quick Sort algorithm works by choosing an arbitrary element
 * of the array (the pivot) and partition it in a way that no element
 * in the first partition is greater than any elemento of the second
 * partition.
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
        Util.swap(array, left, indexPivot);
        indexPivot = left;

        // place the elements that are less than or equal to the pivot at its right
        int indexLastSmallest = left;
        for (int i = left + 1; i <= right; i++) {
            if (array[i].compareTo(array[indexPivot]) <= 0) {
                indexLastSmallest++;
                Util.swap(array, indexLastSmallest, i);
            }
        }

        // swap the pivot with the last smallest
        Util.swap(array, indexPivot, indexLastSmallest);

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
