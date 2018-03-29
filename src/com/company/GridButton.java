package com.company;

import javax.swing.*;
import java.awt.*;

public class GridButton{

    public GridButton(int x, int y){
        JButton[][] buttonG = new JButton[x][y];
        for ( x = 0; x < 8; x++ ) {
            for ( y = 0; y < 8; y++) {
                buttonG[x][y] = new JButton();
            }
        }
    }
}
