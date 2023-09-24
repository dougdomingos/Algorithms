package com.dougdomingos.structures.linkedList;

import com.dougdomingos.structures.StructureUnderflowException;

public class SingleLinkedList<T extends Comparable<T>> implements LinkedList<T> {

    public SingleLinkedListNode<T> head;

    public SingleLinkedList() {
        this.head = null;
    }

    @Override
    public void insertFirst(T element) {
        SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>(element);
        newHead.setNext(head);
        head = newHead;
    }

    @Override
    public void insertLast(T element) {
        SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>(element);

        if (head == null) {
            head = newNode;
        } else {
            SingleLinkedListNode<T> tmp = head;
    
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
    
            tmp.setNext(newNode);
        }
    }

    @Override
    public void insertAt(T element, int index) {
        if ((index < 0) && (index >= size())) {
            return;
        }

        if (index == 0) {
            insertFirst(element);
        } else if (index == size() - 1) {
            insertLast(element);
        } else {
            SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>(element);
            SingleLinkedListNode<T> current = head;
            SingleLinkedListNode<T> prev = head;

            for (int i = 1; i < index - 1; i++) {
                prev = current;
                current = current.getNext();
            }

            newNode.setNext(current.getNext());
            prev.setNext(newNode);
        }

    }

    @Override
    public T removeFirst() throws StructureUnderflowException {
        if (isEmpty()) {
            throw new StructureUnderflowException();
        }

        T element = head.getData();
        head.setNext(head.getNext());
        return element;
    }

    @Override
    public T removeLast() throws StructureUnderflowException {
        if (isEmpty()) {
            throw new StructureUnderflowException();
        }

        SingleLinkedListNode<T> tmp = head;
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
        }

        T element = tmp.getData();
        tmp = null;
        return element;
    }

    @Override
    public boolean remove(T element) throws StructureUnderflowException {
        if (isEmpty()) {
            throw new StructureUnderflowException();
        }

        SingleLinkedListNode<T> current = head;
        SingleLinkedListNode<T> prev = current;

        boolean found = false;
        while (current.getNext() != null && !found) {
            if (current.getData().compareTo(element) == 0) {
                found = true;
            } else {
                prev = current;
                current = current.getNext();
            }
        }

        if (found) {
            prev.setNext(current.getNext());
        }

        return found;
    }

    @Override
    public int indexOf(T element) {
        if (isEmpty()) {
            return -1;
        }

        SingleLinkedListNode<T> tmp = head;
        boolean found = false;
        int index = 0;
        while (tmp != null && !found) {
            if (tmp.getData().compareTo(element) == 0) {
                found = true;
            } else {
                tmp = tmp.getNext();
                index++;
            }

        }

        return index;
    }

    @Override
    public boolean contains(T element) {
        if (isEmpty()) {
            return false;
        }

        SingleLinkedListNode<T> tmp = head;
        boolean found = false;
        while (tmp != null && !found) {
            if (tmp.getData().compareTo(element) == 0) {
                found = true;
            }

            tmp = tmp.getNext();
        }

        return found;
    }

    @Override
    public int size() {
        SingleLinkedListNode<T> tmp = head;
        int nodes = 0;

        while (tmp != null) {
            tmp = tmp.getNext();
            nodes++;
        }

        return nodes;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] array = (T[]) new Comparable[size()];

        SingleLinkedListNode<T> tmp = head;
        for (int i = 0; i < array.length; i++) {
            array[i] = tmp.getData();
            tmp = tmp.getNext();
        }

        return array;
    }
}
