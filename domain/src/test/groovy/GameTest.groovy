package com.seabornlee.threes

import static com.seabornlee.threes.Game.SIZE
import static org.assertj.core.api.Assertions.*

class GameTest extends groovy.util.GroovyTestCase {
    void testShouldInitWithOneImmovableCell() {
        def game = new Game()

        int countOfImmovableCell = 0
        int row, col
        for (int i=0; i<SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                def cell = game.cellAt(i, j)
                if (cell != null && !cell.isMovable()) {
                    row = i
                    col = j
                    countOfImmovableCell++
                }
            }
        }

        assertThat(countOfImmovableCell).isEqualTo(1)
        assertThat(row).isBetween(1, 2)
        assertThat(col).isBetween(1, 2)
    }

    void testShouldPlaceThreeCellsWhenGameStarted() {
        def game = new Game()

        game.start()

        int countOfMovableCells = 0
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                def cell = game.cellAt(i, j)
                if (cell != null && cell.movable) {
                    countOfMovableCells++
                }
            }

        }

        assertThat(countOfMovableCells).isEqualTo(3)
        assertThat(game.isStarted()).isTrue()
    }
}
