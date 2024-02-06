package com.nhnacademy;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class TestWorld {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        World world = new World();
        world.setSize(500, 400);

        frame.add(world);

        Ball ball = new PaintableBall(new Point(100, 100), 50, Color.RED);

        Box box = new PaintableBox(new Point(200, 100), 100, 100, Color.BLUE);

        world.add(ball);
        world.add(box);

        frame.setEnabled(true);
        frame.setVisible(true);

    }
}
