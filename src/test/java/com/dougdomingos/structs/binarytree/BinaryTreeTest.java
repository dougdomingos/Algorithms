package com.dougdomingos.structs.binarytree;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.dougdomingos.structs.binarytree.bst.BST;

/**
 * Generic test class for Binary Tree implementations.
 */
public class BinaryTreeTest {

    private final int[] TEST_VALUES = new int[] { 21, -4, 10, 12, 100, 54 };

    @ParameterizedTest
    @MethodSource("trees")
    void testAdd(BinaryTree<Integer> tree) {
        tree.add(10);
        assertNotNull(tree.search(10));
    }

    @ParameterizedTest
    @MethodSource("trees")
    void testRemove(BinaryTree<Integer> tree) {
        addValuesToTree(tree, TEST_VALUES);
        tree.remove(100);
        assertNull(tree.search(100));
    }

    @ParameterizedTest
    @MethodSource("trees")
    void testGetMax(BinaryTree<Integer> tree) {
        addValuesToTree(tree, TEST_VALUES);
        assertEquals(100, tree.getMax().getData());
    }

    @ParameterizedTest
    @MethodSource("trees")
    void testGetMin(BinaryTree<Integer> tree) {
        addValuesToTree(tree, TEST_VALUES);
        assertEquals(-4, tree.getMin().getData());
    }

    @ParameterizedTest
    @MethodSource("trees")
    void testGetRoot(BinaryTree<Integer> tree) {
        tree.add(10);
        assertEquals(10, tree.getRoot().getData());
    }

    @ParameterizedTest
    @MethodSource("trees")
    void testGetRootNull(BinaryTree<Integer> tree) {
        assertNull(tree.getRoot());
    }

    @ParameterizedTest
    @MethodSource("trees")
    void testSuccessorOf(BinaryTree<Integer> tree) {
        addValuesToTree(tree, TEST_VALUES);
        assertEquals(10, tree.successorOf(-4).getData());
    }

    @ParameterizedTest
    @MethodSource("trees")
    void testSuccessorOfMaximum(BinaryTree<Integer> tree) {
        addValuesToTree(tree, TEST_VALUES);
        assertNull(tree.successorOf(100));
    }

    @ParameterizedTest
    @MethodSource("trees")
    void testSuccessorOfValueNotInTree(BinaryTree<Integer> tree) {
        assertNull(tree.successorOf(0));
    }

    @ParameterizedTest
    @MethodSource("trees")
    void testPredecessorOf(BinaryTree<Integer> tree) {
        addValuesToTree(tree, TEST_VALUES);
        assertEquals(54, tree.predecessorOf(100).getData());
    }

    @ParameterizedTest
    @MethodSource("trees")
    void testPredecessorOfMinimum(BinaryTree<Integer> tree) {
        addValuesToTree(tree, TEST_VALUES);
        assertNull(tree.predecessorOf(-4));
    }

    @ParameterizedTest
    @MethodSource("trees")
    void testPredecessorOfValueNotInTree(BinaryTree<Integer> tree) {
        assertNull(tree.predecessorOf(0));
    }

    @ParameterizedTest
    @MethodSource("trees")
    void testSearch(BinaryTree<Integer> tree) {
        addValuesToTree(tree, TEST_VALUES);

        assertTrue(() -> {
            boolean isInTree = true;

            for (int value : TEST_VALUES) {
                if (tree.search(value) == null) {
                    isInTree = false;
                }
            }

            return isInTree;
        });
    }

    @ParameterizedTest
    @MethodSource("trees")
    void testSearchNotFound(BinaryTree<Integer> tree) {
        assertNull(tree.search(10));
    }

    @ParameterizedTest
    @MethodSource("trees")
    void testHeight(BinaryTree<Integer> tree) {
        addValuesToTree(tree, TEST_VALUES);
        assertEquals(3, tree.height());
    }

    @ParameterizedTest
    @MethodSource("trees")
    void testHeightEmptyTree(BinaryTree<Integer> tree) {
        assertEquals(-1, tree.height());
    }

    @ParameterizedTest
    @MethodSource("trees")
    void testHeightSingleNode(BinaryTree<Integer> tree) {
        tree.add(10);
        assertEquals(0, tree.height());
    }

    @ParameterizedTest
    @MethodSource("trees")
    void testSize(BinaryTree<Integer> tree) {
        addValuesToTree(tree, TEST_VALUES);
        assertEquals(6, tree.size());
    }

    @ParameterizedTest
    @MethodSource("trees")
    void testSizeEmpty(BinaryTree<Integer> tree) {
        assertEquals(0, tree.size());
    }

    @ParameterizedTest
    @MethodSource("trees")
    void testPreOrder(BinaryTree<Integer> tree) {
        addValuesToTree(tree, TEST_VALUES);
        Integer[] expected = new Integer[] { 21, -4, 10, 12, 100, 54 };
        assertArrayEquals(expected, tree.preOrder());
    }

    @ParameterizedTest
    @MethodSource("trees")
    void testInOrder(BinaryTree<Integer> tree) {
        addValuesToTree(tree, TEST_VALUES);
        Integer[] expected = new Integer[] { -4, 10, 12, 21, 54, 100 };
        assertArrayEquals(expected, tree.inOrder());
    }

    @ParameterizedTest
    @MethodSource("trees")
    void testPostOrder(BinaryTree<Integer> tree) {
        addValuesToTree(tree, TEST_VALUES);
        Integer[] expected = new Integer[] { 12, 10, -4, 54, 100, 21 };
        assertArrayEquals(expected, tree.postOrder());
    }

    /**
     * Set up the algorithms to be tested.
     *
     * @return A stream with the targeted algorithms
     */
    private static Stream<BinaryTree<Integer>> trees() {
        return Stream.of(new BST<Integer>());
    }

    /**
     * Add an array of values to the tree.
     * 
     * @param tree   The target tree
     * @param values The values to be inserted
     */
    private void addValuesToTree(BinaryTree<Integer> tree, int[] values) {
        for (int i = 0; i < values.length; i++) {
            tree.add(values[i]);
        }
    }
}
