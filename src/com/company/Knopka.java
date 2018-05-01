package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Knopka extends JButton{
    private int xx;
    private int yy;

    public Knopka( int x, int y){
        this.xx = x;
        this.yy = y;
    }

    public int getXx() {
        return xx;
    }

    public int getYy() {
        return yy;
    }
}
