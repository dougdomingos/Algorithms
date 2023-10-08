package com.dougdomingos.structs.hashtable.hashing.open;

import com.dougdomingos.structs.hashtable.hashing.closed.ClosedAddressHashing;

public class LinearProbingHash<T> implements OpenAddressHashing<T> {

	private ClosedAddressHashing<T> auxHash;

	public LinearProbingHash(ClosedAddressHashing<T> hashFunction) {
		this.auxHash = hashFunction;
	}

	@Override
	public int hash(T element, int tableSize, int probeIndex) {
		int hash = (auxHash.hash(element, tableSize) + probeIndex) % tableSize;

		return hash;
	}

}
