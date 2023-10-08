package com.dougdomingos.structures.hashTable.hashing.openAddress;

import com.dougdomingos.structures.hashTable.hashing.closedAddress.ClosedAddressHashing;

public class DoubleHashing<T> implements OpenAddressHashing<T> {

    private ClosedAddressHashing<T> auxHash;

    public DoubleHashing(ClosedAddressHashing<T> auxHash) {
        this.auxHash = auxHash;
    }

    @Override
    public int hash(T element, int tableSize, int probeIndex) {
        int hash = (auxHash.hash(element, tableSize)
                + probeIndex * probeHash(element, tableSize)) % tableSize;

        return hash;
    }

    private int probeHash(T element, int tableSize) {
        final int PRIME = getSmallestPrime(tableSize);
        int hashKey = element.hashCode();
        int hash = PRIME - (hashKey % tableSize);

        return hash;
    }

    private int getSmallestPrime(int desiredValue) {
        int prime = 2;

        for (int i = desiredValue - 1; i >= 2; i--) {
            if (isPrime(i)) {
                prime = i;
                break;
            }
        }

        return prime;
    }

    private boolean isPrime(long val) {
        boolean isPrime = true;

        for (int i = 2; i < val; i++) {
            if (val % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
}
