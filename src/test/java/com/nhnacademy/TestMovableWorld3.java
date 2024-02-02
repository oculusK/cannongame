package com.nhnacademy;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestMovableWorld3 {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();

        Logger logger = LogManager.getLogger();

        frame.setSize(400, 300);

        BoundedWorld world = new BoundedWorld();
        world.setSize(400, 300);
        frame.add(world);

        Random random = new Random();
        while (world.getCount() < 10) {
            int radius = 1 + random.nextInt(50);
            int x = radius + random.nextInt(400 - 2 * radius);
            int y = radius + random.nextInt(300 - 2 * radius);

            MovableBall movableBall = new MovableBall(x, y, radius, Color.GREEN);
            movableBall.setDX(10);
            movableBall.setDY(5);
            try {
                world.add(movableBall);
            } catch (IllegalArgumentException e) {
                logger.error("등록하려는 볼이 충돌 합니다.");
            }
        }

        while (world.getCount() < 11) {
            int radius = 1 + random.nextInt(50);
            int x = radius + random.nextInt(400 - 2 * radius);
            int y = radius + random.nextInt(300 - 2 * radius);

            PaintableBall movableBall = new PaintableBall(x, y, radius, Color.GREEN);
            try {
                world.add(movableBall);
            } catch (IllegalArgumentException e) {
                logger.error("등록하려는 볼이 충돌 합니다.");
            }
        }

        world.setMaxMoveCount(0);
        world.setDT(100);

        frame.setEnabled(true);
        frame.setVisible(true);

        world.run();
    }
}
