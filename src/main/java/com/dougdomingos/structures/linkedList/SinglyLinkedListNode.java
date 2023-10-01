package com.dougdomingos.structures.linkedList;

/**
 * Representation of a Singly Linked List Node.
 */
public class SinglyLinkedListNode<T extends Comparable<T>> {

    /**
     * The value stored in the node.
     */
    protected T data;

    /**
     * A pointer to the next node in the list.
     */
    protected SinglyLinkedListNode<T> next;

    /**
     * Creates a new node.
     * 
     * @param data The value of the node
     * @param next The next node of the list
     */
    public SinglyLinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public SinglyLinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(SinglyLinkedListNode<T> newNext) {
        this.next = newNext;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (!(obj instanceof SinglyLinkedListNode)) {
            return false;
        }

        SinglyLinkedListNode<T> node = (SinglyLinkedListNode<T>) obj;

        return this.data.compareTo(node.data) == 0;
    }
}
