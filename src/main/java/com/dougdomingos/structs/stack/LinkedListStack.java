package com.dougdomingos.structs.stack;

import com.dougdomingos.structs.StructureOverflowException;
import com.dougdomingos.structs.StructureUnderflowException;
import com.dougdomingos.structs.linkedlist.SinglyLinkedList;

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

		T topElement = list.peekFirst();
		list.removeFirst();
		return topElement;
	}

	@Override
	public void push(T element) throws StructureOverflowException {
		if (isFull()) {
			throw new StructureOverflowException();
		}

		list.insertFirst(element);
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			return null;
		}

		return list.peekFirst();
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
