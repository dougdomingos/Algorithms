package com.dougdomingos.structs.linkedlist;

import com.dougdomingos.structs.StructureUnderflowException;

/**
 * Interface for implementing a Linked List.
 */
public interface LinkedList<T> {

	/**
	 * Insert an element at the start of the list.
	 *
	 * @param element
	 *            The element to be inserted
	 */
	public void insertFirst(T element);

	/**
	 * Insert an element at the end of the list.
	 *
	 * @param element
	 *            The element to be inserted
	 */
	public void insertLast(T element);

	/**
	 * Insert an element at a given index.
	 *
	 * @param element
	 *            The element to be inserted
	 * @param index
	 *            The index where the element will be inserted
	 */
	public void insert(T element, int index);

	/**
	 * Removes a element from the list.
	 *
	 * @param element
	 *            The element to be removed
	 */
	public void remove(T element) throws StructureUnderflowException;

	/**
	 * Checks if an element is in the list.
	 *
	 * @param element
	 *            The target element
	 * @return A boolean value; true if the value is in the list, false
	 *         otherwise
	 */
	public boolean contains(T element);

	/**
	 * Returns the index of an element in the list.
	 *
	 * @param element
	 *            The target element
	 * @return The index of the element or -1 if not on the list
	 */
	public int indexOf(T element);

	/**
	 * Returns the first element of the list.
	 *
	 * @return The element at the start of the list
	 */
	public T peekFirst();

	/**
	 * Returns the last element of the list.
	 *
	 * @return The element at the end of the list
	 */
	public T peekLast();

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
	 * Returns an array with all elements in the list. The elements are sorted
	 * following their order in the list.
	 *
	 * @return An array with the elements of the list
	 */
	public T[] toArray();
}
