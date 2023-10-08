package com.dougdomingos.structures.hashTable.closedAddress;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.dougdomingos.structures.StructureOverflowException;
import com.dougdomingos.structures.StructureUnderflowException;
import com.dougdomingos.structures.hashTable.hashing.closedAddress.ClosedAddressMethods;

public class ClosedAddressHashTableTest {

    @ParameterizedTest
    @MethodSource("tables")
    void testContains(ClosedAddressHashTable<Integer> table) {
        try {
            table.insert(10);
        } catch (StructureOverflowException e) {
            fail(e.getMessage());
        }

        assertTrue(table.contains(10));
    }

    @ParameterizedTest
    @MethodSource("tables")
    void testNotContains(ClosedAddressHashTable<Integer> table) {
        assertFalse(table.contains(10));
    }

    @ParameterizedTest
    @MethodSource("tables")
    void testIndexOf(ClosedAddressHashTable<Integer> table) {
        try {
            table.insert(10);
        } catch (StructureOverflowException e) {
            fail(e.getMessage());
        }

        assertNotEquals(-1, table.indexOf(10));
    }

    @ParameterizedTest
    @MethodSource("tables")
    void testInsert(ClosedAddressHashTable<Integer> table) {
        Integer[] testValues = new Integer[] { 1, 2, 3, 4, 5 };

        try {
            insertValuesOnTable(testValues, table);
        } catch (StructureOverflowException e) {
            fail(e.getMessage());
        }

        assertTrue(() -> {
            boolean result = true;
            for (Integer val : testValues) {
                if (!table.contains(val)) {
                    result = false;
                }
            }

            return result;
        });
    }

    @ParameterizedTest
    @MethodSource("tables")
    void testRemove(ClosedAddressHashTable<Integer> table) {
        Integer[] testValues = new Integer[] { 5, 10, 15, 20, 25 };

        try {
            insertValuesOnTable(testValues, table);

            for (Integer val : testValues) {
                table.remove(val);
            }
        } catch (StructureOverflowException | StructureUnderflowException e) {
            fail(e.getMessage());
        }

        assertFalse(() -> {
            boolean result = false;
            for (Integer val : testValues) {
                if (table.contains(val)) {
                    result = true;
                }
            }

            return result;
        });
    }

    @ParameterizedTest
    @MethodSource("tables")
    void testRemoveEmpty(ClosedAddressHashTable<Integer> table) {
        assertThrows(StructureUnderflowException.class, () -> table.remove(10));
    }

    @ParameterizedTest
    @MethodSource("tables")
    void testIsEmpty(ClosedAddressHashTable<Integer> table) {
        assertTrue(table.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("tables")
    void testIsNotEmpty(ClosedAddressHashTable<Integer> table) {
        try {
            table.insert(10);
        } catch (StructureOverflowException e) {
            fail(e.getMessage());
        }

        assertFalse(table.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("tables")
    void testSizeEmpty(ClosedAddressHashTable<Integer> table) {
        assertEquals(0, table.size());
    }

    @ParameterizedTest
    @MethodSource("tables")
    void testSizeAfterInsert(ClosedAddressHashTable<Integer> table) {
        try {
            insertValuesOnTable(new Integer[] { 1, 2, 3, 4, 5 }, table);
        } catch (StructureOverflowException e) {
            fail(e.getMessage());
        }

        assertEquals(5, table.size());
    }

    @ParameterizedTest
    @MethodSource("tables")
    void testSizeAfterRemove(ClosedAddressHashTable<Integer> table) {
        try {
            insertValuesOnTable(new Integer[] { 1, 2, 3, 4, 5 }, table);
            table.remove(5);
        } catch (StructureOverflowException | StructureUnderflowException e) {
            fail(e.getMessage());
        }

        assertEquals(4, table.size());
    }

    private static Stream<ClosedAddressHashTable<Integer>> tables() {
        return Stream.of(
                new ClosedAddressHashTable<>(5,
                        ClosedAddressMethods.DIVISION),
                new ClosedAddressHashTable<>(5,
                        ClosedAddressMethods.MULTIPLICATION));
    }

    private void insertValuesOnTable(Integer[] values,
            ClosedAddressHashTable<Integer> table)
            throws StructureOverflowException {

        for (Integer val : values) {
            table.insert(val);
        }
    }

}
