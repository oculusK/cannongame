package com.nhnacademy;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class TestWorld {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        World world = new World();
        world.setSize(400, 300);

        frame.add(world);

        Ball ball = new Ball(100, 100, 50);
        PaintableBall paintableBall = new PaintableBall(200, 200, 50, Color.BLUE);
        MovableBall movableBall = new MovableBall(150, 150, 50);

        world.add(ball);
        world.add(paintableBall);
        world.add(movableBall);

        frame.setEnabled(true);
        frame.setVisible(true);

    }
}
