package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowBasic extends Frame{


    public WindowBasic() {
   /**     JFrame windowB = new JFrame("Реверси");
        windowB.setSize(500,500);
        windowB.setVisible(true);
        windowB.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        windowB.setResizable(false);
        JButton[][] buttonG = new JButton[x][y];
        for ( x = 0; x < 8; x++ ) {
            for ( y = 0; y < 8; y++) {
                windowB.add(buttonG[x][y]);
            }
        }*/
        JFrame frame = new JFrame("Reverse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        winBas(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500,510);
        frame.setResizable(false);
    }

    public void winBas(Container container){
        int x , y;
        JButton button = new JButton();
        JTextField player, score;
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        //constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.weightx = 0;
        constraints.gridy = 0;



        button = new JButton("Reset");
        //constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.gridy = 0;
        container.add(button, constraints);

        score = new JTextField(3);
        //constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.gridx = 1;
       constraints.gridwidth = 2;
        constraints.gridy = 0;
        container.add(score, constraints);

        player = new JTextField(3);
      //  constraints.fill = GridBagConstraints.HORIZONTAL;
       constraints.fill = GridBagConstraints.VERTICAL;
        constraints.gridx = 2;
       constraints.gridwidth = 2;
        constraints.gridy = 0;
        container.add(player, constraints);

        button = new JButton("Close");
    //    constraints.fill = GridBagConstraints.HORIZONTAL;
      constraints.fill = GridBagConstraints.VERTICAL;
        constraints.gridx = 3;
        constraints.gridwidth = 2;
        constraints.gridy = 0;
        container.add(button, constraints);

        JButton[][] buttonG = new JButton[8][8];
        //constraints.weightx = 0;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.gridwidth = 1;
        constraints.gridx = 0;    // нулевая ячейка по горизонтали
        constraints.gridy = 1;    // первая ячейка по вертикали
        container.setLayout(new GridLayout(8,8));

        for ( x = 0; x < 8; x++ ) {
            for ( y = 0; y < 8; y++) {
                buttonG[x][y] = new JButton();
                buttonG[x][y].addActionListener(new PositionAwareActionListener(x, y));
                container.add(buttonG[x][y], constraints);
            }
        }





    }


}
