package com.dougdomingos.structures;

public class StructureOverflowException extends Exception {
    public StructureOverflowException() {
        super("Structure is full!");
    }
}
