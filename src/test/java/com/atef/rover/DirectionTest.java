package com.atef.rover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    private Direction north;
    private Direction west;
    private Direction east;
    private Direction south;

    @BeforeEach
    public void setup() {
        north = Direction.NORTH;
        west = Direction.WEST;
        east = Direction.EAST;
        south = Direction.SOUTH;
    }

    @Test
    public void turn_left_from_north() {
        // given

        // when
        Direction result = north.turnLeft();

        // then
        assertThat(result).isEqualTo(Direction.WEST);
    }

    @Test
    public void turn_right_from_north() {
        // given

        // when
        Direction result = north.turnRight();

        // then
        assertThat(result).isEqualTo(Direction.EAST);
    }

    @Test
    public void turn_left_from_west() {
        // given

        // when
        Direction result = west.turnLeft();

        // then
        assertThat(result).isEqualTo(Direction.SOUTH);
    }

    @Test
    public void turn_right_from_west() {
        // given

        // when
        Direction result = west.turnRight();

        // then
        assertThat(result).isEqualTo(Direction.NORTH);
    }

    @Test
    public void turn_left_from_south() {
        // given

        // when
        Direction result = south.turnLeft();

        // then
        assertThat(result).isEqualTo(Direction.EAST);
    }

    @Test
    public void turn_right_from_south() {
        // given

        // when
        Direction result = south.turnRight();

        // then
        assertThat(result).isEqualTo(Direction.WEST);
    }

    @Test
    public void turn_left_from_east() {
        // given

        // when
        Direction result = east.turnLeft();

        // then
        assertThat(result).isEqualTo(Direction.NORTH);
    }

    @Test
    public void turn_right_from_east() {
        // given

        // when
        Direction result = east.turnRight();

        // then
        assertThat(result).isEqualTo(Direction.SOUTH);
    }
}