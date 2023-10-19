package com.dougdomingos.structs.binarytree.node;

/**
 * Representation of a tree node.
 * <p>
 * Something worth noting: in Graph Theory, a Rooted Tree is a directed graph
 * where every node has an indegree of 1 or 0, which means no node has an edge
 * that goes to its parent.
 * <p>
 * However, when building tree-like structures, its convinient to have a
 * reference to the parent node.
 */
public class BTNode<T extends Comparable<T>> implements Comparable<T> {

	/**
	 * The value of the node.
	 */
	private T data;

	/**
	 * The parent node. If the node is the root of the tree, the parent is null.
	 */
	private BTNode<T> parent;

	/**
	 * The node at the left side.
	 */
	private BTNode<T> left;

	/**
	 * The node at the right side.
	 */
	private BTNode<T> right;

	/**
	 * Creates a new node.
	 *
	 * @param data
	 *            the value of the node
	 */
	public BTNode(T data) {
		this.data = data;
	}

	/**
	 * Creates a new node with the parent node.
	 *
	 * @param data
	 *            the value of the node
	 * @param parent
	 *            the parent of the node
	 */
	public BTNode(T data, BTNode<T> parent) {
		this.data = data;
		this.parent = parent;
	}

	/**
	 * Checks if the node is a leaf node (has no child nodes)
	 *
	 * @return A boolean value; true if its a leaf node, false otherwise
	 */
	public boolean isLeaf() {
		return (getLeft() == null) && (getRight() == null);
	}

	/**
	 * Checks if the node only has its left child.
	 *
	 * @return A boolean value; true if the node only has its t child, false
	 *         otherwise
	 */
	public boolean hasOnlyLeftChild() {
		return (getLeft() != null) && (getRight() == null);
	}

	/**
	 * Checks if the node only has its right child.
	 *
	 * @return A boolean value; true if the node only has its t child, false
	 *         otherwise
	 */
	public boolean hasOnlyRightChild() {
		return (getLeft() == null) && (getRight() != null);
	}

	public T getData() {
		return data;
	}

	public BTNode<T> getParent() {
		return parent;
	}

	public BTNode<T> getLeft() {
		return left;
	}

	public BTNode<T> getRight() {
		return right;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setParent(BTNode<T> parent) {
		this.parent = parent;
	}

	public void setLeft(BTNode<T> left) {
		this.left = left;
	}

	public void setRight(BTNode<T> right) {
		this.right = right;
	}

	@Override
	public int compareTo(T arg0) {
		return this.data.compareTo(arg0);
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
		if (!(obj instanceof BTNode)) {
			return false;
		}

		BTNode<T> node = (BTNode<T>) obj;

		return data.compareTo(node.getData()) == 0;
	}
}
