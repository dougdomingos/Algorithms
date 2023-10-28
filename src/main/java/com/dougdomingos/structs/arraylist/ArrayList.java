package com.dougdomingos.structs.arraylist;

/**
 * Implementation of a Array List.
 * <p>
 * An ArrayList is a linear data structure based on arrays, that resizes
 * when the array gets full.
 */
public class ArrayList<T> {

    /**
     * The array of elements.
     */
    private T[] elements;

    /**
     * The default capacity of the array, if none is provided.
     */
    private final int DEFAULT_CAPACITY = 50;

    /**
     * The number of elements in the array.
     */
    private int size = 0;

    /**
     * Create a new ArrayList with the default capacity.
     */
    @SuppressWarnings("unchecked")
    public ArrayList() {
        this.elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Create a new ArrayList with a custom capacity.
     * 
     * @param initialCapacity The initial capacity of the array
     */
    @SuppressWarnings("unchecked")
    public ArrayList(int initialCapacity) {
        this.elements = (T[]) new Object[initialCapacity];
    }

    /**
     * Inserts an element at the last position of the array.
     * 
     * @param element The element to be inserted
     */
    public void add(T element) {
        if (isFull()) {
            ensureCapacity(size + 1);
        }

        size++;
        elements[size - 1] = element;
    }

    /**
     * Inserts an element in a given position and shifts all values at the right by
     * one position.
     * 
     * @param index   The index where the element will be inserted
     * @param element The element to be inserted
     */
    public void addAt(int index, T element) {
        if (!isValidIndex(index)) {
            throw new IndexOutOfBoundsException("Index not valid!");
        }

        else if (isFull()) {
            ensureCapacity(size + 1);
        }

        size++;
        shiftRight(index);
        elements[index] = element;
    }

    /**
     * Replaces the element at a given position.
     * 
     * @param index   The index where the element will be inserted
     * @param element The element to be inserted
     */
    public void setAt(int index, T element) {
        if (!isValidIndex(index)) {
            throw new IndexOutOfBoundsException("Index not valid!");
        }

        elements[index] = element;
    }

    /**
     * Removes a given element from the array.
     * 
     * @param element The element to be removed
     */
    public T remove(T element) {
        if (element == null || isEmpty()) {
            return null;
        }

        T removed = null;
        int indexElement = indexOf(element);
        if (indexElement != -1) {
            removed = elements[indexElement];
            shiftLeft(indexElement);
            size--;
        }

        return removed;
    }

    /**
     * Removes the element from a given index in the array.
     * 
     * @param index The index for removal
     */
    public void remove(int index) {
        if (!isValidIndex(index)) {
            throw new IndexOutOfBoundsException("Index not valid!");
        }

        shiftLeft(index);
        size--;
    }

    /**
     * Searches for a given element in the array.
     * 
     * @param element The target element
     * @return The element or null if not found
     */
    public T search(T element) {
        if (element == null || isEmpty()) {
            return null;
        }

        T result = null;
        for (T item : elements) {
            if (element.equals(item)) {
                result = item;
                break;
            }
        }

        return result;
    }

    /**
     * Returns the index of an element in the array.
     * 
     * @param element The target element
     * @return The index of the element in the array, or null if not found
     */
    public int indexOf(T element) {
        if (element == null || isEmpty()) {
            return -1;
        }

        int result = -1;
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                result = i;
                break;
            }
        }

        return result;
    }

    /**
     * Checks if the array is empty.
     * 
     * @return A boolean value; true if the array is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the array is full.
     * 
     * @return A boolean value; true if the array is full, false otherwise
     */
    public boolean isFull() {
        return size == elements.length;
    }

    /**
     * Returns the number of elements in the array.
     */
    public int size() {
        return size;
    }

    /**
     * Ensures the array has at least the specified capacity.
     * 
     * @param minCapacity The minimum capacity to be ensured in the array
     */
    public void ensureCapacity(int minCapacity) {
        int currentCapacity = elements.length;

        if (minCapacity > currentCapacity) {
            resize(Math.max(minCapacity, currentCapacity * 2));
        }
    }

    /**
     * Resizes the array to a given capacity.
     * 
     * @param newCapacity The number of positions in the new array
     */
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];

        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }

        elements = newArray;
    }

    /**
     * Move elements from a given index to the left.
     * 
     * @param index The starting index
     */
    private void shiftLeft(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("No space for left shift!");
        }

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
    }

    /**
     * Move elements from a given index to the right.
     * 
     * @param index The starting index
     */
    private void shiftRight(int index) {
        if (index == elements.length) {
            throw new IndexOutOfBoundsException("No space for right shift!");
        }

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
    }

    /**
     * Checks if the provided index is within the array's limits.
     * 
     * @param index The provided index
     * @return A boolean value; true if the index is valid, false otherwise
     */
    private boolean isValidIndex(int index) {
        return (index >= 0) && (index < elements.length);
    }
}
