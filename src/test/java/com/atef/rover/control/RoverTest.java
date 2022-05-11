package com.atef.rover.control;

import com.atef.rover.control.Instruction;
import com.atef.rover.control.Rover;
import com.atef.rover.plateau.Direction;
import com.atef.rover.plateau.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class RoverTest {

    private Position position;
    private Rover rover;

    @BeforeEach
    public void setup() {
        position = mock(Position.class);
        rover = new Rover(position);
    }

    @Test
    public void turn_left_when_rover_is_directed_to_north() {
        // given
        given(position.direction()).willReturn(Direction.NORTH);

        // when
        rover.handleInstruction(Instruction.TURN_LEFT);

        // then
        verify(position).changeDirection(Direction.WEST);
    }

    @Test
    public void turn_right_when_rover_is_directed_to_north() {
        // given
        given(position.direction()).willReturn(Direction.NORTH);

        // when
        rover.handleInstruction(Instruction.TURN_RIGHT);

        // then
        verify(position).changeDirection(Direction.EAST);
    }

    @Test
    public void turn_left_when_rover_is_directed_to_east() {
        // given
        given(position.direction()).willReturn(Direction.EAST);

        // when
        rover.handleInstruction(Instruction.TURN_LEFT);

        // then
        verify(position).changeDirection(Direction.NORTH);
    }

    @Test
    public void turn_right_when_rover_is_directed_to_east() {
        // given
        given(position.direction()).willReturn(Direction.EAST);

        // when
        rover.handleInstruction(Instruction.TURN_RIGHT);

        // then
        verify(position).changeDirection(Direction.SOUTH);
    }

    @Test
    public void turn_left_when_rover_is_directed_to_south() {
        // given
        given(position.direction()).willReturn(Direction.SOUTH);

        // when
        rover.handleInstruction(Instruction.TURN_LEFT);

        // then
        verify(position).changeDirection(Direction.EAST);
    }

    @Test
    public void turn_right_when_rover_is_directed_to_south() {
        // given
        given(position.direction()).willReturn(Direction.SOUTH);

        // when
        rover.handleInstruction(Instruction.TURN_RIGHT);

        // then
        verify(position).changeDirection(Direction.WEST);
    }

    @Test
    public void turn_left_when_rover_is_directed_to_west() {
        // given
        given(position.direction()).willReturn(Direction.WEST);

        // when
        rover.handleInstruction(Instruction.TURN_LEFT);

        // then
        verify(position).changeDirection(Direction.SOUTH);
    }

    @Test
    public void turn_right_when_rover_is_directed_to_west() {
        // given
        given(position.direction()).willReturn(Direction.SOUTH);

        // when
        rover.handleInstruction(Instruction.TURN_RIGHT);

        // then
        verify(position).changeDirection(Direction.WEST);
    }

    @Test
    public void move_rover() {
        // given

        // when
        rover.handleInstruction(Instruction.MOVE);

        // then
        verify(position).move();
    }
}