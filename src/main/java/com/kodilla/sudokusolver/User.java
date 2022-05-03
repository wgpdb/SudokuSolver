package com.kodilla.sudokusolver;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class User {

    private Path path;
    private String userEntry;
    private boolean solveAnotherPuzzle = false;

    private Scanner scanner = new Scanner(System.in);

    public Path getPath() {
        return path;
    }

    public String getUserEntry() {
        return userEntry;
    }

    public void setSolveAnotherPuzzle(boolean solveAnotherPuzzle) {
        this.solveAnotherPuzzle = solveAnotherPuzzle;
    }

    public boolean isSolveAnotherPuzzle() {
        return solveAnotherPuzzle;
    }

    public void intro() {
        System.out.println(
                "<<<< SUDOKU SOLVER >>>>" + "\n" + "\n" +
                "To solve a sudoku puzzle, prepare a txt file with the board " +
                "in the following format: " + "\n" + "\n" +
                "8 0 0 0 0 0 0 0 0" + "\n" +
                "0 0 3 6 0 0 0 0 0" + "\n" +
                "0 7 0 0 9 0 2 0 0" + "\n" +
                "0 5 0 0 0 7 0 0 0" + "\n" +
                "0 0 0 0 4 5 7 0 0" + "\n" +
                "0 0 0 1 0 0 0 3 0" + "\n" +
                "0 0 1 0 0 0 0 6 8" + "\n" +
                "0 0 8 5 0 0 0 1 0" + "\n" +
                "0 9 0 0 0 0 4 0 0" + "\n" + "\n" +
                "where \"0\" represents empty fields in the puzzle."
                );
    }

    public String enterPath() {
        System.out.println("\n" + "Enter path to txt file:");
        userEntry = scanner.nextLine();
        return userEntry;
    }

    public Path importFile(String filePath) throws FileReaderException {
        path = Paths.get(filePath);
        return path;
    }

    public void quitOrContinue() {
        while (true) {
            System.out.println("\n" + "Would you like to solve another puzzle?" + "\n" +
                    "Select \"Y\" to continue or \"Q\" to quit");

            String selection = scanner.nextLine();

            if (selection.equals("Y") || selection.equals("y")) {
                solveAnotherPuzzle = true;
                break;
            } else if (selection.equals("Q") || selection.equals("q")) {
                System.exit(0);
            } else {
                System.out.println("\n" + "\"" + selection + "\"" + " is not a valid selection.");
            }
        }
    }

    public void unsolvableSudoku() {
        System.out.println("\n" + "Sorry, this sudoku is unsolvable :-(");
    }
}