package com.dougdomingos.structures.hashTable.openAddress;

import com.dougdomingos.structures.StructureOverflowException;
import com.dougdomingos.structures.StructureUnderflowException;
import com.dougdomingos.structures.hashTable.AbstractHashTable;
import com.dougdomingos.structures.hashTable.hashing.HashFunctionBuilder;
import com.dougdomingos.structures.hashTable.hashing.openAddress.OpenAddressHash;
import com.dougdomingos.structures.hashTable.hashing.openAddress.OpenAddressHashing;

public class OpenAddressHashTable<T extends Comparable<T>>
        extends AbstractHashTable<T, OpenAddressHashing<T>> {

    private final Tombstone DELETED = new Tombstone();

    public OpenAddressHashTable(int capacity, OpenAddressHash method) {
        super(capacity, HashFunctionBuilder.buildOpenAddressHash(method));
    }

    @Override
    public void insert(T element) throws StructureOverflowException {
        if (isFull()) {
            throw new StructureOverflowException();
        }

        if (!contains(element)) {
            int hash;
            int probeIndex = 0;
            boolean inserted = false;

            while (!inserted) {
                hash = hashFunction.hash(element, table.length, probeIndex);

                if (table[hash] != null && !table[hash].equals(DELETED)) {
                    probeIndex++;
                    COLLISIONS++;
                } else {
                    table[hash] = element;
                    inserted = true;
                    elements++;
                }
            }
        }
    }

    @Override
    public void remove(T element) throws StructureUnderflowException {
        if (isEmpty()) {
            throw new StructureUnderflowException();
        }

        int indexOnTable = indexOf(element);
        if (indexOnTable != -1) {
            table[indexOnTable] = new Tombstone();
            elements--;
        }

    }

    @Override
    public int indexOf(T element) {
        if (isEmpty() || element == null) {
            return -1;
        }

        int hash;
        int probeIndex = 0;
        int indexOfElement = -1;
        boolean found = false;

        while (!found && probeIndex < table.length) {
            hash = hashFunction.hash(element, table.length, probeIndex);

            if (table[hash] != null && table[hash].equals(element)) {
                indexOfElement = hash;
                found = true;
            } else {
                probeIndex++;
            }
        }

        return indexOfElement;
    }

    @Override
    public boolean contains(T element) {
        if (isEmpty() || element == null) {
            return false;
        }

        boolean found = false;
        int indexOnTable = indexOf(element);

        if (indexOnTable != -1) {
            found = table[indexOnTable].equals(element);
        }

        return found;
    }
}

/**
 * Local class that represents a deleted slot of the table.
 */
class Tombstone {
    public Tombstone() {
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null) {
            result = obj instanceof Tombstone;
        }

        return result;
    }
}
