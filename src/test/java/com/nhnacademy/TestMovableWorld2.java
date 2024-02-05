package com.nhnacademy;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;

public class TestMovableWorld2 {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();

        frame.setSize(400, 300);

        MovableWorld world = new MovableWorld();
        world.setSize(400, 300);
        frame.add(world);

        Random random = new Random();
        for (int i = 0; i < 1; i++) {
            int radius = 1 + random.nextInt(50);
            int x = radius + random.nextInt(400 - 2 * radius);
            int y = radius + random.nextInt(300 - 2 * radius);

            BoundedBall boundedBall = new BoundedBall(new Point(x, y), radius, Color.GREEN);
            boundedBall.setDX(10);
            boundedBall.setDY(5);
            world.add(boundedBall);
        }

        world.setMaxMoveCount(0);
        world.setDT(100);

        frame.setEnabled(true);
        frame.setVisible(true);

        world.run();
    }
}