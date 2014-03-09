package com.seabornlee.threes

import static org.assertj.core.api.Assertions.assertThat
import static org.mockito.Mockito.mock
import static org.mockito.Mockito.when

class GameTest extends groovy.util.GroovyTestCase {
    void testShouldInitWithOneImmovableCell() {
        // given
        def coordinateGenerator = mock(CoordinateGenerator)
        when(coordinateGenerator.generate()).thenReturn(new Coordinate(2, 2))

        // when
        def game = new Game(coordinateGenerator)

        // then
        assertThat(game.cellAt(2, 2).movable).isFalse()
    }

    void testShouldPlaceThreeCellsWhenGameStarted() {
        // given
        def coordinateGenerator = mock(CoordinateGenerator)
        when(coordinateGenerator.generate()).thenReturn(new Coordinate(2, 2), new Coordinate(0, 0), new Coordinate(1, 0), new Coordinate(2, 0))
        def game = new Game(coordinateGenerator)

        // when
        game.start()

        // then
        assertThat(game.cellAt(0, 0).number).isEqualTo(2)
        assertThat(game.cellAt(1, 0).number).isEqualTo(2)
        assertThat(game.cellAt(2, 0).number).isEqualTo(2)
        assertThat(game.isStarted()).isTrue()
    }

    void testShouldMoveRightWhenRightIsEmpty() {
        // given
        def generator = mock(CoordinateGenerator.class)
        when(generator.generate()).thenReturn(new Coordinate(1, 1), new Coordinate(0, 0), new Coordinate(2, 1), new Coordinate(3, 2));
        def game = new Game(generator)
        game.start()

        // when
        game.moveRight()

        // then
        assertThat(game.cellAt(0, 3).number).isEqualTo(2)
        assertThat(game.cellAt(2, 3).number).isEqualTo(2)
        assertThat(game.cellAt(3, 3).number).isEqualTo(2)
        assertThat(game.cellAt(0, 0)).isNull()
        assertThat(game.cellAt(2, 1)).isNull()
        assertThat(game.cellAt(3, 2)).isNull()
    }

    void testShouldNotMoveImmovableCell() {
        // given
        def generator = mock(CoordinateGenerator.class)
        when(generator.generate()).thenReturn(new Coordinate(1, 1), new Coordinate(0, 0), new Coordinate(2, 1), new Coordinate(3, 2));
        def game = new Game(generator)
        game.start()

        // when
        game.moveRight()

        // then
        assertThat(game.cellAt(1, 1).isMovable()).isFalse()
    }

    void testShouldMergeCellsWhenHasSameNumber() {
        // given
        def generator = mock(CoordinateGenerator.class)
        when(generator.generate()).thenReturn(new Coordinate(1, 1), new Coordinate(0, 0), new Coordinate(0, 1), new Coordinate(3, 2));
        def game = new Game(generator)
        game.start()

        // when
        game.moveRight()

        // then
        assertThat(game.cellAt(0, 3).number).isEqualTo(4)
    }

}
