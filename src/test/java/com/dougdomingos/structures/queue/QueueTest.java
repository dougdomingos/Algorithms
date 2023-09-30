package com.dougdomingos.structures.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.dougdomingos.structures.StructureOverflowException;
import com.dougdomingos.structures.StructureUnderflowException;

public class QueueTest {

    @ParameterizedTest
    @MethodSource("queues")
    void testEnqueue(Queue<Integer> queue) {
        try {
            queue.enqueue(10);
            assertEquals(10, queue.getHead());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @MethodSource("queues")
    void testEnqueueOverflow(Queue<Integer> queue) {
        assertThrows(StructureOverflowException.class, () -> {
            fillQueue(queue);
            queue.enqueue(10);
        });
    }

    @ParameterizedTest
    @MethodSource("queues")
    void testDequeue(Queue<Integer> queue) {
        try {
            queue.enqueue(10);
            int dequeuedValue = queue.dequeue();
            assertEquals(10, dequeuedValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @MethodSource("queues")
    void testDequeueUnderflow(Queue<Integer> queue) {
        assertThrows(StructureUnderflowException.class, () -> {
            queue.dequeue();
        });
    }

    @ParameterizedTest
    @MethodSource("queues")
    void testGetHeadNull(Queue<Integer> queue) {
        assertNull(queue.getHead());
    }

    @ParameterizedTest
    @MethodSource("queues")
    void testGetHeadAfterDequeue(Queue<Integer> queue) {
        try {
            fillQueue(queue);
            queue.dequeue();
            assertEquals(1, queue.getHead());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @MethodSource("queues")
    void testGetTailNull(Queue<Integer> queue) {
        assertNull(queue.getTail());
    }

    @ParameterizedTest
    @MethodSource("queues")
    void testGetTailAfterEnqueue(Queue<Integer> queue) {
        try {
            queue.enqueue(15);
            assertEquals(15, queue.getTail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @MethodSource("queues")
    void testIsEmptyTrue(Queue<Integer> queue) {
        assertTrue(queue.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("queues")
    void testIsEmptyFalse(Queue<Integer> queue) {
        try {
            queue.enqueue(15);
            assertFalse(queue.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @MethodSource("queues")
    void testIsFullTrue(Queue<Integer> queue) {
        try {
            fillQueue(queue);
            assertTrue(queue.isFull());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @MethodSource("queues")
    void testIsFullFalse(Queue<Integer> queue) {
        assertFalse(queue.isFull());
    }

    @ParameterizedTest
    @MethodSource("queues")
    void testSizeAfterEnqueue(Queue<Integer> queue) {
        try {
            queue.enqueue(15);
            assertEquals(1, queue.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @MethodSource("queues")
    void testSizeEmpty(Queue<Integer> queue) {
        assertEquals(0, queue.size());
    }

    /**
     * Set up the algorithms to be tested.
     * 
     * @return A stream with the targeted algorithms
     */
    private static Stream<Queue<Integer>> queues() {
        return Stream.of(
                new CircularQueue<>(3),
                new ArrayQueue<>(3));
    }

    /**
     * Fills the queue with elements for testing.
     * 
     * @param targetQueue The targeted queue
     */
    private void fillQueue(Queue<Integer> targetQueue) {
        try {
            for (int i = 0; i <= targetQueue.size(); i++) {
                targetQueue.enqueue(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
