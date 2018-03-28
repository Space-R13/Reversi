package com.company;


import javax.swing.*;
import java.awt.*;

public class WindowBasic{


    public WindowBasic( int x, int y) {
        JFrame windowB = new JFrame("Реверси");
        windowB.setSize(500,500);
        windowB.setVisible(true);
        windowB.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        windowB.setResizable(false);
        JButton[][] buttonG = new JButton[x][y];
        for ( x = 0; x < 8; x++ ) {
            for ( y = 0; y < 8; y++) {
                windowB.add(buttonG[x][y]);
            }
        }
    }
}
