package com.dougdomingos.structs.binaryTree;

import com.dougdomingos.structs.binaryTree.node.BTNode;

/**
 * Abstract base class for implementing a Binary Tree.
 * <p>
 * This class provides default implementations for common methods of a binary
 * tree, all of which uses the recursive approach.
 */
public abstract class AbstractBT<T extends Comparable<T>> implements BinaryTree<T> {

    /**
     * The root node of the tree, from which we can acess all the others.
     */
    protected BTNode<T> root;

    /**
     * Create a new Binary Tree.
     */
    public AbstractBT() {
        this.root = null;
    }

    /**
     * Checks if the tree is empty (when the root is null).
     * 
     * @return A boolean value; true if the tree is empty, false otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public BTNode<T> getRoot() {
        return root;
    }

    @Override
    public BTNode<T> getMax() {
        if (isEmpty()) {
            return null;
        }

        return maximum(root);
    }

    @Override
    public BTNode<T> getMin() {
        if (isEmpty()) {
            return null;
        }

        return minimum(root);
    }

    @Override
    public BTNode<T> search(T element) {
        if (isEmpty()) {
            return null;
        }

        return search(element, root);
    }

    @Override
    public int height() {
        return height(root);
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        }

        return size(root);
    }

    @Override
    public BTNode<T> successorOf(T element) {
        if (isEmpty()) {
            return null;
        }

        BTNode<T> node = search(element);

        if (node != null) {
            if (node.getRight() != null) {
                return minimum(node.getRight());
            } else {
                return findSuccessor(node.getParent(), node);
            }
        }

        return null;
    }

    @Override
    public BTNode<T> predecessorOf(T element) {
        if (isEmpty()) {
            return null;
        }

        BTNode<T> node = search(element);

        if (node != null) {
            if (node.getLeft() != null) {
                return maximum(node.getLeft());
            } else {
                return findPredecessor(node.getParent(), node);
            }
        }

        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] preOrder() {
        if (isEmpty()) {
            return null;
        }

        T[] array = (T[]) new Comparable[size()];

        preOrder(root, array, 0);

        return array;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] inOrder() {
        if (isEmpty()) {
            return null;
        }

        T[] array = (T[]) new Comparable[size()];

        inOrder(root, array, 0);

        return array;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] postOrder() {
        if (isEmpty()) {
            return null;
        }

        T[] array = (T[]) new Comparable[size()];

        postOrder(root, array, 0);

        return array;
    }

    // ---------------------- RECURSIVE METHODS -----------------------

    /**
     * Recursive method for finding the maximum node of a subtree.
     * 
     * @param root The root of the subtree
     * @return The node with the biggest value of the subtree
     */
    private BTNode<T> maximum(BTNode<T> root) {
        if (root.getRight() == null) {
            return root;
        }

        return root.getRight();
    }

    /**
     * Recursive method for finding the minimum node of a subtree.
     * 
     * @param root The root of the subtree
     * @return The node with the smallest value of the subtree
     */
    private BTNode<T> minimum(BTNode<T> root) {
        if (root.getLeft() == null) {
            return root;
        }

        return root.getLeft();
    }

    /**
     * Recursive method for searching a node with a given value in a subtree.
     * 
     * @param element The targeted value
     * @param root    The root of the subtree
     * @return The node containing the target value, or null if the value is not on
     *         the subtree
     */
    private BTNode<T> search(T element, BTNode<T> root) {
        if (root == null) {
            return null;
        }

        if (root.compareTo(element) < 0) {
            return search(element, root.getLeft());
        } else if (root.compareTo(element) > 0) {
            return search(element, root.getRight());
        } else {
            return root;
        }
    }

    /**
     * Recursive method for finding the successor of a node through its parents.
     * 
     * @param current
     * @param target
     * @return
     */
    private BTNode<T> findSuccessor(BTNode<T> current, BTNode<T> target) {
        if (current == null || current.compareTo(target.getData()) > 0) {
            return current;
        }

        return findSuccessor(current.getParent(), target);
    }

    /**
     * Recursive method for finding the predecessor of a node through its parents.
     * 
     * @param current
     * @param target
     * @return
     */
    private BTNode<T> findPredecessor(BTNode<T> current, BTNode<T> target) {
        if (current == null || current.compareTo(target.getData()) < 0) {
            return current;
        }

        return findSuccessor(current.getParent(), target);
    }

    /**
     * Recursive method for calculating the height of a subtree.
     * 
     * @param root The root of the subtree
     * @return The height of the subtree
     */
    private int height(BTNode<T> root) {
        if (root == null) {
            return -1;
        }

        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
    }

    /**
     * Recursive method for calculating the size of a subtree.
     * 
     * @param root The root of the subtree
     * @return The size of the subtree
     */
    private int size(BTNode<T> root) {
        if (root == null) {
            return 0;
        }

        return 1 + (size(root.getLeft()) + size(root.getRight()));
    }

    /**
     * Recursive in-place method for calculating the pre-order of a subtree.
     * 
     * @param root  The root of the subtree
     * @param array The array representing the pre-order
     * @param index The current insertion index of the array
     */
    private void preOrder(BTNode<T> root, T[] array, int index) {
        if (index >= array.length) {
            return;
        }

        array[index++] = root.getData();
        preOrder(root.getLeft(), array, index);
        preOrder(root.getRight(), array, index);
    }

    /**
     * Recursive in-place method for calculating the in-order of a subtree.
     * 
     * @param root  The root of the subtree
     * @param array The array representing the in-order
     * @param index The current insertion index of the array
     */
    private void inOrder(BTNode<T> root, T[] array, int index) {
        if (index >= array.length) {
            return;
        }

        preOrder(root.getLeft(), array, index);
        array[index++] = root.getData();
        preOrder(root.getRight(), array, index);
    }

    /**
     * Recursive in-place method for calculating the post-order of a subtree.
     * 
     * @param root  The root of the subtree
     * @param array The array representing the post-order
     * @param index The current insertion index of the array
     */
    private void postOrder(BTNode<T> root, T[] array, int index) {
        if (index >= array.length) {
            return;
        }

        preOrder(root.getLeft(), array, index);
        preOrder(root.getRight(), array, index);
        array[index++] = root.getData();
    }

}
