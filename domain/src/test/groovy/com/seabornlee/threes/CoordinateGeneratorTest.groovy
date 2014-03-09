package com.seabornlee.threes

import static org.assertj.core.api.Assertions.assertThat

class CoordinateGeneratorTest extends GroovyTestCase {
    void testShouldGenerateCoordinateInRange() {
        // given
        def generator = new CoordinateGenerator();
        
        // when
        def coordinate = generator.generate();
        
        // then
        assertThat(coordinate.row).isBetween(0, 3)
        assertThat(coordinate.col).isBetween(0, 3)
    }
}
