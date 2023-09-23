package com.dougdomingos.structures.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dougdomingos.structures.StructureOverflowException;
import com.dougdomingos.structures.StructureUnderflowException;

public class QueueTest {

    /**
     * The implementation under testing.
     */
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    /**
     * Create an instance of the queue for testing
     */
    @BeforeEach
    void setUp() {
        this.queue1 = new ArrayQueue<>(5);
        this.queue2 = new ArrayQueue<>(5);

        // fills the queue
        fillQueue(queue1, 5);
    }

    @Test
    void testDequeue() {
        try {
            queue1.dequeue();
            assertEquals(4, queue1.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testDequeueUnderflow() {
        assertThrows(StructureUnderflowException.class, () -> queue2.dequeue());
    }

    @Test
    void testEnqueue() {
        try {
            queue2.dequeue();
            assertEquals(1, queue2.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testEnqueueOverflow() {
        assertThrows(StructureOverflowException.class, () -> queue1.enqueue(10));
    }

    @Test
    void testIsEmpty() {
        assertTrue(queue2.isEmpty());
    }

    @Test
    void testIsFull() {
        assertTrue(queue1.isFull());
    }

    @Test
    void testSize() {
        assertEquals(5, queue1.size());
    }

    /**
     * Fills the queue with elements for testing.
     * 
     * @param queue         The targeted queue
     * @param queueCapacity The capacity of the targeted queue
     */
    private void fillQueue(Queue<Integer> queue, int queueCapacity) {
        try {
            for (int i = 0; i < queueCapacity; i++) {
                queue.enqueue(i);
            }
        } catch (StructureOverflowException e) {
            e.printStackTrace();
        }
    }
}
