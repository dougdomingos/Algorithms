package com.dougdomingos.structures.hashtable.hashing.closedaddress;

public class DivisionHash<T> implements ClosedAddressHashing<T> {

	@Override
	public int hash(T element, int tableSize) {
		int hashKey = element.hashCode();
		int hash = hashKey % tableSize;

		return hash;
	}
}
