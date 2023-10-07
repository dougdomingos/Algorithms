package com.dougdomingos.structures.linkedList;

import com.dougdomingos.structures.StructureUnderflowException;

/**
 * Implementation of a Singly Linked List.
 * In a singly linked list, every node has a reference to the next node in the
 * list, or null if there is none.
 * All the O(n) operations in this implementation use the recursive approach.
 */
public class SinglyLinkedList<T extends Comparable<T>>
		implements LinkedList<T> {

	/**
	 * The first node of the list. If the list is empty, its value is null.
	 */
	private SinglyLinkedListNode<T> head;

	/**
	 * Creates a new Singly Linked List.
	 */
	public SinglyLinkedList() {
		this.head = null;
	}

	/**
	 * Remove the first element of the list.
	 */
	public void removeFirst() {
		head = head.getNext();
	}

	@Override
	public void insertFirst(T element) {
		SinglyLinkedListNode<T> newHead = new SinglyLinkedListNode<>(element);
		newHead.setNext(head);
		head = newHead;
	}

	@Override
	public void insertLast(T element) {
		if (head == null) {
			insertFirst(element);
		} else {
			insertLast(head, new SinglyLinkedListNode<>(element));
		}
	}

	@Override
	public void insert(T element, int index) {
		if ((index < 0) || index >= size()) {
			return;
		} else if (index == 0) {
			insertFirst(element);
		} else if (index == size() - 1) {
			insertLast(element);
		} else {
			insert(head, new SinglyLinkedListNode<>(element), index);
		}
	}

	@Override
	public void remove(T element) throws StructureUnderflowException {
		if (isEmpty()) {
			throw new StructureUnderflowException();
		}

		SinglyLinkedListNode<T> node = new SinglyLinkedListNode<>(element);
		if (head.equals(node)) {
			removeFirst();
		} else {
			remove(head, new SinglyLinkedListNode<>(element));
		}
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public boolean contains(T element) {
		return contains(head, new SinglyLinkedListNode<>(element));
	}

	@Override
	public int indexOf(T element) {
		if (!contains(element)) {
			return -1;
		}

		return indexOf(head, new SinglyLinkedListNode<>(element));
	}

	@Override
	public T peekFirst() {
		if (isEmpty()) {
			return null;
		}

		return head.getData();
	}

	@Override
	public T peekLast() {
		return peekLast(head);
	}

	@Override
	public int size() {
		return size(head);
	}

	@Override
	@SuppressWarnings("unchecked")
	public T[] toArray() {
		T[] listArray = (T[]) new Comparable[size()];
		SinglyLinkedListNode<T> currentNode = head;

		for (int i = 0; i < listArray.length; i++) {
			listArray[i] = currentNode.getData();
			currentNode = currentNode.getNext();
		}

		return listArray;
	}

	/**
	 * Recursive method for inserting an element at the end of the list.
	 *
	 * @param head
	 *            The first node of the list
	 * @param target
	 *            The element to be inserted
	 */
	private void insertLast(SinglyLinkedListNode<T> head,
			SinglyLinkedListNode<T> target) {
		if (head.getNext() == null) {
			head.setNext(target);
		} else {
			insertLast(head.getNext(), target);
		}
	}

	/**
	 * Recursive method for inserting an element at a given position in the
	 * list.
	 *
	 * @param head
	 *            The first node of the list
	 * @param target
	 *            The element to be inserted
	 * @param index
	 *            The index where the element will be inserted
	 */
	private void insert(SinglyLinkedListNode<T> head,
			SinglyLinkedListNode<T> target, int index) {
		if (index == 1) {
			target.setNext(head.getNext());
			head.setNext(target);
		} else {
			insert(head.getNext(), target, index--);
		}
	}

	/**
	 * Recursive method for removing a element from the list.
	 *
	 * @param head
	 *            The first node of the list
	 * @param target
	 *            The element to be removed
	 */
	private void remove(SinglyLinkedListNode<T> head,
			SinglyLinkedListNode<T> target) {
		if (!(head.getNext() == null)) {
			if (head.getNext().equals(target)) {
				head.setNext(target.getNext());
			} else {
				remove(head.getNext(), target);
			}
		}
	}

	/**
	 * Recursive method for determining if a element is in the list.
	 *
	 * @param head
	 *            The first node of the list
	 * @param target
	 *            The searched element
	 * @return A boolean value; true if the element is in the list, false
	 *         otherwise
	 */
	private boolean contains(SinglyLinkedListNode<T> head,
			SinglyLinkedListNode<T> target) {
		if (head == null) {
			return false;
		} else if (head.equals(target)) {
			return true;
		}

		return contains(head.getNext(), target);
	}

	/**
	 * Recursive method for finding the index of a given element in the list.
	 *
	 * @param head
	 *            The first node of the list
	 * @param target
	 *            The searched element
	 * @return The index of the element in the list
	 */
	private int indexOf(SinglyLinkedListNode<T> head,
			SinglyLinkedListNode<T> target) {
		if (head == null || head.equals(target)) {
			return 0;
		}

		return 1 + indexOf(head.getNext(), target);
	}

	/**
	 * Recursive method for returning the value of the last element in the list.
	 *
	 * @param head
	 *            The first node of the list
	 * @return The value of the last element
	 */
	private T peekLast(SinglyLinkedListNode<T> head) {
		if (head.getNext() == null) {
			return head.getData();
		}

		return peekLast(head.getNext());
	}

	/**
	 * Recursive method for getting the number of elements in the list.
	 *
	 * @param head
	 *            The first node of the list
	 * @return The number of nodes in the list
	 */
	private int size(SinglyLinkedListNode<T> head) {
		if (head == null) {
			return 0;
		}

		return 1 + size(head.getNext());
	}
}
