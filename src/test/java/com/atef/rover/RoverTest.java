package com.atef.rover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class RoverTest {

    private Position position;
    private Rover rover;

    @BeforeEach
    public void setup() {
        position = mock(Position.class);
        rover = new Rover(position);
    }

    @Test
    public void delegate_change_direction_to_position() {
        // given
        Direction newDirection = Direction.NORTH;

        // when
        rover.changeDirection(newDirection);

        // then
        verify(position).changeDirection(newDirection);
    }

    @Test
    public void delegate_move_to_position() {
        // given

        // when
        rover.move();

        // then
        verify(position).move();
    }
}