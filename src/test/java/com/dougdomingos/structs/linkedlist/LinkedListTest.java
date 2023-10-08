package com.dougdomingos.structs.linkedlist;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Generic test class for Linked Lists implementations.
 */
public class LinkedListTest {

	@ParameterizedTest
	@MethodSource("lists")
	void testInsertFirst(LinkedList<Integer> list) {
		list.insertFirst(10);
		list.insertFirst(15);
		list.insertFirst(20);
		assertEquals(20, list.peekFirst());
	}

	@ParameterizedTest
	@MethodSource("lists")
	void testInsertLast(LinkedList<Integer> list) {
		list.insertLast(1);
		list.insertLast(2);
		list.insertLast(3);
		assertEquals(3, list.peekLast());
	}

	@ParameterizedTest
	@MethodSource("lists")
	void testInsert(LinkedList<Integer> list) {
		list.insertFirst(10);
		list.insertFirst(15);
		list.insertFirst(20);
		list.insert(100, 1);
		assertEquals(1, list.indexOf(100));
	}

	@ParameterizedTest
	@MethodSource("lists")
	void testRemove(LinkedList<Integer> list) {
		try {
			list.insertFirst(10);
			list.insertFirst(15);
			list.insertFirst(20);
			list.remove(20);
			assertFalse(list.contains(20));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("lists")
	void testContainsFalse(LinkedList<Integer> list) {
		assertFalse(list.contains(10));
	}

	@ParameterizedTest
	@MethodSource("lists")
	void testContainsTrue(LinkedList<Integer> list) {
		list.insertFirst(10);
		assertTrue(list.contains(10));
	}

	@ParameterizedTest
	@MethodSource("lists")
	void testIsEmptyTrue(LinkedList<Integer> list) {
		assertTrue(list.isEmpty());
	}

	@ParameterizedTest
	@MethodSource("lists")
	void testIsEmptyFalse(LinkedList<Integer> list) {
		list.insertFirst(10);
		assertFalse(list.isEmpty());
	}

	@ParameterizedTest
	@MethodSource("lists")
	void testSizeEmpty(LinkedList<Integer> list) {
		assertEquals(0, list.size());
	}

	@ParameterizedTest
	@MethodSource("lists")
	void testSizeAfterInsert(LinkedList<Integer> list) {
		list.insertFirst(10);
		assertEquals(1, list.size());
	}

	@ParameterizedTest
	@MethodSource("lists")
	void testToArray(LinkedList<Integer> list) {
		Integer[] values = new Integer[] { 1, 3, 5, 7, 9, 11 };

		for (int i = 0; i < values.length; i++) {
			list.insertLast(values[i]);
		}

		Comparable<Integer>[] listArray = list.toArray();

		assertArrayEquals(values, listArray);
	}

	/**
	 * Set up the implementations to be tested.
	 *
	 * @return A stream with the targeted implementations
	 */
	private static Stream<LinkedList<Integer>> lists() {
		return Stream.of(new SinglyLinkedList<>(), new DoubleLinkedList<>());
	}
}
