package com.dougdomingos.structs.linkedlist;

import com.dougdomingos.structs.StructureUnderflowException;

public class DoubleLinkedList<T extends Comparable<T>>
		implements LinkedList<T> {

	/**
	 * The first node of the list. If the list is empty, its values is null.
	 */
	private DoubleLinkedListNode<T> head;

	/**
	 * The last node of the list. If the list is empty, its values is null.
	 */
	private DoubleLinkedListNode<T> tail;

	public DoubleLinkedList() {
		this.head = null;
		this.tail = null;
	}

	/**
	 * Removes the first element of the list.
	 */
	public void removeFirst() throws StructureUnderflowException {
		if (isEmpty()) {
			throw new StructureUnderflowException();
		}

		head = head.getNext();
		head.setPrevious(null);
	}

	/**
	 * Removes the last element of the list.
	 */
	public void removeLast() throws StructureUnderflowException {
		if (isEmpty()) {
			throw new StructureUnderflowException();
		}

		tail = tail.getPrevious();
		tail.setNext(null);
	}

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(element);

		if (isEmpty()) {
			head = newNode;
			tail = head;
		} else {
			newNode.setNext(head);
			head = newNode;
		}
	}

	@Override
	public void insertLast(T element) {
		DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(element);

		if (isEmpty()) {
			head = newNode;
			tail = head;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
	}

	@Override
	public void insert(T element, int index) {
		if ((index < 0) || (index >= size())) {
			return;
		} else if (index == 0) {
			insertFirst(element);
		} else if (index == size() - 1) {
			insertLast(element);
		} else {
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(
					element);
			DoubleLinkedListNode<T> currentNode = head;

			// move the pointer to the desired index
			for (int i = index; i > 1; i++) {
				currentNode = currentNode.getNext();
			}

			newNode.setNext(currentNode.getNext());
			newNode.setPrevious(currentNode);
			currentNode.getNext().setPrevious(newNode);
			currentNode.setNext(newNode);
		}

	}

	@Override
	public void remove(T element) throws StructureUnderflowException {
		if (isEmpty()) {
			throw new StructureUnderflowException();
		}

		DoubleLinkedListNode<T> node = new DoubleLinkedListNode<>(element);

		if ((head.equals(node)) && (head == tail)) {
			head = null;
			tail = null;
		} else if (head.equals(node)) {
			head = head.getNext();
			head.setPrevious(null);
		} else if (tail.equals(node)) {
			removeLast();
		} else {
			DoubleLinkedListNode<T> currentNode = head;
			DoubleLinkedListNode<T> previousNode = null;

			while (currentNode.getNext() != null) {
				if (currentNode.equals(node)) {
					previousNode.setNext(currentNode.getNext());
					currentNode.setPrevious(previousNode);
				} else {
					previousNode = currentNode;
					currentNode = currentNode.getNext();
				}
			}
		}
	}

	@Override
	public boolean contains(T element) {
		DoubleLinkedListNode<T> node = new DoubleLinkedListNode<>(element);
		DoubleLinkedListNode<T> currentNode = head;
		boolean found = false;

		while (currentNode != null && !found) {
			if (currentNode.equals(node)) {
				found = true;
			} else {
				currentNode = currentNode.getNext();
			}
		}

		return found;
	}

	@Override
	public int indexOf(T element) {
		DoubleLinkedListNode<T> node = new DoubleLinkedListNode<>(element);
		DoubleLinkedListNode<T> currentNode = head;
		boolean found = false;
		int index = 0;

		while (currentNode != null && !found) {
			if (currentNode.equals(node)) {
				found = true;
			} else {
				currentNode = currentNode.getNext();
				index++;
			}
		}

		return index;
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
		if (isEmpty()) {
			return null;
		}

		return tail.getData();
	}

	@Override
	public int size() {
		DoubleLinkedListNode<T> currentNode = head;
		int nodes = 0;

		while (currentNode != null) {
			currentNode = currentNode.getNext();
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
		T[] listArray = (T[]) new Comparable[size()];
		SinglyLinkedListNode<T> currentNode = head;

		for (int i = 0; i < listArray.length; i++) {
			listArray[i] = currentNode.getData();
			currentNode = currentNode.getNext();
		}

		return listArray;
	}
}
