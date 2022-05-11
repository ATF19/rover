package com.atef.rover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    private Position position;

    @BeforeEach
    public void setup() {
        position = new Position(1, 2, Direction.NORTH);
    }

    @Test
    public void change_direction() {
        // given
        Direction newDirection = Direction.EAST;

        // when
        position.changeDirection(newDirection);

        // then
        assertThat(position.direction()).isEqualTo(newDirection);
    }

    @Test
    public void move_to_north() {
        // given

        // when
        position.move();

        // then
        assertThat(position.x()).isEqualTo(1);
        assertThat(position.y()).isEqualTo(3);
    }

    @Test
    public void move_to_south() {
        // given
        position.changeDirection(Direction.SOUTH);

        // when
        position.move();

        // then
        assertThat(position.x()).isEqualTo(1);
        assertThat(position.y()).isEqualTo(1);
    }

    @Test
    public void move_to_west() {
        // given
        position.changeDirection(Direction.WEST);

        // when
        position.move();

        // then
        assertThat(position.x()).isEqualTo(0);
        assertThat(position.y()).isEqualTo(2);
    }

    @Test
    public void move_to_east() {
        // given
        position.changeDirection(Direction.EAST);

        // when
        position.move();

        // then
        assertThat(position.x()).isEqualTo(2);
        assertThat(position.y()).isEqualTo(2);
    }
}