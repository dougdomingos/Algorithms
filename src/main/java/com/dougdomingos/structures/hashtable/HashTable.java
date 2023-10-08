package com.dougdomingos.structures.hashtable;

import com.dougdomingos.structures.StructureOverflowException;
import com.dougdomingos.structures.StructureUnderflowException;

/**
 * Interface for implementing a Hash Table.
 */
public interface HashTable<T> {

	/**
	 * Inserts an element in the table.
	 *
	 * @param element
	 *            The element to be inserted
	 * @throws StructureOverflowException
	 *             thrown if the table is full
	 */
	public void insert(T element) throws StructureOverflowException;

	/**
	 * Removes an element of the table.
	 *
	 * @param element
	 *            The element to be removed
	 * @throws StructureUnderflowException
	 *             thrown if the table is empty
	 */
	public void remove(T element) throws StructureUnderflowException;

	/**
	 * Checks if a given element is present in the table.
	 *
	 * @param element
	 *            The target element
	 * @return A boolean value; true if the element is in the table, false
	 *         otherwise
	 */
	public boolean contains(T element);

	/**
	 * Returns the index of a given element in the table.
	 *
	 * @param element
	 *            The target element
	 * @return The index of the element in the table, or -1 if not in the table
	 */
	public int indexOf(T element);

	/**
	 * Returns the number of elements in the table.
	 *
	 * @return The number of elements in the table.
	 */
	public int size();

	/**
	 * Returns the maximum size of the table.
	 *
	 * @return The maximum size of the table.
	 */
	public int capacity();

	/**
	 * Checks if the table is full.
	 *
	 * @return A boolean value; true if the table is full, false otherwise
	 */
	public boolean isFull();

	/**
	 * Checks if the table is empty.
	 *
	 * @return A boolean value; true if the table is empty, false otherwise
	 */
	public boolean isEmpty();

}
