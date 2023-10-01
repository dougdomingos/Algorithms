package com.dougdomingos.structures.queue;

import com.dougdomingos.structures.StructureOverflowException;
import com.dougdomingos.structures.StructureUnderflowException;
import com.dougdomingos.structures.linkedList.DoubleLinkedList;

public class LinkedListQueue<T extends Comparable<T>> implements Queue<T> {

    /**
     * The Linked List representing the Queue.
     */
    private DoubleLinkedList<T> list = new DoubleLinkedList<>();

    /**
     * The maximum size the Queue can reach.
     */
    private int capacity;

    /**
     * Creates a new Linked List Queue. The default capacity of the Queue is set
     * to the maximum value of a 32-bit signed integer.
     */
    public LinkedListQueue() {
        this.list = new DoubleLinkedList<>();
        this.capacity = Integer.MAX_VALUE;
    }

    public LinkedListQueue(int capacity) {
        this.list = new DoubleLinkedList<>();
        this.capacity = capacity;
    }

    @Override
    public void enqueue(T element) throws StructureOverflowException {
        if (isFull()) {
            throw new StructureOverflowException();
        }

        list.insertLast(element);
    }

    @Override
    public T dequeue() throws StructureUnderflowException {
        if (isEmpty()) {
            throw new StructureUnderflowException();
        }

        T firstElement = list.peekFirst();
        list.removeFirst();

        return firstElement;
    }

    @Override
    public T getHead() {
        if (isEmpty()) {
            return null;
        }

        return list.peekFirst();
    }

    @Override
    public T getTail() {
        if (isEmpty()) {
            return null;
        }

        return list.peekLast();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean isFull() {
        return list.size() == capacity;
    }

    @Override
    public int size() {
        return list.size();
    }
}
