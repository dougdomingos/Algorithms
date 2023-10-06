package com.dougdomingos.structures.hashTable.hashFunctions.openAddress;

import com.dougdomingos.structures.hashTable.hashFunctions.closedAddress.ClosedAddressHashFunction;

public class DoubleHashing<T> implements OpenAddressHashFunction<T> {

    private ClosedAddressHashFunction<T> auxHash1;

    private ClosedAddressHashFunction<T> auxHash2;

    public DoubleHashing(ClosedAddressHashFunction<T> auxHash1,
            ClosedAddressHashFunction<T> auxHash2) {
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
