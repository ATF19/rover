package com.atef.rover.plateau;

import com.atef.rover.plateau.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    public void create_direction_from_ra_value() {
        // given
        char n = 'N';
        char e = 'E';
        char w = 'W';
        char s = 'S';

        // when
        Direction north = Direction.valueOf(n);
        Direction east = Direction.valueOf(e);
        Direction west = Direction.valueOf(w);
        Direction south = Direction.valueOf(s);

        // then
        assertThat(north).isEqualTo(Direction.NORTH);
        assertThat(east).isEqualTo(Direction.EAST);
        assertThat(west).isEqualTo(Direction.WEST);
        assertThat(south).isEqualTo(Direction.SOUTH);
    }

    @Test
    public void throw_error_if_provided_with_wrong_raw_direction() {
        // given
        char i = 'i';

        // when

        // then
        assertThatThrownBy(() -> Direction.valueOf(i))
                .isInstanceOf(IllegalArgumentException.class);
    }
}