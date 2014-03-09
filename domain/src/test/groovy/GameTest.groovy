package com.seabornlee.threes

import static com.seabornlee.threes.Game.SIZE

class GameTest extends groovy.util.GroovyTestCase {
    void testShouldStartGame() {
        def game = new Game()
        assertFalse(game.isStarted())

        game.start()

        assertTrue(game.isStarted())
    }

    void testShouldInitWithOneImmovableCell() {
        def game = new Game()

        int countOfImmovableCell = 0
        for (int i=0; i<SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (game.cellAt(i, j).isImmovable())
                    countOfImmovableCell++
            }
        }

        assertEquals(1, countOfImmovableCell)
    }
}
