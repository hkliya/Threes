package com.seabornlee.threes

import static com.seabornlee.threes.Game.SIZE
import static org.assertj.core.api.Assertions.*

class GameTest extends groovy.util.GroovyTestCase {
    void testShouldStartGame() {
        def game = new Game()

        game.start()

        assertThat(game.isStarted()).isTrue()
    }

    void testShouldInitWithOneImmovableCell() {
        def game = new Game()

        int countOfImmovableCell = 0
        for (int i=0; i<SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                def cell = game.cellAt(i, j)
                if (cell != null && cell.isImmovable()) {
                    assertThat(i).isBetween(1, 2)
                    assertThat(j).isBetween(1, 2)

                    countOfImmovableCell++
                }
            }
        }

        assertThat(countOfImmovableCell).isEqualTo(1)
    }
}
