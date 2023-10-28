package com.dougdomingos.structs.arraylist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayListTest {

    private ArrayList<Integer> implementation;

    @BeforeEach
    void setUp() {
        this.implementation = new ArrayList<>(10);
        insertValues(new Integer[] { 7, -15, 0, 2, 6, 34, 1 });
    }

    @Test
    void testAdd() {
        implementation.add(100);

        assertEquals(8, implementation.size());
        assertEquals(7, implementation.indexOf(100));
    }

    @Test
    void testAddAt() {
        implementation.addAt(0, 100);

        assertEquals(8, implementation.size());
        assertEquals(0, implementation.indexOf(100));
    }

    @Test
    void testAddAtInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> implementation.addAt(100, 10));
    }

    @Test
    void testSetAt() {
        implementation.setAt(0, 100);

        assertEquals(7, implementation.size());
        assertEquals(0, implementation.indexOf(100));
    }

    @Test
    void testSetAtInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class,
                () -> implementation.setAt(100, 10));
    }

    @Test
    void testResize() {
        insertValues(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });

        assertEquals(16, implementation.size());
    }

    @Test
    void testIndexOf() {
        assertEquals(0, implementation.indexOf(7));
        assertEquals(1, implementation.indexOf(-15));
        assertEquals(6, implementation.indexOf(1));
    }

    @Test
    void testIndexOfElementNotFound() {
        assertEquals(-1, implementation.indexOf(100));
    }

    @Test
    void testIsEmpty() {
        ArrayList<?> emptyList = new ArrayList<>();
        assertTrue(emptyList.isEmpty());
    }

    @Test
    void testIsEmptyFails() {
        assertFalse(implementation.isEmpty());
    }

    @Test
    void testRemoveByIndex() {
        implementation.remove(0);

        assertEquals(6, implementation.size());
        assertEquals(-1, implementation.indexOf(7));
        assertEquals(0, implementation.indexOf(-15));
    }

    @Test
    void testRemoveByElement() {
        ArrayList<String> stringList = new ArrayList<>();

        stringList.add("Coffee");
        stringList.add("Bread");
        stringList.add("Tea");

        String removed = stringList.remove("Bread");

        assertEquals(2, stringList.size());
        assertEquals("Bread", removed);
        assertEquals(-1, stringList.indexOf("Bread"));
        assertEquals(1, stringList.indexOf("Tea"));
    }

    @Test
    void testSearch() {
        assertNotNull(implementation.search(0));
        assertNull(implementation.search(-999));
    }

    private void insertValues(Integer[] values) {
        for (Integer val : values) {
            implementation.add(val);
        }
    }

}
