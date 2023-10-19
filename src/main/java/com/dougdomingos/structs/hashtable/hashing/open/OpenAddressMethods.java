package com.dougdomingos.structs.hashtable.hashing.open;

/**
 * Avaliable hashing methods for Open Address tables.
 *
 * @see #LINEAR_PROBING
 * @see #DOUBLE_HASHING
 */
public enum OpenAddressMethods {

	/**
	 * Linear Probing resolves collisions by probing linearly through slots
	 * until an avaliable position is found or the probe has reached the limit
	 * of the table.
	 */
	LINEAR_PROBING,

	/**
	 * Double Hashing resolves collisions by using a secondary hash function to
	 * calculate the step size for probing, distributing elements more evenly in
	 * the table.
	 */
	DOUBLE_HASHING,
}
