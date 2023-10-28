package com.dougdomingos.structs.heap;

/**
 * Implementation of a Heap.
 * <p>
 * A Heap, also known as a Priority Queue, is a tree-based structure in which
 * every element is greater than their children.On the other hand, in a Min Heap
 * implementation, every element is smaller than their children.
 */
public class Heap<T extends Comparable<T>> {

    /**
     * The array representing the heap.
     */
    private T[] heap;

    /**
     * The index of the last element of the heap.
     */
    private int tail = -1;

    /**
     * Create a new empty heap.
     * 
     * @param capacity The starting capacity of the heap
     */
    @SuppressWarnings("unchecked")
    public Heap(int capacity) {
        this.heap = (T[]) new Comparable[capacity];
    }

    /**
     * Create a new heap from a array of elements.
     * 
     * @param elements The elements to be stored in the heap
     */
    public Heap(T[] elements) {
        this.heap = elements;
        buildHeap();
    }

    /**
     * Inserts an element into the heap.
     * 
     * @param element The element to be inserted
     */
    public void insert(T element) {
        if (tail + 1 == heap.length) {
            resize();
        }

        heap[++tail] = element;

        int elementIndex = tail;
        while (elementIndex > 0
                && (heap[elementIndex].compareTo(heap[parent(elementIndex)]) > 0)) {

            swap(elementIndex, parent(elementIndex));
            elementIndex = parent(elementIndex);
        }
    }

    /**
     * Removes the root element of the heap.
     * 
     * @return The root element of the heap, or null if empty
     */
    public T remove() {
        if (isEmpty()) {
            return null;
        }

        T removed = heap[0];
        heap[0] = heap[tail--];

        heapify(0);

        return removed;
    }

    /**
     * Checks if the heap is empty.
     * 
     * @return A boolean value; true if the heap is empty, false otherwise
     */
    public boolean isEmpty() {
        return tail == -1;
    }

    /**
     * Returns the number of elements in the heap.
     * 
     * @return The number of elements in the heap
     */
    public int size() {
        return tail + 1;
    }

    /**
     * Corrects any elements in the wrong positions.
     * 
     * @param index The index from where the heapify will begin
     */
    private void heapify(int index) {
        if (isLeaf(index) || !isValidIndex(index)) {
            return;
        }

        int maxIndex = getIndexMaxElement(left(index), index, right(index));

        if (maxIndex != index) {
            swap(index, maxIndex);
            heapify(maxIndex);
        }
    }

    /**
     * Ensures the heap array attends the heap properties.
     */
    private void buildHeap() {
        for (int i = parent(tail); i >= 0; i--) {
            heapify(i);
        }
    }

    /**
     * Returns the left index of a given element.
     * 
     * @param index The index of the current element
     * @return The index of its left element
     */
    private int left(int index) {
        return (2 * index) + 1;
    }

    /**
     * Returns the right index of a given element.
     * 
     * @param index The index of the current element
     * @return The index of its right element
     */
    private int right(int index) {
        return (2 * index) + 2;
    }

    /**
     * Returns the parent index of a given element.
     * 
     * @param index The index of the current element
     * @return The index of its parent element
     */
    private int parent(int index) {
        return (index - 1) / 2;
    }

    /**
     * Checks if a given index is within the heap's limits
     * 
     * @param index The index to be validated
     * @return A boolean value; true if the index is valid, false otherwise
     */
    private boolean isValidIndex(int index) {
        return index >= 0 && index < heap.length;
    }

    /**
     * Checks if a element is a leaf.
     * The element is a leaf if its index is greater than the tail's parent index,
     * and less than the last element's index
     * 
     * @param index
     * @return
     */
    private boolean isLeaf(int index) {
        return index > parent(tail) && index <= tail;
    }

    /**
     * Given three elements from the heap, returns the index of the greatest
     * 
     * @param left    The index of the left element
     * @param current The index of the current element
     * @param right   The index of the right element
     * @return The index of the greatest element
     */
    private int getIndexMaxElement(int left, int current, int right) {
        T leftVal = heap[left];
        T currentVal = heap[current];
        T rightVal = heap[right];

        if ((leftVal.compareTo(currentVal) > 0) && (leftVal.compareTo(rightVal) > 0)) {
            return left;
        } else if ((rightVal.compareTo(leftVal) > 0) && (rightVal.compareTo(currentVal) > 0)) {
            return right;
        } else {
            return current;
        }
    }

    /**
     * Allocate more space in the heap for new elements.
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        // Create a new heap with the doubled capacity
        T[] newHeap = (T[]) new Comparable[heap.length * 2];

        // Copies the elements to the new heap
        for (int i = 0; i < newHeap.length; i++) {
            newHeap[i] = heap[i];
        }

        setHeap(newHeap);
    }

    /**
     * Swaps two elements in the heap.
     * 
     * @param i The index of the first element
     * @param j The index of the second element
     */
    private void swap(int i, int j) {
        T aux = heap[i];
        heap[i] = heap[j];
        heap[j] = aux;
    }

    private void setHeap(T[] newHeap) {
        this.heap = newHeap;
    }
}
