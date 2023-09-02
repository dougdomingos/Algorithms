package binarySearch;

/**
 * Interface for implementing a searching algorithm.
 * 
 * @param <T> The type of objects in the array
 */
public interface Searching<T> {

    /**
     * Executes the search algorithm.
     * 
     * @param array  The target array of the algorithm
     * @param target The value that we want to find
     * @return The index of the value in the array, or -1 if the value is not found
     */
    public int search(T[] array, T target);
}
