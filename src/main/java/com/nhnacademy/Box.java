package com.nhnacademy;

import java.awt.Rectangle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Box {
    Rectangle region;
    Point location;
    Logger logger;

    public Box(Point location, int radius) {
        if ((radius <= 0)
                || ((location.getX() >= 0) && ((Integer.MAX_VALUE - location.getX()) < radius))
                || ((location.getX() < 0) && ((location.getX() - Integer.MIN_VALUE) < radius))
                || ((location.getY() >= 0) && ((Integer.MAX_VALUE - location.getY()) < radius))
                || ((location.getY() < 0) && ((location.getY() - Integer.MIN_VALUE) < radius))) {
            throw new IllegalArgumentException();
        }

        region = new Rectangle(location.getX(), location.getY(), getWidth(), getHeight());
        this.logger = LogManager.getLogger(this.getClass());
    }

    Point getLocation() {
        return new Point(((int) region.getCenterX()), ((int) region.getCenterY()));
    }

    public int getWidth() {
        return (int) region.getWidth();
    }

    public int getHeight() {
        return (int) region;
    }

    Rectangle getRegion() {
        return new Rectangle();
    }
}
