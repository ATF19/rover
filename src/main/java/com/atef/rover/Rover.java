package com.atef.rover;

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
}
