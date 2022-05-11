package com.atef.rover.plateau;

import java.util.Objects;

public class Grid {
    public final int width;
    public final int height;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grid grid = (Grid) o;
        return width == grid.width && height == grid.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    @Override
    public String toString() {
        return "Grid{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}