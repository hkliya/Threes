package com.seabornlee.threes

import com.google.common.collect.Sets

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

    void testShouldGenerateUniqueCoordinate() {
        // given
        def generator = new CoordinateGenerator()

        // when
        def set = Sets.newHashSet()
        10.times {
            set.add(generator.generate())
        }

        // then
        assertThat(set).hasSize(10)
    }
}
