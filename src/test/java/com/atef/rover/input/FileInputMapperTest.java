package com.atef.rover.input;


import com.atef.rover.control.Instruction;
import com.atef.rover.control.Rover;
import com.atef.rover.control.RoverControlPanel;
import com.atef.rover.plateau.Direction;
import com.atef.rover.plateau.Grid;
import com.atef.rover.plateau.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FileInputMapperTest {

    private String filePath;
    private FileInputMapper fileInputMapper;

    @BeforeEach
    public void setup() {
        filePath = "input.txt";
        fileInputMapper = new FileInputMapper(filePath);
    }

    @Test
    public void map_file_to_rover_control_panel() {
        // given

        // when
        List<RoverControlPanel> result = fileInputMapper.map();

        // then
        assertThat(result).containsExactlyInAnyOrder(
                expectedRoverPanel1(),
                expectedRoverPanel2()
        );
    }

    private RoverControlPanel expectedRoverPanel1() {
        List<Instruction> instructions = Arrays.asList(
                Instruction.TURN_LEFT, Instruction.MOVE, Instruction.TURN_LEFT, Instruction.MOVE,
                Instruction.TURN_LEFT, Instruction.MOVE, Instruction.TURN_LEFT, Instruction.MOVE, Instruction.MOVE
        );
        Rover rover = new Rover(new Position(1, 2, Direction.NORTH, new Grid(5, 5)));
        return new RoverControlPanel(rover, instructions);
    }

    private RoverControlPanel expectedRoverPanel2() {
        List<Instruction> instructions = Arrays.asList(
                Instruction.MOVE, Instruction.MOVE, Instruction.TURN_RIGHT, Instruction.MOVE, Instruction.MOVE,
                Instruction.TURN_RIGHT, Instruction.MOVE, Instruction.TURN_RIGHT, Instruction.TURN_RIGHT, Instruction.MOVE
        );
        Rover rover = new Rover(new Position(3, 3, Direction.EAST, new Grid(5, 5)));
        return new RoverControlPanel(rover, instructions);
    }
}