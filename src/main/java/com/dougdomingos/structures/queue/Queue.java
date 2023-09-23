package com.dougdomingos.structures.queue;

import com.dougdomingos.structures.StructureOverflowException;
import com.dougdomingos.structures.StructureUnderflowException;

/**
 * Interface for implementing a Queue.
 */
public interface Queue<T> {

    /**
     * Inserts a new element at the end of the queue.
     * 
     * @param element The element to be inserted
     * @throws StructureOverflowException thrown if the queue is full
     */
    public void enqueue(T element) throws StructureOverflowException;

    /**
     * Removes the element at the start of the queue.
     * 
     * @return The element at the start of the queue
     * @throws StructureUnderflowException thrown if the queue is empty
     */
    public T dequeue() throws StructureUnderflowException;

    /**
     * Checks if the queue is empty.
     * 
     * @return A boolean value; true if the queue is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Checks if the queue is full.
     * 
     * @return A boolean value; true if the queue is full, false otherwise
     */
    public boolean isFull();

    /**
     * Returns the total of elements that are currently in the queue.
     * 
     * @return The number of elements in the queue
     */
    public int size();
}
