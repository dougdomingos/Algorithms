package com.dougdomingos.structures;

public class StructureUnderflowException extends Exception {
	public StructureUnderflowException() {
		super("Structure is empty!");
	}
}
