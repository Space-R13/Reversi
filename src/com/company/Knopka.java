package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Knopka extends JButton implements ActionListener{
    private int x;
    private int y;

    public Knopka(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //callYourFunction(x, y);
        String command = e.getActionCommand();
        System.out.println(command);

        /**
         * При нажатии на кнопку, массиву с координатами данной кнопки, присваилась картинка
         */
    }


}
