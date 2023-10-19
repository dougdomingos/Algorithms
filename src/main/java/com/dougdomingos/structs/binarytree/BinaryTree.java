package com.dougdomingos.structs.binarytree;

import com.dougdomingos.structs.binarytree.node.BTNode;

/**
 * Interface for implementing a generic Tree.
 */
public interface BinaryTree<T extends Comparable<T>> {

	/**
	 * Returns the root element of the tree.
	 *
	 * @return The root element of the tree, or null if the tree is empty
	 */
	public BTNode<T> getRoot();

	/**
	 * Inserts a new value into the tree.
	 *
	 * @param element
	 *            The element to be inserted
	 */
	public void add(T element);

	/**
	 * Removes a value from the tree.
	 *
	 * @param element
	 *            The element to be removed
	 */
	public void remove(T element);

	/**
	 * Searches for a value in the tree.
	 *
	 * @param element
	 *            The targeted element
	 * @return The node of the value, or null if the value is not in the tree
	 */
	public BTNode<T> search(T element);

	/**
	 * Returns the node with the minimum value in the tree.
	 *
	 * @return The node with the smallest value in the tree
	 */
	public BTNode<T> getMin();

	/**
	 * Returns the node with the maximum value in the tree.
	 *
	 * @return The node with the biggest value in the tree
	 */
	public BTNode<T> getMax();

	/**
	 * Returns the next biggest node that is not smaller than the value.
	 *
	 * @param element
	 *            The value for which it will return the successor
	 * @return
	 */
	public BTNode<T> successorOf(T element);

	/**
	 * Returns the next smallest node that is not bigger than the value.
	 *
	 * @param element
	 *            The value for which it will return the predecessor
	 * @return
	 */
	public BTNode<T> predecessorOf(T element);

	/**
	 * Returns the number of elements in the tree.
	 *
	 * @return The number of elements in the tree
	 */
	public int size();

	/**
	 * Returns the height of the tree.
	 *
	 * @return The height of the tree. If the tree is empty, returns -1
	 */
	public int height();

	/**
	 * Returns the elements in the tree in pre-order (node, left, right).
	 *
	 * @return An array with the elements sorted in pre-order
	 */
	public T[] preOrder();

	/**
	 * Returns the elements in the tree in order (left, node, right).
	 *
	 * @return An array with the elements sorted in order
	 */
	public T[] inOrder();

	/**
	 * Returns the elements in the tree in post-order (left, right, node).
	 *
	 * @return An array with the elements sorted in post-order
	 */
	public T[] postOrder();
}
