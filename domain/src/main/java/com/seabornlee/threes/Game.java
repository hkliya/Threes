package com.seabornlee.threes;

public class Game {
    private boolean isRunning;

    public boolean isStarted() {
        return isRunning;
    }

    public void start() {
        isRunning = true;
    }
}
