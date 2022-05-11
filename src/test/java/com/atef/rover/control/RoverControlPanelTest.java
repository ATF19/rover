package com.atef.rover.control;

import com.atef.rover.plateau.Direction;
import com.atef.rover.plateau.Grid;
import com.atef.rover.plateau.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RoverControlPanelTest {

    private List<Instruction> instructions;
    private Grid grid;
    private Rover rover;
    private RoverControlPanel roverControlPanel;

    @BeforeEach
    public void setup() {
        grid = new Grid(5, 5);
    }

    @Test
    public void follow_LMLMLMLMM_instructions() {
        // given
        // LMLMLMLMM
        instructions = Arrays.asList(
                Instruction.TURN_LEFT, Instruction.MOVE, Instruction.TURN_LEFT, Instruction.MOVE,
                Instruction.TURN_LEFT, Instruction.MOVE, Instruction.TURN_LEFT, Instruction.MOVE, Instruction.MOVE
        );
        rover = new Rover(new Position(1, 2, Direction.NORTH, grid));
        roverControlPanel = new RoverControlPanel(rover, instructions);

        // when
        roverControlPanel.followInstructions();

        // then
        assertThat(roverControlPanel.roverPosition()).isEqualTo(new Position(1, 3, Direction.NORTH, grid));
    }

    @Test
    public void follow_MMRMMRMRRM_instructions() {
        // given
        // MMRMMRMRRM
        instructions = Arrays.asList(
                Instruction.MOVE, Instruction.MOVE, Instruction.TURN_RIGHT, Instruction.MOVE, Instruction.MOVE,
                Instruction.TURN_RIGHT, Instruction.MOVE, Instruction.TURN_RIGHT, Instruction.TURN_RIGHT, Instruction.MOVE
        );
        rover = new Rover(new Position(3, 3, Direction.EAST, grid));
        roverControlPanel = new RoverControlPanel(rover, instructions);

        // when
        roverControlPanel.followInstructions();

        // then
        assertThat(roverControlPanel.roverPosition()).isEqualTo(new Position(5, 1, Direction.EAST, grid));
    }
}