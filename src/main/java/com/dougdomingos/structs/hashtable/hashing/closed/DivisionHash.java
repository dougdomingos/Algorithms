package com.dougdomingos.structs.hashtable.hashing.closed;

public class DivisionHash<T> implements ClosedAddressHashing<T> {

	@Override
	public int hash(T element, int tableSize) {
		int hashKey = element.hashCode();
		int hash = hashKey % tableSize;

		return hash;
	}
}
