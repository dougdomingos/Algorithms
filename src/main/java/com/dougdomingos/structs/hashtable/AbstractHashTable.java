package com.dougdomingos.structs.hashtable;

import com.dougdomingos.structs.hashtable.hashing.HashFunction;

/**
 * An abstract base class for implementing a Hash Table. This class provides
 * default implementation for the methods
 * `capacity`, `size`, `isEmpty` and `isFull`, given that the difference in the
 * tables will be the way they handle the
 * elements.
 *
 * @param <T>
 *            The type of value being stored in the table
 * @param <S>
 *            The type of hash function used in the table
 */
public abstract class AbstractHashTable<T, S extends HashFunction>
		implements HashTable<T> {

	/**
	 * The array representing the table.
	 */
	protected Object[] table;

	/**
	 * The number of collisions in the table.
	 */
	protected int COLLISIONS;

	/**
	 * The number of elements in the table.
	 */
	protected int elements;

	/**
	 * The hash function used in the table.
	 */
	protected S hashFunction;

	/**
	 * Creates a new Hash Table.
	 *
	 * @param capacity
	 *            The size of the table
	 */
	public AbstractHashTable(int capacity, S hashFunction) {
		this.table = new Object[capacity];
		this.COLLISIONS = 0;
		this.elements = 0;
		this.hashFunction = hashFunction;
	}

	@Override
	public int capacity() {
		return table.length;
	}

	@Override
	public int size() {
		return elements;
	}

	@Override
	public boolean isEmpty() {
		return elements == 0;
	}

	@Override
	public boolean isFull() {
		return elements == table.length;
	}

}
