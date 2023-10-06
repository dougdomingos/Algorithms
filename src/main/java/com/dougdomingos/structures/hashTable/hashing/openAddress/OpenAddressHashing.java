package com.dougdomingos.structures.hashTable.hashing.openAddress;

import com.dougdomingos.structures.hashTable.hashing.HashFunction;

/**
 * Interface for implementing a open address hash function.
 */
public interface OpenAddressHashing<T> extends HashFunction {

    /**
     * Returns the hash of the element for a certain table size and probe index.
     * 
     * @param element    The element to be hashed
     * @param tableSize  The size of the table
     * @param probeIndex The current probe index for collision resolution
     * @return The calculated hash
     */
    public int hash(T element, int tableSize, int probeIndex);
}
