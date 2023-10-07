package com.dougdomingos.structures.hashTable.hashing;

import com.dougdomingos.structures.hashTable.hashing.closedAddress.ClosedAddressHash;
import com.dougdomingos.structures.hashTable.hashing.closedAddress.ClosedAddressHashing;
import com.dougdomingos.structures.hashTable.hashing.closedAddress.DivisionHash;
import com.dougdomingos.structures.hashTable.hashing.closedAddress.MultiplicationHash;
import com.dougdomingos.structures.hashTable.hashing.openAddress.DoubleHashing;
import com.dougdomingos.structures.hashTable.hashing.openAddress.LinearProbingHash;
import com.dougdomingos.structures.hashTable.hashing.openAddress.OpenAddressHash;
import com.dougdomingos.structures.hashTable.hashing.openAddress.OpenAddressHashing;

/**
 * Utility class for building hash functions.
 */
public class HashFunctionBuilder<T> {

    /**
     * Creates a closed address hash function.
     * 
     * @param method
     *            The method of hashing used by the function (e.g., DIVISION,
     *            MULTIPLICATION)
     * @return The function with the selected method, or null if the method is
     *         not recognized
     */
    public static <T> ClosedAddressHashing<T> buildClosedAddressHash(
            ClosedAddressHash method) {

        ClosedAddressHashing<T> hashFunction = null;

        switch (method) {
            case DIVISION:
                hashFunction = new DivisionHash<>();
                break;

            case MULTIPLICATION:
                hashFunction = new MultiplicationHash<>();
                break;
        }

        return hashFunction;
    }

    /**
     * Creates a open address hash function.
     * 
     * @param method
     *            The method of hashing used by the function (e.g.,
     *            LINEAR_PROBING, DOUBLE_HASHING)
     * @return The function with the selected method, or null if the method is
     *         not recognized
     */
    public static <T> OpenAddressHashing<T> buildOpenAddressHash(OpenAddressHash method) {

        OpenAddressHashing<T> hashFunction = null;

        switch (method) {
            case LINEAR_PROBING:
                hashFunction = new LinearProbingHash<>(new DivisionHash<>());
                break;

            case DOUBLE_HASHING:
                hashFunction = new DoubleHashing<>(new DivisionHash<>(),
                        new MultiplicationHash<>());
                break;
        }

        return hashFunction;
    }
}
