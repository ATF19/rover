package com.atef.rover;

public class RoverApplication {

    public static void main(String[] args) {
        System.out.println("Running Rover Application...");
        verifyInputFileArgumentIsProvided(args);
        String inputFile = args[0];
        System.out.println(inputFile);
    }

    private static void verifyInputFileArgumentIsProvided(String[] args) {
        if (args.length == 0) {
            System.err.println("Please provide the input file as argument.");
            System.exit(1);
        }
    }
}
