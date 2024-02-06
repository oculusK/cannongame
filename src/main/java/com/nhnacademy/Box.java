package com.nhnacademy;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Box implements Regionable {
    String id = UUID.randomUUID().toString();
    String name = id;
    Region region;
    Logger logger;

    public Box(Point location, int width, int height) {

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

    public Point getLocation() {
        return region.getLocation();
    }

    public int getWidth() {
        return region.getWidth();
    }

    public int getHeight() {
        return region.getHeight();
    }

    public int getMinX() {
        return region.getMinX();
    }

    public int getMaxX() {
        return region.getMaxX();
    }

    public int getMinY() {
        return region.getMinY();
    }

    public int getMaxY() {
        return region.getMaxY();
    }

    public void move(Motion motion) {
        region.move(motion);
    }

    public void moveTo(Point loaction) {
        region.moveTo(loaction);
    }

    public boolean intersects(Regionable other) {
        return region.intersects(other);
    }

    public Regionable intersection(Regionable other) {
        return region.intersection(other);
    }

    public boolean isCollision(Region other) {
        return intersects(other);
    }

    public Logger getLogger() {
        return logger;
    }
}