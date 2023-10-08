package com.dougdomingos.structs.stack;

import com.dougdomingos.structs.StructureOverflowException;
import com.dougdomingos.structs.StructureUnderflowException;

/**
 * Implementation of a Stack based on a Array.
 */
public class ArrayStack<T extends Comparable<T>> implements Stack<T> {

	/**
	 * The array representing the stack.
	 */
	private T[] stack;

	/**
	 * The index of the top element in the stack.
	 */
	private int top = -1;

	/**
	 * Creates a new stack.
	 *
	 * @param capacity
	 *            The maximum size of the stack
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		this.stack = (T[]) new Comparable[capacity];
	}

	@Override
	public T peek() {
		T element = null;

		if (!isEmpty()) {
			element = stack[top];
		}

		return element;
	}

	@Override
	public T pop() throws StructureUnderflowException {
		if (isEmpty()) {
			throw new StructureUnderflowException();
		}

		return stack[top--];
	}

	@Override
	public void push(T element) throws StructureOverflowException {
		if (isFull()) {
			throw new StructureOverflowException();
		}

		stack[++top] = element;
	}

	@Override
	public boolean contains(T element) {
		ArrayStack<T> auxStack = new ArrayStack<>(capacity());
		boolean found = false;

		try {
			// unstack all the values until the main stack is empty or the value
			// is found
			while (!isEmpty() && !found) {
				T topElement = pop();

				if (topElement.compareTo(element) == 0) {
					found = true;
				} else {
					auxStack.push(topElement);
				}
			}

			// move the values back to the main stack
			while (!auxStack.isEmpty()) {
				push(auxStack.pop());
			}
		} catch (StructureOverflowException | StructureUnderflowException e) {
			e.printStackTrace();
		}

		return found;
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public boolean isFull() {
		return top + 1 == capacity();
	}

	@Override
	public int size() {
		return top + 1;
	}

	@Override
	public int capacity() {
		return stack.length;
	}
}
