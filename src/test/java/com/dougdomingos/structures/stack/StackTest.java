package com.dougdomingos.structures.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.dougdomingos.structures.StructureOverflowException;
import com.dougdomingos.structures.StructureUnderflowException;

/**
 * Generic test class for Stack implementations.
 */
public class StackTest {

    @ParameterizedTest
    @MethodSource("stacks")
    void testCapacity(Stack<Integer> stack) {
        fillStack(stack, stack.capacity());
        assertEquals(5, stack.capacity());
    }

    @ParameterizedTest
    @MethodSource("stacks")
    void testContains(Stack<Integer> stack) {
        fillStack(stack, stack.capacity());
        assertTrue(stack.contains(1));
    }
    
    @ParameterizedTest
    @MethodSource("stacks")
    void testNotContains(Stack<Integer> stack) {
        fillStack(stack, stack.capacity());
        int testValue = stack.capacity() + 1;
        assertFalse(stack.contains(testValue));
    }

    @ParameterizedTest
    @MethodSource("stacks")
    void testIsEmpty(Stack<Integer> stack) {
        assertTrue(stack.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("stacks")
    void testIsFull(Stack<Integer> stack) {
        fillStack(stack, stack.capacity());
        assertTrue(stack.isFull());
    }

    @ParameterizedTest
    @MethodSource("stacks")
    void testPeekNull(Stack<Integer> stack) {
        assertNull(stack.peek());
    }

    @ParameterizedTest
    @MethodSource("stacks")
    void testPeekNotNull(Stack<Integer> stack) {
        fillStack(stack, stack.capacity());
        assertNotNull(stack.peek());
    }

    @ParameterizedTest
    @MethodSource("stacks")
    void testPop(Stack<Integer> stack) {
        fillStack(stack, stack.capacity());
        try {
            int expected = stack.capacity() - 1;
            int popped = stack.pop();
            assertEquals(expected, popped);
        } catch (StructureUnderflowException e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @MethodSource("stacks")
    void testPopUnderflow(Stack<Integer> stack) {
        assertThrows(StructureUnderflowException.class, () -> stack.pop());
    }

    @ParameterizedTest
    @MethodSource("stacks")
    void testPush(Stack<Integer> stack) {
        try {
            stack.push(10);
            assertEquals(10, stack.peek());
        } catch (StructureOverflowException e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @MethodSource("stacks")
    void testPushOverflow(Stack<Integer> stack) {
        fillStack(stack, stack.capacity());
        assertThrows(StructureOverflowException.class, () -> stack.push(10));
    }

    @ParameterizedTest
    @MethodSource("stacks")
    void testSize(Stack<Integer> stack) {
        fillStack(stack, stack.capacity());
        assertEquals(stack.capacity(), stack.size());
    }

    /**
     * Set up the algorithms to be tested.
     * 
     * @return A stream with the targeted algorithms
     */
    private static Stream<Stack<Integer>> stacks() {
        return Stream.of(
                new ArrayStack<>(5), 
                new LinkedListStack<>(5));
    }

    /**
     * Fills the stack with elements for testing.
     * 
     * @param stack         The targeted stack
     * @param stackCapacity The capacity of the targeted stack
     */
    private void fillStack(Stack<Integer> stack, int stackCapacity) {
        try {
            for (int i = 0; i < stackCapacity; i++) {
                stack.push(i);
            }
        } catch (StructureOverflowException e) {
            e.printStackTrace();
        }
    }
}
