package com.nhnacademy;

import java.awt.*;
import javax.swing.*;

public class GraphicEx {
    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        // 제목 설정
        frame.setTitle("GridBagLayout");
        //// 크기 설정
        frame.setSize(400, 130);
        //
        frame.setLayout(new GridBagLayout());

        JButton button = new JButton("Button 1");
        constraints.gridx = 0;
        constraints.gridy = 0;
        frame.add(button, constraints);

        button = new JButton("Button 2");
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 0;
        frame.add(button, constraints);

        button = new JButton("Button 3");
        constraints.weightx = 0.5;
        constraints.gridx = 2;
        constraints.gridy = 0;
        frame.add(button, constraints);

        button = new JButton("Button 4");
        constraints.weightx = 0.5;
        constraints.gridx = 3;
        constraints.gridy = 0;
        frame.add(button, constraints);

        button = new JButton("Button 5");
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridwidth = 2;
        constraints.gridy = 1;
        constraints.ipady = 40;
        frame.add(button, constraints);

        frame.setVisible(true);
    }
}
