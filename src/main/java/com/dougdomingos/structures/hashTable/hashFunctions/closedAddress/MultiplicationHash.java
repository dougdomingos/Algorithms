package com.dougdomingos.structures.hashTable.hashFunctions.closedAddress;

public class MultiplicationHash<T> implements ClosedAddressHashFunction<T> {

    private final double K = (Math.sqrt(5) - 1) / 2;

    @Override
    public int hash(T element, int tableSize) {
        int hashKey = element.hashCode();
        double fraction = (hashKey * K) - Math.floor(hashKey * K);
        int hash = (int) (tableSize * fraction);

        return hash;
    }
    
}
