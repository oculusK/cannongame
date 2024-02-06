package com.nhnacademy;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Box extends Region {
    String id = UUID.randomUUID().toString();
    String name = id;
    Region region;
    Logger logger;

    public Box(Point location, int width, int height) {
        super(location, width, height);

        if ((width <= 0) || (height <= 0)
                || ((location.getX() - width / 2.0) > location.getX())
                || ((location.getX() + width / 2.0) < location.getX())
                || ((location.getY() - height / 2.0) > location.getY())
                || ((location.getY() + height / 2.0) < location.getY())) {
            throw new IllegalArgumentException();
        }

        region = new Region(location, width, height);
        logger = LogManager.getLogger(this.getClass());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
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

    @Override
    public int getWidth() {
        return region.getWidth();
    }

    @Override
    public int getHeight() {
        return region.getHeight();
    }

    public Region getRegion() {
        return region;
    }

    public boolean isCollision(Box other) {
        return region.intersects(other.getRegion());
    }

    public boolean isCollision(Ball other) {
        return region.intersects(other.getRegion());
    }

    public Logger getLogger() {
        return logger;
    }
}