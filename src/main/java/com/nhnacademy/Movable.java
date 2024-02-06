package com.nhnacademy;

public interface Movable extends Regionable {
    public void setMotion(Motion motion);

    public Motion getMotion();

    public void move();

    public void moveTo(Point location);
}
