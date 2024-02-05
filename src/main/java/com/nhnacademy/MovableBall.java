package com.nhnacademy;

import java.awt.Color;

public class MovableBall extends PaintableBall {
    // public static final int DEFALUT_DX = 0;
    // public static final int DEFALUT_DY = 0;
    // int dx = DEFALUT_DX;
    // int dy = DEFALUT_DY;

    Motion motion = new Motion(getDX(), getDY());

    public MovableBall(Point location, int radius) {
        super(location, radius);
    }

    public MovableBall(Point location, int radius, Color color) {
        super(location, radius, color);
    }

    public int getDX() {
        return motion.dx;
    }

    public int getDY() {
        return motion.dy;
    }

    public void setDX(int dx) {
        motion.dx = dx;
    }

    public void setDY(int dy) {
        motion.dy = dy;
    }

    public void move() {
        Point newLocation = new Point(getLocation());
        newLocation.translate(getDX(), getDY());

        setLocation(newLocation);
    }

    public void moveTo(Point location) {
        setLocation(location);
    }
}
