package com.kodilla.sudokusolver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Board {

    private int[][] board;
    public static final int GRID = 9;
    public static final int BLOCK = 3;

    public int[][] getBoard() {
        return board;
    }

    public int[][] convertFileToArray(Path path) throws IOException, FileReaderException {
        board = Files.lines(path)
                .map((l)->l.trim().split("\\s+"))
                .map((sa)-> Stream.of(sa).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);
        return board;
    }

    public void printBoard(int[][] board) {
        System.out.println("\n" + "==== solved board ====");
        for (int row = 0; row < GRID; row++) {
            if (row % BLOCK == 0 && row != 0) {
                System.out.println(" - - - - - - - - - - -");
            }
            for (int column = 0; column < GRID; column++) {
                System.out.print(" ");
                if (column % BLOCK == 0 && column != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[row][column]);
            }
            System.out.println();
        }
        System.out.println("======================");
    }
}