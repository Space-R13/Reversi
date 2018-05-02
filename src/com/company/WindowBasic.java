package com.company;



import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class WindowBasic extends JFrame implements ActionListener{
    private GridBagConstraints constraints;
    private JPanel panel;
    private JButton res;
    private JButton clo;
    private JTextField players, score;

    private int rows = 0, cols = 0;
    private final int playerBlack = 0, playerWhite = 1;
    private JButton[][] buttonG;
    private boolean round = true, proverka = true;
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
    private File fileYellow = new File(System.getProperty("user.dir") + "/src/com/company/jpg/pusto.jpg");
    private Image imageYellow = ImageIO.read(fileYellow);
    private Icon yellow = new ImageIcon(imageYellow);
    private Icon black = new ImageIcon(imageBlack);
    private Timer timeRound;

    private Color color = new Color(230,191,0);


    WindowBasic() throws IOException {

        JFrame frame = new JFrame("Reverse");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        winBas(frame.getContentPane());
        frame.setSize(300,360);
        frame.setResizable(true);
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

        players = new JTextField(5);
        players.setEnabled(false);
        players.setText("Black");
        panel.add(players);
        constraints.gridx = 2;
        constraints.gridy = 0;
        container.add(players, constraints);

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
                buttonG[rows][cols].addActionListener(this);
                buttonG[rows][cols].setIcon(yellow);
       //         buttonG[rows][cols].setEnabled(false);
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
/*        buttonG[2][2].setIcon(green);
        buttonG[2][2].setEnabled(true);
        buttonG[2][5].setIcon(green);
        buttonG[2][5].setEnabled(true);
        buttonG[5][5].setIcon(green);
        buttonG[5][5].setEnabled(true);
        buttonG[5][2].setIcon(green);
        buttonG[5][2].setEnabled(true);
*/

    }


    private void step(int coorX, int coorY, boolean player, boolean proverka){
        boolean vozmozhenHod = false;
        int i, j, k;
        int[][] coorS = new int[7][2];
        for (int x = 0; x < 7; x++){
            coorS[x][0] = -1;
            coorS[x][1] = -1;
        }
        Icon icn1;
        Icon icn2;
        if (player ) {
            icn1 = black;
            icn2 = white;
        } else {
            icn1 = white;
            icn2 = black;
        }

        // Вверх
        if(coorX > 1){
            if (buttonG[coorX - 1][coorY].getIcon() == icn2){
                coorS[0][0] = coorX - 1;
                coorS[0][1] = coorY;
                i = coorX - 2;
                j = 1;
                while (i >= 0){
                    if (buttonG[i][coorY].getIcon() == icn2) {
                        coorS[j][0] = i;
                        coorS[j][1] = coorY;
                        i--;
                        j++;
                    } else if (buttonG[i][coorY].getIcon() == icn1) {
                        if (proverka && buttonG[coorX][coorY].getIcon() == yellow){
                            buttonG[coorX][coorY].setIcon(green);
                            buttonG[coorX][coorY].setEnabled(true);
                        }
                        coorS[j][0] = coorX;
                        coorS[j][1] = coorY;
                        vozmozhenHod = true;
                        break;
                    } else {
                        for (int x = 0; x < 7; x++){
                            coorS[x][0] = -1;
                            coorS[x][1] = -1;
                        }
                        break;
                    }
                }

            }
        }if (!proverka && vozmozhenHod) {
            update(coorS, player);
        }


        // Вниз
        if(coorX < 6){
            if (buttonG[coorX + 1][coorY].getIcon() == icn2){
                coorS[0][0] = coorX + 1;
                coorS[0][1] = coorY;
                i = coorX + 2;
                j = 1;
                while (i <= 7){
                    if (buttonG[i][coorY].getIcon() == icn2) {
                        coorS[j][0] = i;
                        coorS[j][1] = coorY;
                        i++;
                        j++;
                    } else if (buttonG[i][coorY].getIcon() == icn1) {
                        if (proverka && buttonG[coorX][coorY].getIcon() == yellow){
                            buttonG[coorX][coorY].setIcon(green);
                            buttonG[coorX][coorY].setEnabled(true);
                        }
                        coorS[j][0] = coorX;
                        coorS[j][1] = coorY;
                        vozmozhenHod = true;
                        break;
                    } else {
                        for (int x = 0; x < 7; x++){
                            coorS[x][0] = -1;
                            coorS[x][1] = -1;
                        }
                        break;
                    }
                }

            }
        } if (!proverka && vozmozhenHod) {
            update(coorS, player);

        }

        // влево
        if(coorY > 1){
            if (buttonG[coorX][coorY - 1].getIcon() == icn2){
                coorS[0][0] = coorX;
                coorS[0][1] = coorY - 1;
                i = coorY - 2;
                j = 1;
                while (i >= 0){
                    if (buttonG[coorX][i].getIcon() == icn2) {
                        coorS[j][0] = coorX;
                        coorS[j][1] = i;
                        i--;
                        j++;
                    } else if (buttonG[coorX][i].getIcon() == icn1) {
                        if (proverka && buttonG[coorX][coorY].getIcon() == yellow){
                            buttonG[coorX][coorY].setIcon(green);
                            buttonG[coorX][coorY].setEnabled(true);
                        }
                        coorS[j][0] = coorX;
                        coorS[j][1] = coorY;
                        vozmozhenHod = true;
                        break;
                    } else {
                        for (int x = 0; x < 7; x++){
                            coorS[x][0] = -1;
                            coorS[x][1] = -1;
                        }
                        break;
                    }
                }

            }
        } if (!proverka && vozmozhenHod) {
            update(coorS, player);
        }

        // право
        if(coorY < 6){
            if (buttonG[coorX][coorY + 1].getIcon() == icn2){
                coorS[0][0] = coorX;
                coorS[0][1] = coorY + 1;
                i = coorY + 2;
                j = 1;
                while (i <= 7){
                    if (buttonG[coorX][i].getIcon() == icn2) {
                        coorS[j][0] = coorX;
                        coorS[j][1] = i;
                        i++;
                        j++;
                    } else if (buttonG[coorX][i].getIcon() == icn1) {
                        if (proverka && buttonG[coorX][coorY].getIcon() == yellow){
                            buttonG[coorX][coorY].setIcon(green);
                            buttonG[coorX][coorY].setEnabled(true);
                        }
                        coorS[j][0] = coorX;
                        coorS[j][1] = coorY;
                        vozmozhenHod = true;
                        break;
                    } else {
                        for (int x = 0; x < 7; x++){
                            coorS[x][0] = -1;
                            coorS[x][1] = -1;
                        }
                        break;
                    }
                }

            }
        } if (!proverka && vozmozhenHod) {
            update(coorS, player);
        }

        // вверх влево
        if(coorX > 1 && coorY > 1){
            if (buttonG[coorX - 1][coorY - 1].getIcon() == icn2){
                coorS[0][0] = coorX - 1;
                coorS[0][1] = coorY - 1;
                i = coorX - 2;
                k = coorY - 2;
                j = 1;
                while (i >= 0 && k >= 0){
                    if (buttonG[i][k].getIcon() == icn2) {
                        coorS[j][0] = i;
                        coorS[j][1] = k;
                        i--;
                        k--;
                        j++;
                    } else if (buttonG[i][k].getIcon() == icn1) {
                        if (proverka && buttonG[coorX][coorY].getIcon() == yellow){
                            buttonG[coorX][coorY].setIcon(green);
                            buttonG[coorX][coorY].setEnabled(true);
                        }
                        coorS[j][0] = coorX;
                        coorS[j][1] = coorY;
                        vozmozhenHod = true;
                        break;
                    } else {
                        for (int x = 0; x < 7; x++){
                            coorS[x][0] = -1;
                            coorS[x][1] = -1;
                        }
                        break;
                    }
                }

            }
        } if (!proverka && vozmozhenHod) {
            update(coorS, player);
        }

        // вниз вправо
        if(coorX < 6 && coorY < 6){
            if (buttonG[coorX + 1][coorY + 1].getIcon() == icn2){
                coorS[0][0] = coorX + 1;
                coorS[0][1] = coorY + 1;
                i = coorX + 2;
                k = coorY + 2;
                j = 1;
                while (i <= 7 && k <= 7){
                    if (buttonG[i][k].getIcon() == icn2) {
                        coorS[j][0] = i;
                        coorS[j][1] = k;
                        i++;
                        k++;
                        j++;
                    } else if (buttonG[i][k].getIcon() == icn1) {
                        if (proverka && buttonG[coorX][coorY].getIcon() == yellow){
                            buttonG[coorX][coorY].setIcon(green);
                            buttonG[coorX][coorY].setEnabled(true);
                        }
                        coorS[j][0] = coorX;
                        coorS[j][1] = coorY;
                        vozmozhenHod = true;
                        break;
                    } else {
                        for (int x = 0; x < 7; x++){
                            coorS[x][0] = -1;
                            coorS[x][1] = -1;
                        }
                        break;
                    }
                }

            }
        } if (!proverka && vozmozhenHod) {
            update(coorS, player);
        }

        // вверх вправо
        if(coorX > 1 && coorY < 6){
            if (buttonG[coorX - 1][coorY + 1].getIcon() == icn2){
                coorS[0][0] = coorX - 1;
                coorS[0][1] = coorY + 1;
                i = coorX - 2;
                k = coorY + 2;
                j = 1;
                while (i >= 0 && k <= 7){
                    if (buttonG[i][k].getIcon() == icn2) {
                        coorS[j][0] = i;
                        coorS[j][1] = k;
                        i--;
                        k++;
                        j++;
                    } else if (buttonG[i][k].getIcon() == icn1) {
                        if (proverka && buttonG[coorX][coorY].getIcon() == yellow){
                            buttonG[coorX][coorY].setIcon(green);
                            buttonG[coorX][coorY].setEnabled(true);
                        }
                        coorS[j][0] = coorX;
                        coorS[j][1] = coorY;
                        vozmozhenHod = true;
                        break;
                    } else {
                        for (int x = 0; x < 7; x++){
                            coorS[x][0] = -1;
                            coorS[x][1] = -1;
                        }
                        break;
                    }
                }

            }
        } if (!proverka && vozmozhenHod) {
            update(coorS, player);

        }

        if(coorX < 6 && coorY > 1){
            if (buttonG[coorX + 1][coorY - 1].getIcon() == icn2){
                coorS[0][0] = coorX + 1;
                coorS[0][1] = coorY - 1;
                i = coorX + 2;
                k = coorY - 2;
                j = 1;
                while (i <= 7 && k >= 0){
                    if (buttonG[i][k].getIcon() == icn2) {
                        coorS[j][0] = i;
                        coorS[j][1] = k;
                        i++;
                        k--;
                        j++;
                    } else if (buttonG[i][k].getIcon() == icn1) {
                        if (proverka && buttonG[coorX][coorY].getIcon() == yellow){
                            buttonG[coorX][coorY].setIcon(green);
                            buttonG[coorX][coorY].setEnabled(true);
                        }
                        coorS[j][0] = coorX;
                        coorS[j][1] = coorY;
                        vozmozhenHod = true;
                        break;
                    } else {
                        for (int x = 0; x < 7; x++){
                            coorS[x][0] = -1;
                            coorS[x][1] = -1;
                        }
                        break;
                    }
                }

            }
        } if (!proverka && vozmozhenHod) {
            update(coorS, player);
            vozmozhenHod = false;
            plateStep();
        }
    }

    private void update(int[][] coorS, boolean player){
        Icon pl;
        if (player){
            pl = black;
        } else pl = white;

        for (int x = 0; x <= 7; x++){
            if (coorS[x][0] != -1) {
                buttonG[coorS[x][0]][coorS[x][1]].setIcon(pl);
            } else break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int coorX = ((Knopka) e.getSource()).getXx();
        int coorY = ((Knopka) e.getSource()).getYy();
     //   players.setText(String.valueOf(coorX) + String.valueOf(coorY));
        if (buttonG[coorX][coorY].getIcon() == green) {
            step(coorX, coorY, round, false);
        }
    }


    private void plateStep(){

        // Нужно вписать метод определения возможных ходов, метода два, для чёрных и для белых
        if (round) {
            players.setText("White");
            round = false;
            stepTest(round);


        } else {
            players.setText("Black");
            round = true;
            stepTest(round);
        }
    }

     private void stepTest(boolean round) {
        boolean okG = false;
        boolean okY = false;
         for (rows = 0; rows <= 7; rows++) {
             for (cols = 0; cols <= 7; cols++) {
                if (buttonG[rows][cols].getIcon() != black && buttonG[rows][cols].getIcon() != white ){
                    buttonG[rows][cols].setIcon(yellow);
                }
             }
         }
             for (rows = 0; rows <= 7; rows++) {
                 for (cols = 0; cols <= 7; cols++) {
                     if (buttonG[rows][cols].getIcon() != black && buttonG[rows][cols].getIcon() != white ) {
                         step(rows, cols, round, true);
                     }
                 }
             }
         for (rows = 0; rows <= 7; rows++) {
             for (cols = 0; cols <= 7; cols++) {
                if (buttonG[rows][cols].getIcon() == green){
                    okG = true;

                }
                if (buttonG[rows][cols].getIcon() == yellow){
                    okY = true;
                }
             }if (okG){break;}
         }
            if (!okG && okY){
             plateStep();
            }
     }
}
