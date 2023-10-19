package com.dougdomingos.structs.binarytree.bst;

import com.dougdomingos.structs.binarytree.AbstractBT;
import com.dougdomingos.structs.binarytree.node.BTNode;

/**
 * Implementation of a Binary Search Tree.
 */
public class BST<T extends Comparable<T>> extends AbstractBT<T> {

	@Override
	public void add(T element) {
		if (element == null) {
			return;
		}

		BTNode<T> newNode = new BTNode<T>(element);

		if (isEmpty()) {
			root = newNode;
		} else {
			add(root, newNode);
		}
	}

	@Override
	public void remove(T element) {
		if (isEmpty()) {
			return;
		}

		BTNode<T> target = search(element);
		if (target != null) {
			remove(target);
		}
	}

	// --------------------- AUXILIAR METHODS ----------------------

	/**
	 * Recursive method for adding a new node into the tree.
	 *
	 * @param root
	 *            The root of the tree
	 * @param newNode
	 *            The new node to be inserted into the tree
	 */
	private void add(BTNode<T> root, BTNode<T> newNode) {
		if (newNode.compareTo(root.getData()) < 0) {
			// If the new element is smaller than root,
			// add the element at left (if it's null), or go to the left
			// otherwise
			if (root.getLeft() == null) {
				root.setLeft(newNode);
				newNode.setParent(root);
			} else {
				add(root.getLeft(), newNode);
			}

		} else {
			// If the new element is greater than root,
			// add the element at right (if it's null), or go to the right
			// otherwise
			if (root.getRight() == null) {
				root.setRight(newNode);
				newNode.setParent(root);
			} else {
				add(root.getRight(), newNode);
			}
		}
	}

	/**
	 * Auxiliar method for removing an element of the tree.
	 *
	 * @param target
	 *            The node to be removed
	 */
	private void remove(BTNode<T> target) {
		if (target.isLeaf()) {
			// Case 1: The target is a leaf node
			if (target.equals(root)) {
				// If the node is the root, simply set it to null
				root = null;
			} else {
				// Otherwise, set its parent reference to null
				BTNode<T> parent = target.getParent();

				if (parent.getLeft().equals(target)) {
					parent.setLeft(null);
				} else {
					parent.setRight(null);
				}
			}
		} else if (target.hasOnlyLeftChild()) {
			// Case 2.1: The target only has one child (left node)
			if (target.equals(root)) {
				// If the node is the root, replace the root with the left child
				root = target.getLeft();
				root.setParent(null);
			} else {
				// Otherwise, set the parent of the left child to be the parent
				// of the target and the other way around
				BTNode<T> parent = target.getParent();
				target.getLeft().setParent(parent);

				if (target.compareTo(parent.getData()) < 0) {
					parent.setLeft(target.getLeft());
				} else {
					parent.setRight(target.getLeft());
				}
			}
		} else if (target.hasOnlyRightChild()) {
			// Case 2.2: The target only has one child (right node)
			if (target.equals(root)) {
				// If the node is the root, replace the root with the left child
				root = target.getRight();
				root.setParent(null);
			} else {
				// Otherwise, set the parent of the right child to be the parent
				// of the target and the other way around
				BTNode<T> parent = target.getParent();
				target.getRight().setParent(parent);

				if (target.compareTo(parent.getData()) < 0) {
					parent.setLeft(target.getRight());
				} else {
					parent.setRight(target.getRight());
				}
			}
		} else {
			// Case 4: The target has two child nodes
			// Override the target value with its sucessor, then remove the
			// sucessor node
			BTNode<T> sucessor = successorOf(target.getData());
			target.setData(sucessor.getData());
			remove(sucessor);
		}

	}
}
