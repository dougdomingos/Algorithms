package com.dougdomingos.structures.hashTable.hashing.closedAddress;

import com.dougdomingos.structures.hashTable.hashing.HashFunction;

/**
 * Interface for implementing a closed address hash function.
 */
public interface ClosedAddressHashing<T> extends HashFunction {

	/**
	 * Returns the hash of the element for a certain table size.
	 *
	 * @param element
	 *            The element to be hashed
	 * @param tableSize
	 *            The size of the Hash Table
	 * @return The calculated hash
	 */
	public int hash(T element, int tableSize);
}
