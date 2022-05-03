package com.kodilla.sudokusolver;

import static com.kodilla.sudokusolver.Board.GRID;
import static com.kodilla.sudokusolver.Board.BLOCK;

public class Solver {

    private int[][] solvedBoard;

    public int[][] getSolvedBoard() {
        return solvedBoard;
    }

    private boolean isCandidateNumberInRow(int[][] board, int number, int row) {
        for (int i = 0; i < GRID; i++) {
            if (board[row][i] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isCandidateNumberInColumn(int[][] board, int number, int column) {
        for (int i = 0; i < GRID; i++) {
            if (board[i][column] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isCandidateNumberInBlock(int [][] board, int number, int row, int column) {
        int blockRow = row - row % BLOCK;
        int blockColumn = column - column % BLOCK;

        for (int i = blockRow; i < blockRow + BLOCK; i++) {
            for (int j = blockColumn; j < blockColumn + BLOCK; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCandidatePlacementValid(int [][] board, int candidate, int row, int column) {
        return !isCandidateNumberInRow(board, candidate, row) &&
                !isCandidateNumberInColumn(board, candidate, column) &&
                !isCandidateNumberInBlock(board, candidate, row, column);
    }

    public boolean solveBoard(int[][] board) {
        for (int row = 0; row < GRID; row++) {
            for (int column = 0; column < GRID; column++) {
                if (board[row][column] == 0) {
                    for (int candidate = 1; candidate <= GRID; candidate++) {
                        if (isCandidatePlacementValid(board, candidate, row, column)) {
                            board[row][column] = candidate;
                            if (solveBoard(board)) {
                                return true;
                            } else {
                                board[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        solvedBoard = board;
        return true;
    }
}