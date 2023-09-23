package com.dougdomingos.structures.linkedList;

/**
 * Interface for implementing a Linked List.
 */
public interface LinkedList<T> {

    /**
     * Insert an element at the end of the list.
     * 
     * @param element The element to be inserted
     */
    public void push(T element);

    /**
     * Removes a element from the list.
     * 
     * @param element The element to be removed
     */
    public void remove(T element);

    /**
     * Searches for an element in the list.
     * 
     * @param element The target element
     * @return The target element if its in the list or null, otherwise
     */
    public T search(T element);

    /**
     * Returns the number of elements in the list.
     * 
     * @return The number of elements in the list
     */
    public int size();

    /**
     * Returns an array with all elements in the list. The elements
     * are sorted following their order in the list.
     * 
     * @return An array with the elements of the list
     */
    public T[] toArray();
}
