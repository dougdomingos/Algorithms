package com.dougdomingos.structures.linkedList;

/**
 * Representation of a Single Linked List Node.
 */
public class SingleLinkedListNode<T extends Comparable<T>> {

    /**
     * The value stored in the node.
     */
    private T data;

    /**
     * A pointer to the next node in the list.
     */
    private SingleLinkedListNode<T> next;

    /**
     * Creates a new node.
     * 
     * @param data The value of the node
     * @param next The next node of the list
     */
    public SingleLinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public SingleLinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(SingleLinkedListNode<T> newNext) {
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
        if (!(obj instanceof SingleLinkedListNode)) {
            return false;
        }

        SingleLinkedListNode<T> node = (SingleLinkedListNode<T>) obj;

        return this.data.compareTo(node.getData()) == 0;
    }
}
