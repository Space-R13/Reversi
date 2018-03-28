package com.company;

import javax.swing.*;
import java.awt.*;

public class GridButton extends GridLayout {
    GridButton(int x, int y){
        for (x = 0; x < 8; x++ ){
            for (y = 0; y < 8; y++){
                JButton[][] buttonG = new JButton[x][y];
            }

        }

    }

}
