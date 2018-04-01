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

public class WindowBasic extends Frame{
    private GridBagConstraints constraints;
    private JPanel panel;
    private JButton res;
    private JButton clo;
    private JTextField player, score;
    private int rows, cols;
    private final int playerBlack = 0, playerWhite = 1;
    private JButton buttonG;
    private int round = 1;
    private int whiteP, blackP;
    private int [][] number;
    private Timer timeRound;
    private Color color = new Color(230,191,0);


    public WindowBasic() throws IOException {

        JFrame frame = new JFrame("Reverse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        winBas(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        frame.setSize(300,360);
        frame.setResizable(false);
        frame.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println(e);
            }
        });
    }

    private void winBas(Container container) throws IOException {
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

        number = new int[8][8];
        panel = new JPanel(new GridLayout(8, 8));
        panel.setPreferredSize(new Dimension(270, 270));
        for (rows = 0; rows < 8; rows++) {
            for (cols = 0; cols < 8; cols++) {
                number[rows][cols] = 0;
                buttonG = new JButton(Integer.toString(number[rows][cols]));
                buttonG.addActionListener(new PositionAwareActionListener(rows, cols));
                buttonG.setBackground(color);
          //      buttonG.setEnabled(false);
                panel.add(buttonG);
                if (number[rows][cols] == 0) {
                    buttonG.setEnabled(false); // сокрытие нулевого елемента массива
                } else
                    buttonG.addActionListener(new PositionAwareActionListener(rows, cols));

          //      number[rows][cols] = Integer.parseInt(String.valueOf(number[rows][cols]));
            }
        }
        constraints.weightx = 0.0;
        constraints.gridwidth = 4;
        constraints.gridx = 0;    // нулевая ячейка по горизонтали
        constraints.gridy = 1;    // первая ячейка по вертикали
        container.add(panel, constraints);
        File fileBlack = new File(System.getProperty("user.dir") + "/src/com/company/jpg/Black.jpg");
        Image imageBlack = ImageIO.read(fileBlack);
        File fileWhite = new File(System.getProperty("user.dir") + "/src/com/company/jpg/White.jpg");
        Image imageWhite = ImageIO.read(fileWhite);
        Icon white = new ImageIcon(imageWhite);
        Icon black = new ImageIcon(imageBlack);


     //   number[3][3] =
        number[3][4] = blackP;
        number[4][3] = whiteP;
        number[4][4] = blackP;
/**
        buttonG.setEnabled();
        number[3][4].setEnabled(true);
        number[4][3].setEnabled(true);
        number[4][4].setEnabled(true);
        buttonG.setIcon();
        number[3][4].setIcon(black);
        number[4][3].setIcon(black);
        number[4][4].setIcon(white);
*/

    }

    void platerStep(int round){
        switch (round){
            case playerBlack:
                round = playerWhite; // Нужно вписать метод определения возможных ходов, метода два, для чёрных и для белых
                player.setText("White");
                break;
            case playerWhite:
                round = playerBlack;
                player.setText("Black");
                break;
        }
    }

    void stepBlack(){
      /**  Boolean b;
        Если b=true(включить),Если b=false(выключить);
        jButton2.setEnabled(b);
       также таймер обозначит на минуту в score
       определение ходов используя операции с массивом, определить адрес и значения в клетках рядом, определить в какие клетки можно поставить фишку.
       А именно если клетка рядом пустая, если клетка рядом занята белыми, если клетка рядом занята чёрными. Заблокировать клетки далёкие.
       Не использовать mouseListener, программа сама определяет возможные ходы, помечая клетки цветом. добавление иконок на кнопку можно реализовать с помощью метода действия при нажатии кнопки.
       После того как походил игрок, необходимо переопределить иконки для клеток.


       */
    }

    void stepWhite(){

    }


}
