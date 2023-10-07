package com.dougdomingos.structures.queue;

import com.dougdomingos.structures.StructureOverflowException;
import com.dougdomingos.structures.StructureUnderflowException;

/**
 * Implementation of a Queue using a circular array.
 */
public class CircularQueue<T extends Comparable<T>> implements Queue<T> {

	/**
	 * The array representing the Queue.
	 */
	private T[] queue;

	/**
	 * The index of the first element of the Queue.
	 */
	private int head = -1;

	/**
	 * The index of the last element of the Queue.
	 */
	private int tail = -1;

	/**
	 * The total of elements in the Queue.
	 */
	private int size;

	@SuppressWarnings("unchecked")
	public CircularQueue(int capacity) {
		this.queue = (T[]) new Comparable[capacity];
		this.size = 0;
	}

	@Override
	public void enqueue(T element) throws StructureOverflowException {
		if (isFull()) {
			throw new StructureOverflowException();
		} else if (head == -1) {
			head++;
		}

		tail = (tail + 1) % queue.length;
		queue[tail] = element;
		size++;
	}

	@Override
	public T dequeue() throws StructureUnderflowException {
		if (isEmpty()) {
			throw new StructureUnderflowException();
		}

		T element = queue[head];
		size--;

		if (head == tail) {
			head = -1;
			tail = -1;
		} else {
			head = (head + 1) % queue.length;
		}

		return element;
	}

	@Override
	public boolean isEmpty() {
		return head == -1;
	}

	@Override
	public boolean isFull() {
		return (tail + 1) % queue.length == head;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public T getHead() {
		if (isEmpty()) {
			return null;
		}

		return queue[head];
	}

	@Override
	public T getTail() {
		if (isEmpty()) {
			return null;
		}

		return queue[tail];
	}
}
