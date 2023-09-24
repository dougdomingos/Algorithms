package com.dougdomingos.structures.linkedList;

import com.dougdomingos.structures.StructureUnderflowException;

/**
 * Interface for implementing a Linked List.
 */
public interface LinkedList<T> {

    /**
     * Insert an element at the start of the list.
     * 
     * @param element The element to be inserted
     */
    public void insertFirst(T element);

    /**
     * Insert an element at the end of the list.
     * 
     * @param element The element to be inserted
     */
    public void insertLast(T element);

    /**
     * Insert an element at a given point of the list.
     * 
     * @param element The element to be inserted
     */
    public void insertAt(T element, int index);

    /**
     * Removes the first element from the list.
     * 
     * @return The removed element
     */
    public T removeFirst() throws StructureUnderflowException;

    /**
     * Removes the last element from the list.
     * 
     * @return The removed element
     */
    public T removeLast() throws StructureUnderflowException;

    /**
     * Removes a element from the list.
     * 
     * @param element The element to be removed
     * @return A boolean value; true if the value was found and removed, false
     *         otherwise
     */
    public boolean remove(T element) throws StructureUnderflowException;

    /**
     * Returns the index of a given element in the list.
     * 
     * @param element The target element
     * @return The index of the element in the list (-1 if the value is not found)
     */
    public int indexOf(T element);

    /**
     * Checks if an element is in the list.
     * 
     * @param element The target element
     * @return A boolean value; true if the value is in the list, false otherwise
     */
    public boolean contains(T element);

    /**
     * Returns the number of elements in the list.
     * 
     * @return The number of elements in the list
     */
    public int size();

    /**
     * Checks if the list is empty.
     * 
     * @return A boolean value; true if the list is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Returns an array with all elements in the list. The elements
     * are sorted following their order in the list.
     * 
     * @return An array with the elements of the list
     */
    public T[] toArray();
}
