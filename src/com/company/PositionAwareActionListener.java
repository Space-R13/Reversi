package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PositionAwareActionListener implements ActionListener{
    private int x;
    private int y;

    public PositionAwareActionListener(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //callYourFunction(x, y);
        /**
         * При нажатии на кнопку, массиву с координатами данной кнопки, присваилась картинка
         */
    }
}
