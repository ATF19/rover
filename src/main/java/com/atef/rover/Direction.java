package com.atef.rover;

public enum Direction {
    NORTH('N'),
    WEST('W'),
    EAST('E'),
    SOUTH('S');

    public final char value;

    Direction(char value) {
        this.value = value;
    }

    public Direction turnLeft() {
        switch (this) {
            case NORTH:
                return WEST;
            case WEST:
                return SOUTH;
            case EAST:
                return NORTH;
            case SOUTH:
                return EAST;
            default:
                throw new IllegalStateException("Direction " + name() + " is unknown.");
        }
    }

    public Direction turnRight() {
        switch (this) {
            case NORTH:
                return EAST;
            case WEST:
                return NORTH;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            default:
                throw new IllegalStateException("Direction " + name() + " is unknown.");
        }
    }
}
