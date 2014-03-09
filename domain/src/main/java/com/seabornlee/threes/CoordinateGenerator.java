package com.seabornlee.threes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.seabornlee.threes.Game.SIZE;

public class CoordinateGenerator {
    private List<Coordinate> coordinates = new ArrayList<Coordinate>();
    private Random random = new Random();

    public CoordinateGenerator() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                coordinates.add(new Coordinate(row, col));
            }
        }
    }

    public Coordinate generate() {
        int randomIndex = random.nextInt(coordinates.size());
        return coordinates.remove(randomIndex);
    }
}
