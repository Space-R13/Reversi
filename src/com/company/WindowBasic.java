package com.company;


import javax.swing.*;
import java.awt.*;

public class WindowBasic{


    public WindowBasic() {
        JFrame windowB = new JFrame("Реверси");
        windowB.setSize(500,500);
        windowB.setVisible(true);
        windowB.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        windowB.setResizable(false);
    }
}
