package com.dougdomingos.structures.hashTable;

import com.dougdomingos.structures.hashTable.hashFunctions.HashFunction;

/**
 * An abstract base class for implementing a Hash Table.
 * 
 * This class provides default implementation for the methods `capacity`,
 * `size`, `isEmpty` and `isFull`, given that the difference in the tables
 * will be the way they handle the elements.
 */
public abstract class AbstractHashTable<T> implements HashTable<T> {

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
    protected HashFunction hashFunction;

    /**
     * Creates a new Hash Table.
     * 
     * @param capacity The size of the table
     */
    public AbstractHashTable(int capacity, HashFunction hashFunction) {
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
