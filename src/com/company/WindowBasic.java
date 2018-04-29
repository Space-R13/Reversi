package com.company;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.AttributedCharacterIterator;

public class WindowBasic extends JFrame{
    private GridBagConstraints constraints;
    private JPanel panel;
    private JButton res;
    private JButton clo;
    private JTextField player, score;
    private int rows = 0, cols = 0;
    private final int playerBlack = 0, playerWhite = 1;
    private JButton[][] buttonG;
    private boolean round = true;
  //  private int whiteP, blackP;
   // private int [][] number;
    private File fileBlack = new File(System.getProperty("user.dir") + "/src/com/company/jpg/Black.jpg");
    private Image imageBlack = ImageIO.read(fileBlack);
    private File fileWhite = new File(System.getProperty("user.dir") + "/src/com/company/jpg/White.jpg");
    private Image imageWhite = ImageIO.read(fileWhite);
    private Icon white = new ImageIcon(imageWhite);
    private File fileGreen = new File(System.getProperty("user.dir") + "/src/com/company/jpg/1.jpg");
    private Image imageGreen = ImageIO.read(fileGreen);
    private Icon green = new ImageIcon(imageGreen);
    private Icon black = new ImageIcon(imageBlack);
    private Timer timeRound;
    private Color color = new Color(230,191,0);


    WindowBasic() throws IOException {

        JFrame frame = new JFrame("Reverse");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        winBas(frame.getContentPane());
        frame.setSize(300,360);
        frame.setResizable(false);
      //  frame.pack();
        frame.setVisible(true);
   //     plateStep();

    }

