package com.seabornlee.threes

import static org.assertj.core.api.Assertions.*

class CoordinateTest extends GroovyTestCase {
    void testEquality() {
        assertThat(new Coordinate(0, 0).equals(new Coordinate(0, 0))).isTrue()
        assertThat(new Coordinate(0, 0).equals(new Coordinate(0, 1))).isFalse()
    }
}
