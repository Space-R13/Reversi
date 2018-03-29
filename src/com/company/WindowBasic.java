package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WindowBasic extends Frame{


    public WindowBasic() {

        JFrame frame = new JFrame("Reverse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        winBas(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        frame.setSize(300,310);
        frame.setResizable(false);
    }

    private void winBas(Container container) {
        int x, y;
        JPanel panel;
        JButton res;
        JButton clo;
        JTextField player, score;
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
    //    constraints.weightx = 0.5;
        constraints.gridy = 0;
        constraints.gridx = 0;

        panel = new JPanel();
        res = new JButton("Reset");
        panel.add(res);
        constraints.gridx = 0;
        constraints.gridy = 0;
        container.add(panel, constraints);

        score = new JTextField(5);
        score.setEnabled(false);
        panel.add(score);
        constraints.gridx = 1;
        constraints.gridy = 0;
        container.add(score, constraints);

        player = new JTextField(5);
        player.setEnabled(false);
        panel.add(player);
        constraints.gridx = 2;
        constraints.gridy = 0;
        container.add(player, constraints);

        clo = new JButton("Close");
        panel.add(clo);
        constraints.gridx = 3;
        constraints.gridy = 0;
        container.add(clo, constraints);

        JButton[][] buttonG = new JButton[8][8];
        panel = new JPanel(new GridLayout(8,8));
        for (x = 0; x < 8; x++) {
            for (y = 0; y < 8; y++) {
                buttonG[x][y] = new JButton();
                buttonG[x][y].addActionListener(new PositionAwareActionListener(x, y));
                panel.add(buttonG[x][y]);
            }
        }
        constraints.weightx = 0.0;
        constraints.gridwidth = 4;
        constraints.gridx = 0;    // нулевая ячейка по горизонтали
        constraints.gridy = 1;    // первая ячейка по вертикали
        container.add(panel, constraints);
    }
}
