package com.dougdomingos.structures.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dougdomingos.structures.StructureOverflowException;
import com.dougdomingos.structures.StructureUnderflowException;

/**
 * Generic test class for Stack implementations.
 */
public class StackTest {

    /**
     * The implementation under testing.
     */
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /**
     * Create an instance of the stack for testing
     */
    @BeforeEach
    void setUp() {
        this.stack1 = new ArrayStack<>(5);
        this.stack2 = new ArrayStack<>(5);

        // fills the stack
        fillStack(stack1, 5);
    }

    @Test
    void testCapacity() {
        assertEquals(5, stack1.capacity());
    }

    @Test
    void testContains() {
        assertTrue(stack1.contains(1));
    }

    @Test
    void testNotContains() {
        int testValue = stack1.capacity() + 1;
        assertFalse(stack1.contains(testValue));
    }

    @Test
    void testIsEmpty() {
        assertTrue(stack2.isEmpty());
    }

    @Test
    void testIsFull() {
        assertTrue(stack1.isFull());
    }

    @Test
    void testPeekNull() {
        assertNull(stack2.peek());
    }

    @Test
    void testPeekNotNull() {
        assertNotNull(stack1.peek());
    }

    @Test
    void testPop() {
        try {
            int expected = stack1.capacity() - 1;
            int popped = stack1.pop();
            assertEquals(expected, popped);
        } catch (StructureUnderflowException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testPopUnderflow() {
        assertThrows(StructureUnderflowException.class, () -> stack2.pop());
    }

    @Test
    void testPush() {
        try {
            stack2.push(10);
            assertEquals(10, stack2.peek());
        } catch (StructureOverflowException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testPushOverflow() {
        try {
            stack1.push(1);
            assertThrows(StructureOverflowException.class, () -> stack1.push(10));
        } catch (StructureOverflowException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testSize() {
        assertEquals(stack1.capacity(), stack1.size());
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
