package com.atef.rover.plateau;

import java.util.Objects;

public class Position {
    private int x;
    private int y;
    private Direction direction;
    private final Grid grid;

    public Position(int x, int y, Direction direction, Grid grid) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.grid = grid;
    }

    public void changeDirection(Direction direction) {
        this.direction = direction;
    }

    public void move() {
        int newX = x;
        int newY = y;
        switch (direction) {
            case NORTH:
                newY = y + 1;
                break;
            case SOUTH:
                newY = y - 1;
                break;
            case WEST:
                newX = x - 1;
                break;
            case EAST:
                newX = x + 1;
                break;
        }
        verifyNewPositionIsInTheGrid(newX, newY);

        x = newX;
        y = newY;
    }

    private void verifyNewPositionIsInTheGrid(int newX, int newY) {
        if (isNotWithinBoundaries(newX, grid.width) || isNotWithinBoundaries(newY, grid.height))
            throw new IllegalArgumentException("Cannot move to position, it is outside the grid.");
    }

    private boolean isNotWithinBoundaries(int coordinate, int size) {
        return coordinate < 0 || coordinate > size;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public Direction direction() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y && direction == position.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, direction);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
    }
}
