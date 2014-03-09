package com.seabornlee.threes;

import com.google.common.collect.Range;

import java.util.Random;

public class Game {
    public static final int SIZE = 4;
    private final Cell[][] matrix = new Cell[SIZE][SIZE];
    private boolean isRunning;
    private Random random = new Random();

    public Game() {
        placeAnImmovableCell();
    }

    private void placeAnImmovableCell() {
        int row = random.nextInt(2);
        int col = random.nextInt(2);

        matrix[1 + row][1 + col] = Cell.IMMOVABLE;
    }

    public boolean isStarted() {
        return isRunning;
    }

    public void start() {
        for (int i = 0; i < 3; i++) {
            placeACell();
        }
        isRunning = true;
    }

    private void placeACell() {
        int i = random.nextInt(SIZE);
        int j = random.nextInt(SIZE);

        matrix[i][j] = new Cell(2);
    }

    public Cell cellAt(int row, int col) {
        return matrix[row][col];
    }

    private static class Cell {
        private static final Cell IMMOVABLE = new Cell(0);
        private int number;

        private Cell(int number) {
            this.number = number;
        }

        public boolean isMovable() {
            return !this.equals(IMMOVABLE);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Cell cell = (Cell) o;

            if (number != cell.number) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return number;
        }
    }
}
