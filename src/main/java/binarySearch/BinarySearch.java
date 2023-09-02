package binarySearch;

/**
 * Binary Search.
 * <p>
 * The Binary Search algorithm, given a previously sorted array, works by
 * successfully dividing the array by half. Then, it has three conditions:
 * 
 * - If the middle value is less than the target, repeat the binary search to
 *   the left half of the array
 * 
 * - If the middle value is greater than the target, repeat the binary search
 *   to the right half of the array
 * 
 * - If the middle value is equal to the target, return the index of the
 *   value
 */
public class BinarySearch<T extends Comparable<T>> extends AbstractSearch<Integer> {

    @Override
    public int search(Integer[] array, Integer target, int left, int right) {
        int low = left;
        int high = right;
        int middle = (low + high) / 2;
        int indexTarget = -1;

        // "breaks" the array in two until the limits cross
        // or the target value is found
        while (low <= high && indexTarget == -1) {
            if (target.compareTo(array[middle]) < 0) {
                high = middle;
                middle = (low + high) / 2;
            } else if (target.compareTo(array[middle]) > 0) {
                low = middle + 1;
                middle = (low + high) / 2;
            } else {
                indexTarget = middle;
            }
        }

        return indexTarget;
    }

}
