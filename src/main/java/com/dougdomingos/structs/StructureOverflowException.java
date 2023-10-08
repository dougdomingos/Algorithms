package com.dougdomingos.structs;

public class StructureOverflowException extends Exception {
	public StructureOverflowException() {
		super("Structure is full!");
	}
}
