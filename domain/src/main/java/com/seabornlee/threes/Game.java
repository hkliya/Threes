package com.seabornlee.threes;

public class Game {
    public static final int SIZE = 4;
    private final Cell[][] matrix = new Cell[SIZE][SIZE];
    private boolean isRunning;
    private CoordinateGenerator coordinateGenerator;

    public Game(CoordinateGenerator coordinateGenerator) {
        this.coordinateGenerator = coordinateGenerator;
        placeAnImmovableCell();
    }

    private void placeAnImmovableCell() {
        Coordinate coordinate = coordinateGenerator.generate();
        matrix[coordinate.row][coordinate.col] = Cell.IMMOVABLE;
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
        Coordinate coordinate = coordinateGenerator.generate();
        matrix[coordinate.row][coordinate.col] = new Cell(2);
    }

    public Cell cellAt(int row, int col) {
        return matrix[row][col];
    }

    public void moveRight() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 2; col >= 0; col--) {
                Cell cell = matrix[row][col];
                if (cell != null && cell.isMovable()) {
                    for (int temp = col; temp < SIZE - 1; temp++) {
                        Cell rightCell = matrix[row][temp + 1];
                        if (rightCell == null) {
                            matrix[row][temp + 1] = matrix[row][temp];
                            matrix[row][temp] = null;
                        } else if (rightCell.getNumber() == matrix[row][temp].getNumber()) {
                            matrix[row][temp + 1].number *= 2;
                            matrix[row][temp] = null;
                        }
                    }
                }
            }
        }
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

        public int getNumber() {
            return number;
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
