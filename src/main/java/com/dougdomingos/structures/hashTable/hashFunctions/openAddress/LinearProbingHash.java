package com.dougdomingos.structures.hashTable.hashFunctions.openAddress;

import com.dougdomingos.structures.hashTable.hashFunctions.closedAddress.ClosedAddressHashFunction;

public class LinearProbingHash<T> implements OpenAddressHashFunction<T> {

    private ClosedAddressHashFunction<T> auxHash;

    public LinearProbingHash(ClosedAddressHashFunction<T> hashFunction) {
        this.auxHash = hashFunction;
    }

    @Override
    public int hash(T element, int tableSize, int probeIndex) {
        int hash = (auxHash.hash(element, tableSize) + probeIndex) % tableSize;

        return hash;
    }

}
