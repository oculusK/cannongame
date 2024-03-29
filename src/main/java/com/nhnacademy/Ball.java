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

        this.logger = LogManager.getLogger(this.getClass());
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

    public int getRadius() {
        return (getWidth() / 2);
    }

    public boolean isCollision(Region other) {
        return intersects(other);
    }

    public Logger getLogger() {
        return logger;
    }
}