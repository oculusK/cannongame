package com.nhnacademy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GraphicEx {
    static int operand1 = 0;
    static int operand2 = 0;
    static String operate = "";

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        // 제목 설정
        frame.setTitle("Calculator");
        //// 크기 설정
        frame.setSize(400, 300);
        //
        frame.setLayout(new GridBagLayout());

        final JTextField text = new JTextField();
        text.setHorizontalAlignment(SwingConstants.RIGHT);
        text.setText("0");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 4;
        frame.add(text, constraints);

        ActionListener inputNumberActionListener = e -> {
            if (e.getSource() instanceof JButton) {
                if (text.getText().equals("0")) {
                    text.setText((JButton) e.getSource().getText());
                } else {
                    text.setText(text.getText() + ((JButton) e.getSource()).getText());
                }
            }
        };

        ActionListener operatorActionListner = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {
                    switch (((JButton) e.getSource()).getText()) {
                        case "+": {
                            operand1 = Integer.valueOf(text.getText());
                            operator = ((JButton) e.getSource()).getText();
                            text.setText("0");
                        }

                        case "-": {

                        }
                        case "*": {

                        }
                        case "/": {

                        }
                        case "=": {
                            operand2 = Integer.valueOf(text.getText());
                            operator = setText();
                        }
                            break;
                    }
                }
            }
        };

        JButton button = new JButton("7");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;

        frame.add(button, constraints);

        button = new JButton("8");
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 1;
        frame.add(button, constraints);

        button = new JButton("9");
        constraints.weightx = 0.5;
        constraints.gridx = 2;
        constraints.gridy = 1;
        frame.add(button, constraints);

        button = new JButton("4");
        constraints.weightx = 0.5;
        constraints.gridx = 0;
        constraints.gridy = 2;
        frame.add(button, constraints);

        button = new JButton("5");
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 2;
        frame.add(button, constraints);

        button = new JButton("6");
        constraints.weightx = 0.5;
        constraints.gridx = 2;
        constraints.gridy = 2;
        frame.add(button, constraints);

        button = new JButton("1");
        constraints.weightx = 0.5;
        constraints.gridx = 0;
        constraints.gridy = 3;
        frame.add(button, constraints);

        button = new JButton("2");
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridy = 3;
        frame.add(button, constraints);

        button = new JButton("3");
        constraints.weightx = 0.5;
        constraints.gridx = 2;
        constraints.gridy = 3;
        frame.add(button, constraints);

        button = new JButton("0");
        constraints.weightx = 0.5;
        constraints.gridx = 0;
        constraints.gridy = 4;
        frame.add(button, constraints);

        button = new JButton("+");
        constraints.weightx = 0.5;
        constraints.gridx = 3;
        constraints.gridy = 1;
        frame.add(button, constraints);

        button = new JButton("-");
        constraints.weightx = 0.5;
        constraints.gridx = 3;
        constraints.gridy = 2;
        frame.add(button, constraints);

        button = new JButton("*");
        constraints.weightx = 0.5;
        constraints.gridx = 3;
        constraints.gridy = 3;
        frame.add(button, constraints);

        button = new JButton("/");
        constraints.weightx = 0.5;
        constraints.gridx = 3;
        constraints.gridy = 4;
        frame.add(button, constraints);

        button = new JButton("=");
        constraints.weightx = 0.5;
        constraints.gridx = 1;
        constraints.gridwidth = 2;
        constraints.gridy = 5;
        frame.add(button, constraints);

        button = new JButton("AC");
        constraints.weightx = 0.5;
        constraints.gridx = 3;
        constraints.gridy = 5;
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if ((e.getSource() instanceof JButton)
                        && (((JButton) e.getSource()).getText().equals("AC"))) {
                    text.setText("0");
                }
            }
        });
        frame.add(button, constraints);

        frame.setVisible(true);
    }
}
