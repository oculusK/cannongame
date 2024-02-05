package com.nhnacademy;

import java.awt.Color;

public class MovableBox extends PaintableBox {
    Motion motion = new Motion(getDX(), getDY());

    public MovableBox(Point location, int width, int height) {
        super(location, width, height);
    }

    public MovableBox(Point location, int width, int height, Color color) {
        super(location, width, height, color);
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
