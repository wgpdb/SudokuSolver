package com.kodilla.sudokusolver;

public class Runner {

    User user = new User();
    Board board = new Board();
    Solver solver = new Solver();

    public void run() {

        user.intro();

        while (true) {
            user.enterPath();

            try {
                user.importFile(user.getUserEntry());
            } catch (FileReaderException e) {
                System.out.println("\n" + "Error reading file!" + "\n" + e);
                continue;
            }

            try {
                board.convertFileToArray(user.getPath());
            } catch (Exception e) {
                System.out.println("\n" + "Error reading file!" + "\n" + e);
                continue;
            }

            try {
                if (solver.solveBoard(board.getBoard())) {
                    board.printBoard(solver.getSolvedBoard());
                } else {
                    user.unsolvableSudoku();
                }
            } catch (Exception e) {
                System.out.println("\n" + "Sudoku board is empty or file format is not correct!" + "\n" +
                        "Please check the txt file and try again.");
                user.setSolveAnotherPuzzle(true);
                continue;
            }

            user.quitOrContinue();

            if (user.isSolveAnotherPuzzle()) {
                continue;
            }
        }
    }
}