package com.nhnacademy;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;

public class TestMovableWorld {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();

        frame.setSize(400, 300);

        MovableWorld movableWorld = new MovableWorld();
        movableWorld.setSize(400, 300);

        frame.add(movableWorld);

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int radius = 1 + random.nextInt(50);
            int x = radius + random.nextInt(400 - 2 * radius);
            int y = radius + random.nextInt(300 - 2 * radius);

            MovableBall movableBall = new MovableBall(new Point(x, y), radius, Color.GREEN);
            movableBall.setDX(10);
            movableBall.setDY(5);
            movableWorld.add(movableBall);
        }

        movableWorld.setDT(1000);
        movableWorld.setMaxMoveCount(10);

        frame.setEnabled(true);
        frame.setVisible(true);

        movableWorld.run();
    }
}
