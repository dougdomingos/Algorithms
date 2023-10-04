package com.dougdomingos.structures.hashTable;

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
    private T[] table;

    /**
     * The number of collisions in the table.
     */
    private int COLLISIONS;

    /**
     * The number of elements in the table.
     */
    private int elements;

    /**
     * TODO: Create class for hash functions
     * The hash function used in the table.
     */
    private Object hashFunction;

    /**
     * Creates a new Hash Table.
     * 
     * @param capacity The size of the table
     */
    public AbstractHashTable(int capacity) {
        this.table = (T[]) new Object[capacity];
        this.COLLISIONS = 0;
        this.elements = 0;
        this.hashFunction = null;
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
