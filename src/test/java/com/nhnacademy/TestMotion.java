package com.nhnacademy;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestMotion {
    @ParameterizedTest
    @MethodSource("createPositionProvider")
    void testCreatePosition(int dx, int dy) {
        Motion motion = Motion.createPosition(dx, dy);

        assertEquals(dx, motion.getDX());
        assertEquals(dy, motion.getDY());
    }

    static Stream<Arguments> createPositionProvider() {
        return Stream.of(
                Arguments.arguments(0, 0),
                Arguments.arguments(0, 10),
                Arguments.arguments(10, 0),
                Arguments.arguments(10, 10),
                Arguments.arguments(0, -10),
                Arguments.arguments(-10, 0),
                Arguments.arguments(-10, -10));
    }

    @ParameterizedTest
    @MethodSource("addPositionProvider")
    void testAddPosition(int dx1, int dy1, int dx2, int dy2, int targetX, int targetY) {
        Motion motion1 = Motion.createPosition(dx1, dy1);
        Motion motion2 = Motion.createPosition(dx2, dy2);

        Motion targetMotion = Motion.createPosition(targetX, targetY);

        motion1.add(motion2);

        assertEquals(motion1, targetMotion);
    }

    static Stream<Arguments> addPositionProvider() {
        return Stream.of(
                Arguments.arguments(0, 0, 10, 10, 10, 10),
                Arguments.arguments(-10, 0, 10, 10, 0, 10),
                Arguments.arguments(0, 0, -10, -10, -10, -10));
    }
}
