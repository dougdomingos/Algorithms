package com.dougdomingos.structures.hashTable.hashing.closedAddress;

/**
 * Avaliable hashing methods for closed address tables.
 * 
 * @see #DIVISION
 * @see #MULTIPLICATION
 */
public enum ClosedAddressMethods {

    /**
     * Division Hashing consists on calculating the remainder of the element's
     * hash divided by the table size and using it as a table index for the
     * element.
     */
    DIVISION,

    /**
     * Multiplication Hashing consists of multiplying the element's hash with a
     * fractional constant and multiplying the result with the table size to
     * determine the slot in which the element will go.
     */
    MULTIPLICATION
}
