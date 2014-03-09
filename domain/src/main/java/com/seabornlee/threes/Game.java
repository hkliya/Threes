package com.seabornlee.threes;

import java.util.Random;

public class Game {
    public static final int SIZE = 4;
    private final Cell[][] matrix = new Cell[SIZE][SIZE];
    private boolean isRunning;

    public Game() {
        initMatrix();
        placeAnImmovableCell();
    }

    private void initMatrix() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrix[i][j] = new Cell();
            }
        }
    }

    private void placeAnImmovableCell() {
        Random random = new Random();
        int row = random.nextInt(2);
        int col = random.nextInt(2);

        matrix[1 + row][1 + col] = Cell.IMMOVABLE;
    }

    public boolean isStarted() {
        return isRunning;
    }

    public void start() {
        isRunning = true;
    }

    public Cell cellAt(int row, int col) {
        return matrix[row][col];
    }

    private static class Cell {
        public static final Cell IMMOVABLE = new Cell() {
            @Override
            public boolean isImmovable() {
                return true;
            }
        };

        public boolean isImmovable() {
            return false;
        }
    }
}
