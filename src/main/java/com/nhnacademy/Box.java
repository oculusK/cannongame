package com.nhnacademy;

import java.awt.Rectangle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Box {
    Rectangle region;
    Logger logger;

    public Box(Point location, int width, int height) {
        if ((width <= 0 || height <= 0)
                || ((location.getX() >= 0) && ((Integer.MAX_VALUE - location.getX()) < width))
                || ((location.getX() < 0) && ((location.getX() - Integer.MIN_VALUE) < width))
                || ((location.getY() >= 0) && ((Integer.MAX_VALUE - location.getY()) < height))
                || ((location.getY() < 0) && ((location.getY() - Integer.MIN_VALUE) < height))) {
            throw new IllegalArgumentException();
        }

        region = new Rectangle(location.getX() - width / 2, location.getY() - height / 2, width, height);
        this.logger = LogManager.getLogger(this.getClass());
    }

    Point getLocation() {
        return new Point(((int) getRegion().getCenterX()), ((int) getRegion().getCenterY()));
    }

    public int getWidth() {
        return (int) getRegion().getWidth();
    }

    public int getHeight() {
        return (int) getRegion().getHeight();
    }

    Rectangle getRegion() {
        return region;
    }

    public boolean isCollision(Box other) {
        return getRegion().intersects(other.getRegion());
    }

    public boolean isCollision(Ball ball) {
        return getRegion().intersects(ball.getRegion());
    }
}