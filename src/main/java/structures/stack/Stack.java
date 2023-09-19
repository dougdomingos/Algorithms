package structures.stack;

import structures.StructureOverflowException;
import structures.StructureUnderflowException;

/**
 * Interface for implementing a stack
 */
public interface Stack<T> {

    /**
     * Removes the top element of the stack.
     * 
     * @return The top element
     * @throws StructureUnderflowException Thrown if the stack is empty
     */
    public T pop() throws StructureUnderflowException;

    /**
     * Add a new element to the top of the stack.
     * 
     * @param element The element to be added to the stack
     * @throws StructureOverflowException Thrown if the stack is full
     */
    public void push(T element) throws StructureOverflowException;

    /**
     * Returns the top element without removing.
     * 
     * @return The top element
     */
    public T peek();

    /**
     * Checks if an arbitrary element exists within the stack.
     * 
     * @param element The searched element
     * @return A boolean value; true if the element is in the stack, false otherwise
     */
    public boolean contains(T element);

    /**
     * Checks if the stack is empty.
     * 
     * @return A boolean value; true if the stack is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Checks if the stack is full.
     * 
     * @return A boolean value; true if the stack is full, false otherwise
     */
    public boolean isFull();

    /**
     * Returns the number of elements currently in the stack.
     * 
     * @return The number of elements in the stack
     */
    public int size();

    /**
     * Returns the maximum size of the stack.
     * 
     * @return The maximum size of the stack
     */
    public int capacity();
}
