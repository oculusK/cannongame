package com.nhnacademy;

public class Motion {
    int dx = 0;
    int dy = 0;

    Motion(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public static Motion createPosition(int dx, int dy) {
        return new Motion(dx, dy);
    }

    public static Motion createDisplacement(int angle, int magnitude) {
        int dx = (int) (magnitude * Math.cos(Math.toRadians(angle)));
        int dy = (int) (magnitude * Math.sin(Math.toRadians(angle)));
        return new Motion(dx, dy);
    }

    public void add(Motion other) {
        setDX(getDX() + other.getDX());
        setDY(getDY() + other.getDY());
    }

    public void sub(Motion other) {
        setDX(getDX() - other.getDX());
        setDY(getDY() - other.getDY());
    }

    public int getDX() {
        return dx;
    }

    void setDX(int dx) {
        this.dx = dx;
    }

    public int getDY() {
        return dy;
    }

    void setDY(int dy) {
        this.dy = dy;
    }

    public int getAngle() {
        return (int) Math.toDegrees(Math.atan2(dy, dx));
    }

    public int getMagnitude() {
        return (int) Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    public void turnDX() {
        dx = -dx;
    }

    public void turnDY() {
        dy = -dy;
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Motion) && getDX() == ((Motion) other).getDX() && getDY() == ((Motion) other).getDY();
    }
}
