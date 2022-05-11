package com.atef.rover.control;

import com.atef.rover.plateau.Position;

import java.util.List;
import java.util.Objects;

public class RoverControlPanel {
    private final Rover rover;
    private final List<Instruction> instructions;

    public RoverControlPanel(Rover rover, List<Instruction> instructions) {
        this.rover = rover;
        this.instructions = instructions;
    }

    public void followInstructions() {
        for (Instruction instruction : instructions)
            rover.handleInstruction(instruction);
    }

    public Position roverPosition() {
        return rover.position();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoverControlPanel that = (RoverControlPanel) o;
        return Objects.equals(rover, that.rover) && Objects.equals(instructions, that.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rover, instructions);
    }

    @Override
    public String toString() {
        return "RoverControlPanel{" +
                "rover=" + rover +
                ", instructions=" + instructions +
                '}';
    }
}
