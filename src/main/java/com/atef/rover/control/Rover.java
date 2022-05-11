package com.atef.rover.control;

import com.atef.rover.plateau.Position;

import java.util.Objects;

public class Rover {
    private Position position;

    public Rover(Position position) {
        this.position = position;
    }

    public void handleInstruction(Instruction instruction) {
        switch (instruction) {
            case TURN_LEFT:
                position.changeDirection(position.direction().turnLeft());
                break;
            case TURN_RIGHT:
                position.changeDirection(position.direction().turnRight());
                break;
            case MOVE:
                position.move();
                break;
            default:
                throw new IllegalArgumentException("Instruction " + instruction + " is unknown.");
        }
    }

    public Position position() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return Objects.equals(position, rover.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "position=" + position +
                '}';
    }
}
