package com.dougdomingos.structures.hashTable.closedAddress;

import com.dougdomingos.structures.StructureOverflowException;
import com.dougdomingos.structures.StructureUnderflowException;
import com.dougdomingos.structures.hashTable.AbstractHashTable;
import com.dougdomingos.structures.hashTable.hashing.HashFunctionBuilder;
import com.dougdomingos.structures.hashTable.hashing.closedAddress.ClosedAddressHash;
import com.dougdomingos.structures.hashTable.hashing.closedAddress.ClosedAddressHashing;
import com.dougdomingos.structures.linkedList.SinglyLinkedList;

/**
 * Implementation of a closed address Hash Table, using a Singly Linked List to
 * deal with collisions.
 */
public class ClosedAddressHashTable<T extends Comparable<T>>
        extends
        AbstractHashTable<T, SinglyLinkedList<T>, ClosedAddressHashing<T>> {

    /**
     * Creates a new closed address table.
     * 
     * @param capacity
     *            The total size of the table
     * @param method
     *            The hashing method to be used (e.g. DIVISION, MULTIPLICATION)
     */
    public ClosedAddressHashTable(int capacity, ClosedAddressHash method) {
        super(capacity, HashFunctionBuilder.buildClosedAddressHash(method));
    }

    @Override
    public void insert(T element) throws StructureOverflowException {
        if (isFull()) {
            throw new StructureOverflowException();
        }

        if (indexOf(element) == -1) {
            int hash = hashFunction.hash(element, table.length);

            if (table[hash] != null) {
                table[hash] = new SinglyLinkedList<>();
            } else {
                COLLISIONS++;
            }

            ((SinglyLinkedList<T>) table[hash]).insertLast(element);
            elements++;
        }
    }

    @Override
    public void remove(T element) throws StructureUnderflowException {
        if (isEmpty()) {
            throw new StructureUnderflowException();
        }

        int indexOnTable = indexOf(element);

        if (indexOnTable != -1) {
            if (table[indexOnTable].size() == 1) {
                table[indexOnTable] = null;
            } else {
                table[indexOnTable].remove(element);
            }

            elements--;
        }

    }

    @Override
    public boolean contains(T element) {
        if (isEmpty() || element == null) {
            return false;
        }

        boolean found = false;
        int indexOnTable = indexOf(element);

        if (indexOnTable != -1) {
            found = table[indexOnTable].contains(element);
        }

        return found;
    }

    @Override
    public int indexOf(T element) {
        if (isEmpty() || element == null) {
            return -1;
        }

        int indexOfElement = -1;
        int hash = hashFunction.hash(element, indexOfElement);

        if (table[hash] != null && table[hash].contains(element)) {
            indexOfElement = hash;
        }

        return indexOfElement;
    }

}
