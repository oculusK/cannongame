package com.nhnacademy;

public interface Regionable {
    public Point getLocation();

    public int getWidth();

    public int getHeight();

    public int getMinX();

    public int getMaxX();

    public int getMinY();

    public int getMaxY();

    public void move(Motion motion);

    public void moveTo(Point loaction);

    public boolean intersects(Regionable other);

    public Regionable intersection(Regionable other);
}
