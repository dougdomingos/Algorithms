package com.dougdomingos.structs.hashtable.hashing.closed;

public class MultiplicationHash<T> implements ClosedAddressHashing<T> {

	private final double K = (Math.sqrt(5) - 1) / 2;

	@Override
	public int hash(T element, int tableSize) {
		int hashKey = element.hashCode();
		double fraction = (hashKey * K) - Math.floor(hashKey * K);
		int hash = (int) (tableSize * fraction);

		return hash;
	}

}
