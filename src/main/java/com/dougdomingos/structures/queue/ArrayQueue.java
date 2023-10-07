package com.dougdomingos.structures.queue;

import com.dougdomingos.structures.StructureOverflowException;
import com.dougdomingos.structures.StructureUnderflowException;

/**
 * Implementation of a Queue based on a Array.
 */
public class ArrayQueue<T extends Comparable<T>> implements Queue<T> {

	/**
	 * The array representing the Queue.
	 */
	private T[] queue;

	/**
	 * The index of the last element of the Queue.
	 */
	private int tail = -1;

	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity) {
		this.queue = (T[]) new Comparable[capacity];
	}

	@Override
	public void enqueue(T element) throws StructureOverflowException {
		if (isFull()) {
			throw new StructureOverflowException();
		}

		queue[++tail] = element;
	}

	@Override
	public T dequeue() throws StructureUnderflowException {
		if (isEmpty()) {
			throw new StructureUnderflowException();
		}

		T element = queue[0];
		shiftLeft();
		return element;
	}

	@Override
	public boolean isEmpty() {
		return tail == -1;
	}

	@Override
	public T getHead() {
		if (isEmpty()) {
			return null;
		}

		return queue[0];
	}

	@Override
	public T getTail() {
		if (isEmpty()) {
			return null;
		}

		return queue[tail];
	}

	@Override
	public boolean isFull() {
		return tail == queue.length - 1;
	}

	@Override
	public int size() {
		return tail + 1;
	}

	/**
	 * Shifts the queue in one position to the left after a dequeue.
	 */
	private void shiftLeft() {
		for (int i = 1; i <= tail; i++) {
			queue[i - 1] = queue[i];
		}

		tail--;
	}

}
