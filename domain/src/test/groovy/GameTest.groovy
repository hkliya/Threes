package com.seabornlee.threes

class GameTest extends groovy.util.GroovyTestCase {
    void testShouldStartGame() {
        def game = new Game()
        assertFalse(game.isStarted())

        game.start()

        assertTrue(game.isStarted())
    }
}
