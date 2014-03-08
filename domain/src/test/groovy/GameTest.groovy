package com.seabornlee.threes

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
        for (int i=0; i<5; i++) {
            for (int j = 0; j < 5; j++) {
                if (game.cellAt(i, j).isImmovable())
                    countOfImmovableCell++
            }
        }

        assertEquals(1, countOfImmovableCell)
    }
}
