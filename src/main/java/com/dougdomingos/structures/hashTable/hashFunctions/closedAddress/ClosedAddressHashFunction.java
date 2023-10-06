package com.dougdomingos.structures.hashTable.hashFunctions.closedAddress;

import com.dougdomingos.structures.hashTable.hashFunctions.HashFunction;

/**
 * Interface for implementing a closed address hash function.
 */
public interface ClosedAddressHashFunction<T> extends HashFunction {

    /**
     * Returns the hash of the element for a certain table size.
     * 
     * @param element   The element to be hashed
     * @param tableSize The size of the Hash Table
     * @return The calculated hash
     */
    public int hash(T element, int tableSize);
}
