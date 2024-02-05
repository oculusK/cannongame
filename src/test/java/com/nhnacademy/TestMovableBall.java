package com.nhnacademy;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

class TestMovableBall {
    @Test
    void testConstructor() {
        MovableBall movableBall = new MovableBall(new Point(100, 100), 100);

        assertEquals(MovableBall.DEFALUT_DX, movableBall.getDX());
        assertEquals(MovableBall.DEFALUT_DY, movableBall.getDY());
    }

    @RepeatedTest(100)
    void testSetDelta(RepetitionInfo info) {
        MovableBall movableBall = new MovableBall(new Point(150, 150), 150);

        Random random = new Random();

        int dx = random.nextInt();
        int dy = random.nextInt();

        movableBall.setDX(dx);
        movableBall.setDY(dy);

        assertEquals(dx, movableBall.getDX());
        assertEquals(dy, movableBall.getDY());
    }

    @Test
    void testMove() {
        int x = 0;
        int y = 0;
        int radius = 10;
        int dx = 10;
        int dy = 20;

        MovableBall movableBall = new MovableBall(new Point(x, y), radius);
        movableBall.setDX(dx);
        movableBall.setDY(dy);

        assertDoesNotThrow(() -> {
            movableBall.move();

            assertEquals(x + dx, movableBall.getX());
            assertEquals(y + dy, movableBall.getY());
        });
    }
}
