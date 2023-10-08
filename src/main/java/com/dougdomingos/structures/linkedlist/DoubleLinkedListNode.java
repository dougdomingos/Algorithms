package com.dougdomingos.structures.linkedlist;

/**
 * Representation of a Double Linked List Node.
 */
public class DoubleLinkedListNode<T extends Comparable<T>>
		extends SinglyLinkedListNode<T> {

	/**
	 * A reference to the next node in the list, or null if none.
	 */
	protected DoubleLinkedListNode<T> next;

	/**
	 * A reference to the previous node in the list, or null if none.
	 */
	protected DoubleLinkedListNode<T> previous;

	/**
	 * Creates a new node.
	 *
	 * @param data
	 *            The value of the node
	 */
	public DoubleLinkedListNode(T data) {
		super(data);
		this.next = null;
		this.previous = null;
	}

	public DoubleLinkedListNode<T> getNext() {
		return next;
	}

	public DoubleLinkedListNode<T> getPrevious() {
		return previous;
	}

	public void setNext(DoubleLinkedListNode<T> node) {
		this.next = node;
	}

	public void setPrevious(DoubleLinkedListNode<T> node) {
		this.previous = node;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		if (!(obj instanceof DoubleLinkedListNode)) {
			return false;
		}

		DoubleLinkedListNode<T> node = (DoubleLinkedListNode<T>) obj;

		return this.data.compareTo(node.data) == 0;
	}
}
