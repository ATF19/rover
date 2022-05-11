package com.atef.rover;

import java.util.Arrays;

public enum Instruction {
    TURN_LEFT('L'),
    TURN_RIGHT('R'),
    MOVE('M'),;

    public final char value;

    Instruction(char value) {
        this.value = value;
    }

    public static Instruction valueOf(char value) {
        return Arrays.stream(values())
                .filter(d -> d.value == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Instruction " + value + " is unknown."));
    }
}
