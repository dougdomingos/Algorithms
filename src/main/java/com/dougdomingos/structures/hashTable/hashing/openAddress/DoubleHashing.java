package com.dougdomingos.structures.hashTable.hashing.openAddress;

import com.dougdomingos.structures.hashTable.hashing.closedAddress.ClosedAddressHashing;

public class DoubleHashing<T> implements OpenAddressHashing<T> {

    private ClosedAddressHashing<T> auxHash1;

    private ClosedAddressHashing<T> auxHash2;

    public DoubleHashing(ClosedAddressHashing<T> auxHash1,
            ClosedAddressHashing<T> auxHash2) {
        this.auxHash1 = auxHash1;
        this.auxHash2 = auxHash2;
    }

    @Override
    public int hash(T element, int tableSize, int probeIndex) {
        int hash = (auxHash1.hash(element, tableSize)
                + probeIndex * auxHash2.hash(element, tableSize)) % tableSize;

        return hash;
    }
}
