package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class World extends JPanel {
    List<Ball> ballList = new LinkedList<>();
    List<Box> boxList = new LinkedList<>();
    Logger logger = LogManager.getLogger();

    public World() {
        super();
    }

    public void add(Ball newBall) {
        if (newBall == null) {
            throw new IllegalArgumentException();
        }

        for (Ball ball : ballList) {
            if (newBall.isCollision(ball)) {
                throw new IllegalArgumentException();
            }
        }

        if ((newBall.getRegion().getMinX() < 0)
                || (getWidth() < newBall.getRegion().getMaxX())
                || (newBall.getRegion().getMinY() < 0)
                || (getHeight() < newBall.getRegion().getMaxY())) {
            throw new IllegalArgumentException("추가하려는 newBall이 world를 벗어납니다.");
        }

        ballList.add(newBall);
        if (newBall instanceof PaintableBall) {
            logger.trace(String.format("newBall 추가 : %s, %4d, %s",
                    ((PaintableBall) newBall).getLocation().toString(),
                    ((PaintableBall) newBall).getRadius(),
                    ((PaintableBall) newBall).getColor().toString()));
        }
    }

    public void add(Box newBox) {
        if (newBox == null) {
            throw new IllegalArgumentException();
        }

        for (Box box : boxList) {
            if (newBox.isCollision(box)) {
                throw new IllegalArgumentException();
            }
        }
        if ((newBox.getRegion().getMinX() < 0)
                || (getWidth() < newBox.getRegion().getMaxX())
                || (newBox.getRegion().getMinY() < 0)
                || (getHeight() < newBox.getRegion().getMaxY())) {
            throw new IllegalArgumentException("추가하려는 newBox가 world를 벗어납니다.");
        }

        boxList.add(newBox);
        if (newBox instanceof PaintableBox) {
            logger.trace(String.format("newbox 추가 : %s, %d, %d, %s",
                    ((PaintableBox) newBox).getLocation().toString(),
                    ((PaintableBox) newBox).getWidth(),
                    ((PaintableBox) newBox).getHeight(),
                    ((PaintableBox) newBox).getColor().toString()));
        }
    }

    public void remove(Ball ball) {
        if (ball == null) {
            throw new IllegalArgumentException();
        }

        ballList.remove(ball);
    }

    public void remove(Box box) {
        if (box == null) {
            throw new IllegalArgumentException();
        }

        boxList.remove(box);
    }

    public void removeBall(int index) {
        ballList.remove(index);
    }

    public void removeBox(int index) {
        boxList.remove(index);
    }

    public Box getBox(int index) {
        return boxList.get(index);
    }

    public Ball getBall(int index) {
        return ballList.get(index);
    }

    public int getCountBall() {
        return ballList.size();
    }

    public int getCountBox() {
        return ballList.size();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Ball ball : ballList) {
            if (ball instanceof PaintableBall) {
                ((PaintableBall) ball).paint(g);
            }
        }

        for (Box box : boxList) {
            if (box instanceof PaintableBox) {
                ((PaintableBox) box).paint(g);
            }
        }

        Color previousColor = g.getColor();
        g.setColor(Color.RED);
        // for (int i = 0; i < getCount(); i++) {
        // Ball ball1 = get(i);
        // for (int j = i + 1; j < getCount(); j++) {
        // Ball ball2 = get(j);

        // if (ball1.isCollision(ball2)) {
        // Rectangle collisionArea = ball1.getRegion().intersection(ball2.getRegion());

        // g.drawRect((int) collisionArea.getX(), (int) collisionArea.getY(),
        // (int) collisionArea.getWidth(), (int) collisionArea.getHeight());
        // }
        // }
        // }
        g.setColor(previousColor);
    }
}