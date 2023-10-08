package com.dougdomingos.structures.hashtable.hashing;

import com.dougdomingos.structures.hashtable.hashing.closedaddress.ClosedAddressHashing;
import com.dougdomingos.structures.hashtable.hashing.closedaddress.ClosedAddressMethods;
import com.dougdomingos.structures.hashtable.hashing.closedaddress.DivisionHash;
import com.dougdomingos.structures.hashtable.hashing.closedaddress.MultiplicationHash;
import com.dougdomingos.structures.hashtable.hashing.openaddress.DoubleHashing;
import com.dougdomingos.structures.hashtable.hashing.openaddress.LinearProbingHash;
import com.dougdomingos.structures.hashtable.hashing.openaddress.OpenAddressHashing;
import com.dougdomingos.structures.hashtable.hashing.openaddress.OpenAddressMethods;

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
			ClosedAddressMethods method) {

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
	public static <T> OpenAddressHashing<T> buildOpenAddressHash(
			OpenAddressMethods method) {

		OpenAddressHashing<T> hashFunction = null;

		switch (method) {
			case LINEAR_PROBING:
				hashFunction = new LinearProbingHash<>(new DivisionHash<>());
				break;

			case DOUBLE_HASHING:
				hashFunction = new DoubleHashing<>(new DivisionHash<>());
				break;
		}

		return hashFunction;
	}
}
