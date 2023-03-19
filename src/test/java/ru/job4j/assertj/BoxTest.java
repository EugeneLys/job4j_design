package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 4);
        String name = box.whatsThis();
        assertThat(name).startsWith("Tet")
                .contains("rahed")
                .endsWith("ron")
                .isEqualTo("Tetrahedron");
    }

    @Test
    void isThisUnknown() {
        Box box = new Box(6, 3);
        String name = box.whatsThis();
        assertThat(name).isNotEmpty()
                .doesNotContain("Tet", "Cu")
                .hasSameSizeAs("1234567_654321")
                .isEqualTo("Unknown object");
    }

    @Test
    void numberOfVerticesIsFour() {
        Box box = new Box(4, 4);
        int result = box.getNumberOfVertices();
        assertThat(result).isGreaterThan(-1)
                .isNotEqualTo(3)
                .isLessThan(1000)
                .isEqualTo(4);
    }

    @Test
    void numberOfVerticesIsNegative() {
        Box box = new Box(3, 4);
        int result = box.getNumberOfVertices();
        assertThat(result).isNegative()
                .isLessThan(1)
                .isCloseTo(-1, Percentage.withPercentage(10))
                .isEqualTo(-1);
    }

    @Test
    void existingBox() {
        Box box = new Box(8, 1);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void nonexistentBox() {
        Box box = new Box(8, 0);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }

    @Test
    void areaOfCube() {
        Box box = new Box(8, 2);
        double result = box.getArea();
        assertThat(result).isNotZero()
                .isCloseTo(24.0d, withPrecision(0.001d))
                .isGreaterThan(23.99d)
                .isBetween(23.999d, 24.001d);
    }

    @Test
    void areaOfTetrahedron() {
        Box box = new Box(4, 2);
        double result = box.getArea();
        assertThat(result).isPositive()
                .isCloseTo(6.928d, withPrecision(0.001d))
                .isGreaterThan(6.0d)
                .isBetween(6.927d, 6.929d)
                .isLessThan(100d);
    }
}