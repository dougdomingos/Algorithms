package com.dougdomingos.structures.stack;

import com.dougdomingos.structures.StructureOverflowException;
import com.dougdomingos.structures.StructureUnderflowException;
import com.dougdomingos.structures.linkedList.SinglyLinkedList;

public class LinkedListStack<T extends Comparable<T>> implements Stack<T> {

    private SinglyLinkedList<T> list;

    private int capacity;

    public LinkedListStack() {
        this.list = new SinglyLinkedList<>();
        this.capacity = Integer.MAX_VALUE;
    }

    public LinkedListStack(int capacity) {
        this.list = new SinglyLinkedList<>();
        this.capacity = capacity;
    }

    @Override
    public T pop() throws StructureUnderflowException {
        if (isEmpty()) {
            throw new StructureUnderflowException();
        }

        T topElement = list.peekLast();
        list.remove(topElement);
        return topElement;
    }

    @Override
    public void push(T element) throws StructureOverflowException {
        if (isFull()) {
            throw new StructureOverflowException();
        }

        list.insertLast(element);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }

        return list.peekLast();
    }

    @Override
    public boolean contains(T element) {
        if (isEmpty()) {
            return false;
        }

        return list.contains(element);
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

    @Override
    public int capacity() {
        return capacity;
    }
    
}
