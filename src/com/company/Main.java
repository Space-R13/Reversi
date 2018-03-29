package com.company;

import javax.swing.*;
import java.io.IOException;
import java.lang.*;


public class Main{

//    boolean player;
 //   int x = 0, y = 0;

 /**   JButton[][] grid;
    int[][] state;
    File fileBlack = new File(System.getProperty("user.dir") + "/src/com/company/jpg/Black.jpg");
    Image imageBlack = ImageIO.read(fileBlack);
    File fileWhite = new File(System.getProperty("user.dir") + "/src/com/company/jpg/White.jpg");
    Image imageWhite = ImageIO.read(fileWhite);
    Icon white = new ImageIcon(imageWhite);
    Icon black = new ImageIcon(imageBlack);



    public Main() throws IOException {
        grid = new JButton[8][8];
        state = new int[8][8];
        window.setLayout(new GridLayout(8, 8));
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                grid[x][y] = new JButton();
                state[x][y] = 0;
                window.add(grid[x][y]);
                grid[x][y].addMouseListener((MouseListener) new CustomListener());
            }
        }
        grid[3][3].setIcon(white);
        grid[3][4].setIcon(black);
        grid[4][3].setIcon(black);
        grid[4][4].setIcon(white);
        state[3][3] = 2;
        state[4][4] = 2;
        state[3][4] = 1;
        state[4][3] = 1;

    }
*/
    public static void main(String[] args) throws IOException {
        new WindowBasic();

    }

 /**   public void step(int x, int y, boolean player, boolean test) {
        int player1, player2, newX, newY, i;
        //int[] update;
        ArrayList<Integer> update = new ArrayList<Integer>();

        boolean isGood;




        if (player == true) {
            player1 = 1;
            player2 = 2;
        } else {
            player1 = 2;
            player2 = 1;
        }

        //влево
        if (x > 1) {
            if (state[x-1][y] == player2) {  // если соседняя клетка занята противником
                update.add(x);
                update.add(y);
                i = x - 2;
                while (i >= 0) {  // и идем в ту же сторону пока не дойдем до пустой или клетки нашего цвета
                    if (state[x][y] == player2) {      // если соседняя клетка занята противником
                        update.add(x);
                        update.add(y);
                        i = i - 1;
                    } else if (state[x][y] == player1) { // // если соседняя клетка наша
                        update.add(x);
                        update.add(y);
                        isGood = true;
                        break;
                    } else if (state[x][y] == 0) { // если дальше пустая клетка выходим
                        update.clear();

                        break;
                    }
                }
            }
            /**   if (isGood == true && test == false) {
                for ( i = 0; i < update ; i = i + 1 ) {
                    state[update[i]][update[i+1]] = player1;
                }
                //for item in update {
                //    state[item] = pl1
                //}
            }
            update.clear();
        }
    }

*/

          /**  if (player == true) {
                grid[x][y].setIcon(black);
                player == false;
                step(x, y, player);
            } else {
                grid[x][y].setIcon(white);
                player == true;
                step(x, y, player);
            }


        }


    }*/

}