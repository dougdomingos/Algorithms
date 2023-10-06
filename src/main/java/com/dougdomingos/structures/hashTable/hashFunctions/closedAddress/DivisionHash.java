package com.dougdomingos.structures.hashTable.hashFunctions.closedAddress;

public class DivisionHash<T> implements ClosedAddressHashFunction<T> {

    @Override
    public int hash(T element, int tableSize) {
        int hashKey = element.hashCode();
        int hash = hashKey % tableSize;

        return hash;
    }
}
