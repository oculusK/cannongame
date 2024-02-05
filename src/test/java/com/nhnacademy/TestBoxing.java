package com.nhnacademy;

import static org.junit.Assert.assertEquals;

import java.awt.Rectangle;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class TestBoxing {
    @ParameterizedTest
    @MethodSource("testConstructorProvider")
    void testBoxing(int x, int y, int width, int height) {
        Point location = new Point(x, y);
        Box box = new Box(location, width, height);
        Rectangle region = new Rectangle(x - width / 2, y - height / 2, width, height);

        assertEquals(location, box.getLocation());
        assertEquals(width, box.getWidth());
        assertEquals(height, box.getHeight());
        assertEquals(region, box.getRegion());
    }

    static Stream<Arguments> testConstructorProvider() {
        return Stream.of(
                Arguments.arguments(100, 100, 50, 20),
                Arguments.arguments(0, 0, 100, 100),
                Arguments.arguments(0, 0, 100, 99));
    }
}