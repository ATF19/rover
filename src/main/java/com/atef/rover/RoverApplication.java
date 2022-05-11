package com.atef.rover;

import com.atef.rover.control.RoverControlPanel;
import com.atef.rover.input.FileInputMapper;
import com.atef.rover.input.InputMapper;
import com.atef.rover.plateau.Position;

import java.util.List;

public class RoverApplication {

    public static void main(String[] args) {
        System.out.println("Running Rover Application...");
        verifyInputFileArgumentIsProvided(args);
        String inputFile = args[0];
        InputMapper inputMapper = new FileInputMapper(inputFile);
        List<RoverControlPanel> roverControlPanels = inputMapper.map();
        for (RoverControlPanel roverControlPanel : roverControlPanels) {
            roverControlPanel.followInstructions();
            Position roverPosition = roverControlPanel.roverPosition();
            System.out.println(roverPosition.x() + " " + roverPosition.y() + " " + roverPosition.direction().value);
        }
    }

    private static void verifyInputFileArgumentIsProvided(String[] args) {
        if (args.length == 0) {
            System.err.println("Please provide the input file as argument.");
            System.exit(1);
        }
    }
}
