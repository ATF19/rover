package com.atef.rover;

public class Rover {
    private Position position;

    public Rover(Position position) {
        this.position = position;
    }

    public void changeDirection(Direction direction) {
        position.changeDirection(direction);
    }

    public void move() {
        position.move();
    }

    public Position position() {
        return position;
    }
}
