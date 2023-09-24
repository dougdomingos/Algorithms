package com.dougdomingos.structures.linkedList;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SingleLinkedListTest {

    private LinkedList<Integer> linkedList;

    @BeforeEach
    void setUp() {
        this.linkedList = new SingleLinkedList<>();

        this.linkedList.insertLast(1);
        this.linkedList.insertLast(2);
        this.linkedList.insertLast(3);
    }

    @Test
    void testContains() {
        assertAll(
            () -> assertTrue(linkedList.contains(1)),
            () -> assertFalse(linkedList.contains(10))
        );
    }

    @Test
    void testIndexOf() {
        assertAll(
                () -> assertEquals(0, linkedList.indexOf(1)),
                () -> assertEquals(1, linkedList.indexOf(2)),
                () -> assertEquals(2, linkedList.indexOf(3)));
    }

    @Test
    void testInsertAt() {
        linkedList.insertAt(10, 1);
        assertEquals(1, linkedList.indexOf(10));
    }

    @Test
    void testInsertFirst() {
        linkedList.insertFirst(10);
        assertEquals(0, linkedList.indexOf(10));
    }

    @Test
    void testInsertLast() {
        linkedList.insertLast(10);
        assertEquals(3, linkedList.indexOf(10));
    }

    @Test
    void testIsEmpty() {
        SingleLinkedList<Integer> test = new SingleLinkedList<>();
        assertTrue(test.isEmpty());
    }

    @Test
    void testRemove() {
        try {
            assertTrue(linkedList.remove(1));
            assertFalse(linkedList.remove(5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testRemoveFirst() {
        try {
            assertEquals(1, linkedList.removeFirst());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testRemoveLast() {
        try {
            assertEquals(3, linkedList.removeLast());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testSize() {
        assertEquals(3, linkedList.size());
    }

    @Test
    void testToArray() {
        assertArrayEquals(new Integer[] {1, 2, 3}, linkedList.toArray());
    }
}
