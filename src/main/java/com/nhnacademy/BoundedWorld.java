package com.nhnacademy;

public class BoundedWorld extends MovableWorld {
    public boolean outOfBounds(Regionable region) {
        return (region.getMinX() < getBounds().getMinX())
                || (region.getMaxX() > getBounds().getMaxX())
                || (region.getMinY() < getBounds().getMinY())
                || (region.getMaxY() > getBounds().getMaxY());
    }

    public void bounce(Movable object) {
        if ((object.getMinX() < getBounds().getMinX()) ||
                (object.getMaxX() > getBounds().getMaxX())) {
            object.getMotion().turnDX();
        }

        if ((object.getMinY() < getBounds().getMinY()) ||
                (object.getMaxY() > getBounds().getMaxY())) {
            object.getMotion().turnDY();
        }
    }

    @Override
    public void move() {
        for (int i = 0; i < getCount(); i++) {
            if (get(i) instanceof Movable) {
                Movable ball1 = (Movable) get(i);

                ball1.move();

                if (outOfBounds(ball1)) {
                    bounce(ball1);
                }

                for (int j = 0; j < getCount(); j++) {
                    if ((get(j) instanceof Movable) && (ball1 != get(j))) {
                        Regionable ball2 = get(j);

                        if (ball1.intersects(ball2)) {
                            Regionable intersection = ball1.intersection(ball2);

                            if ((intersection.getWidth() != ball1.getWidth()) &&
                                    (intersection.getWidth() != ball2.getWidth())) {
                                ball1.getMotion().turnDX();
                            }

                            if ((intersection.getHeight() != ball1.getHeight()) &&
                                    (intersection.getHeight() != ball2.getHeight())) {
                                ball1.getMotion().turnDY();
                            }
                        }
                    }
                }

                for (int j = 0; j < getCount(); j++) {
                    if (get(j) instanceof Regionable) {
                        Regionable box = get(j);

                        if (ball1.intersects(box)) {
                            Regionable intersection = ball1.intersection(box);

                            if ((intersection.getWidth() != ball1.getWidth()) &&
                                    (intersection.getWidth() != box.getWidth())) {
                                ball1.getMotion().turnDX();
                            }

                            if ((intersection.getHeight() != ball1.getHeight()) &&
                                    (intersection.getHeight() != box.getHeight())) {
                                ball1.getMotion().turnDY();
                            }
                        }
                    }
                }

            }
        }
        repaint();
    }
}