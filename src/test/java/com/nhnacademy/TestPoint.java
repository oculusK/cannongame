package com.nhnacademy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class TestPoint {
    @Test
    void testConstructor() {
        int x = 10;
        int y = 20;

        assertDoesNotThrow(() -> {
            Point point = new Point(x, y);

            assertEquals(x, point.getX());
            assertEquals(y, point.getY());
        });

    }

    @Test
    void testCopyConstructor() {
        Point base = new Point(10, 20);
        assertDoesNotThrow(() -> {
            Point point = new Point(base);

            assertEquals(base, point);
        });
    }

    @Test
    void testEquals() {
        int x = 10;
        int y = 20;
        Point point1 = new Point(x, y);
        Point point2 = new Point(x, y);
        Point point3 = new Point(x, x);

        assertEquals(point1, point2);
        assertNotEquals(point1, point3);
    }
}