    private void winBas(Container container){
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        container.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        //  constraints.weightx = 0.5;
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
        score.setText("Time");
        panel.add(score);
        constraints.gridx = 1;
        constraints.gridy = 0;
        container.add(score, constraints);

        player = new JTextField(5);
        player.setEnabled(false);
        player.setText("Players");
        panel.add(player);
        constraints.gridx = 2;
        constraints.gridy = 0;
        container.add(player, constraints);

        clo = new JButton("Close");
        panel.add(clo);
        constraints.gridx = 3;
        constraints.gridy = 0;
        container.add(clo, constraints);

        buttonG = new JButton[8][8];
       // number = new int[8][8];
        panel = new JPanel(new GridLayout(8, 8));
        panel.setPreferredSize(new Dimension(270, 270));
        for (rows = 0; rows < 8; rows++) {
            for (cols = 0; cols < 8; cols++) {
                buttonG[rows][cols] = new Knopka(rows, cols);
          //      buttonG[rows][cols].addActionListener(new PositionAwareActionListener(rows, cols));
                buttonG[rows][cols].setBackground(color);
                buttonG[rows][cols].setEnabled(false);
                panel.add(buttonG[rows][cols]);

            }
        }
        constraints.weightx = 0.0;
        constraints.gridwidth = 4;
        constraints.gridx = 0;    // нулевая ячейка по горизонтали
        constraints.gridy = 1;    // первая ячейка по вертикали
        container.add(panel, constraints);
        buttonG[3][3].setIcon(white);
        buttonG[3][3].setEnabled(true);
        buttonG[3][4].setIcon(black);
        buttonG[3][4].setEnabled(true);
        buttonG[4][3].setIcon(black);
        buttonG[4][3].setEnabled(true);
        buttonG[4][4].setIcon(white);
        buttonG[4][4].setEnabled(true);
        buttonG[3][2].setIcon(green);
        buttonG[3][2].setEnabled(true);
        buttonG[2][3].setIcon(green);
        buttonG[2][3].setEnabled(true);
        buttonG[5][4].setIcon(green);
        buttonG[5][4].setEnabled(true);
        buttonG[4][5].setIcon(green);
        buttonG[4][5].setEnabled(true);


    }


/*
    private void plateStep(){
        // Нужно вписать метод определения возможных ходов, метода два, для чёрных и для белых
        if (round) {
            player.setText("Black");
            step(round);
            round = false;

        } else {
            player.setText("White");
            step(round);
            round = true;
        }
    }

     private void step(boolean round) {
        if (round) {
         for (rows = 2; rows < 6; rows++) {
             for (cols = 2; cols < 6; cols++) {
                 if (buttonG[rows][cols].getIcon() == black) {

                     //сдвиг вверх по строкам
                     if (buttonG[rows - 1][cols].getIcon() == white) {

                             buttonG[rows - 2][cols].setEnabled(true);
                             buttonG[rows - 2][cols].setIcon(green);

                     }

                     if (buttonG[rows + 1][cols].getIcon() == white) {
                         buttonG[rows + 2][cols].setEnabled(true);
                         buttonG[rows + 2][cols].setIcon(green);
                     }

                     if (buttonG[rows][cols - 1].getIcon() == white) {
                         buttonG[rows][cols - 2].setEnabled(true);
                         buttonG[rows][cols - 2].setIcon(green);
                     }

                     if (buttonG[rows][cols + 1].getIcon() == white) {
                         buttonG[rows][cols + 2].setEnabled(true);
                         buttonG[rows][cols + 2].setIcon(green);
                     }

                     if (buttonG[rows - 1][cols - 1].getIcon() == white) {
                         buttonG[rows - 2][cols - 2].setEnabled(true);
                         buttonG[rows - 2][cols - 2].setIcon(green);
                     }

                     if (buttonG[rows + 1][cols + 1].getIcon() == white) {
                         buttonG[rows + 2][cols + 2].setEnabled(true);
                         buttonG[rows + 2][cols + 2].setIcon(green);
                     }

                     if (buttonG[rows - 1][cols + 1].getIcon() == white) {
                         buttonG[rows - 2][cols + 2].setEnabled(true);
                         buttonG[rows - 2][cols + 2].setIcon(green);
                     }

                     if (buttonG[rows + 1][cols - 1].getIcon() == white) {
                         buttonG[rows + 2][cols - 2].setEnabled(true);
                         buttonG[rows + 2][cols - 2].setIcon(green);
                     }


                 }
           /*       //сдвиг вниз по строкам


                     else if (buttonG[rows + 1][cols] == black) {
                         buttonG[rows + 2][cols].setEnabled(true);
                         buttonG[rows + 2][cols].setText("+");
                     }

                     else

                 //сдвиг влево по столбцам


                     else if (buttonG[rows][cols - 1] == black) {
                         buttonG[rows][cols - 2].setEnabled(true);
                         buttonG[rows][cols - 2].setText("+");
                     }

                     else ;

                 //сдвиг вправо по столбцам


                     else if (buttonG[rows][cols + 1] == black) {
                         buttonG[rows][cols + 2].setEnabled(true);
                         buttonG[rows][cols + 2].setText("+");
                     }

                     else ;




                     else if (buttonG[rows - 1][cols - 1] == black) {
                         buttonG[rows - 2][cols - 2].setEnabled(true);
                         buttonG[rows - 2][cols - 2].setText("+");
                     }

                     else ;




                     else if (buttonG[rows + 1][cols + 1] == black) {
                         buttonG[rows + 2][cols + 2].setEnabled(true);
                         buttonG[rows + 2][cols + 2].setText("+");
                     }
                     else ;



                     else if (buttonG[rows - 1][cols + 1] == black) {
                         buttonG[rows - 2][cols + 2].setEnabled(true);
                         buttonG[rows - 2][cols + 2].setText("+");
                     }
                     else ;




                     else if (buttonG[rows + 1][cols - 1] == black) {
                         buttonG[rows + 2][cols - 2].setEnabled(true);
                         buttonG[rows + 2][cols - 2].setText("+");
                     }
                     else ;
                }
             }
         }
    }*/
}
