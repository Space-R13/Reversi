package com.company;

import javax.swing.*;

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
