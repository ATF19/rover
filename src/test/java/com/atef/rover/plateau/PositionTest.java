package com.atef.rover.plateau;

import com.atef.rover.plateau.Direction;
import com.atef.rover.plateau.Grid;
import com.atef.rover.plateau.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    private Position position;
    private Grid grid;

    @BeforeEach
    public void setup() {
        grid = new Grid(5, 5);
        position = new Position(1, 2, Direction.NORTH, grid);
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

    @Test
    public void throw_error_if_trying_to_move_to_position_outside_the_grid() {
        // given
        grid = new Grid(2, 3);
        position = new Position(2, 2, Direction.EAST, grid);

        // when

        // then
        assertThatThrownBy(() -> position.move())
                .isInstanceOf(IllegalArgumentException.class);
    }
}