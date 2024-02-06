package com.nhnacademy;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ball extends Region {
    String id = UUID.randomUUID().toString();
    String name = id;
    Region region;
    Logger logger;

    public Ball(Point location, int radius) {
        super(location, 2 * radius, 2 * radius);
        if ((radius <= 0)
                || ((location.getX() - radius) > location.getX())
                || ((location.getX() + radius) < location.getX())
                || ((location.getY() - radius) > location.getY())
                || ((location.getY() + radius) < location.getY())) {
            throw new IllegalArgumentException();
        }

        region = new Region(location, radius * 2, radius * 2);
        this.logger = LogManager.getLogger(this.getClass());
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Point getLocation() {
        return region.getLocation();
    }

    void setLocation(Point location) {
        region.moveTo(location);
    }

    public int getRadius() {
        return (region.getWidth() / 2);
    }

    public Region getRegion() {
        return region;
    }

    public boolean isCollision(Ball other) {
        return region.intersects(other.getRegion());
    }

    public boolean isCollision(Box other) {
        return region.intersects(other.getRegion());
    }

    public Logger getLogger() {
        return logger;
    }
}