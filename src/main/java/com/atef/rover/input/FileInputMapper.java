package com.atef.rover.input;

import com.atef.rover.control.Instruction;
import com.atef.rover.control.Rover;
import com.atef.rover.control.RoverControlPanel;
import com.atef.rover.plateau.Direction;
import com.atef.rover.plateau.Grid;
import com.atef.rover.plateau.Position;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileInputMapper implements InputMapper {

    private final String filePath;

    public FileInputMapper(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<RoverControlPanel> map() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line = bufferedReader.readLine();
            if (line == null || line.isEmpty())
                throw new IllegalArgumentException("File could not be empty.");

            List<RoverControlPanel> roverControlPanels = new ArrayList<>();
            Grid grid = extractGridFromFirstLine(line);
            line = bufferedReader.readLine();
            List<Instruction> instructions;
            Rover rover = null;
            int lineCount = 2;
            while (line != null) {
                if (lineCount % 2 == 0)
                    rover = extractRoverFromLine(line, grid);
                else {
                    instructions = extractInstructionsFromLine(line);
                    roverControlPanels.add(new RoverControlPanel(rover, instructions));
                }
                lineCount++;
                line = bufferedReader.readLine();
            }
            return roverControlPanels;
        } catch (FileNotFoundException e) {
            System.err.println("Could not find file " + filePath);
            return Collections.emptyList();
        } catch (IOException e) {
            System.err.println("Error reading file " + filePath);
            return Collections.emptyList();
        }
    }

    private Grid extractGridFromFirstLine(String line) {
        String[] splittedLine = line.split(" ");
        int width = Integer.parseInt(splittedLine[0]);
        int height = Integer.parseInt(splittedLine[1]);
        return new Grid(width, height);
    }

    private List<Instruction> extractInstructionsFromLine(String line) {
        String[] splittedLine = line.split("");
        return Arrays.stream(splittedLine)
                .map(rawInstruction -> rawInstruction.charAt(0))
                .map(Instruction::valueOf)
                .collect(Collectors.toList());
    }

    private Rover extractRoverFromLine(String line, Grid grid) {
        String[] splittedLine = line.split(" ");
        int x = Integer.parseInt(splittedLine[0]);
        int y = Integer.parseInt(splittedLine[1]);
        char direction = splittedLine[2].charAt(0);
        return new Rover(new Position(x, y, Direction.valueOf(direction), grid));

    }
}
