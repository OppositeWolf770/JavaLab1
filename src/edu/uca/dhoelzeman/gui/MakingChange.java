package edu.uca.dhoelzeman.gui;

import javax.swing.*;
import java.awt.*;

public class MakingChange {
    private static JFrame frame;

    public static void main(String[] args) {
        frame = new JFrame("Making Change");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setLocationRelativeTo(null);

        var registerPanel = new RegisterPanel();
        frame.add(registerPanel);

        frame.pack();
        frame.setVisible(true);
    }

//    public static void initialize() {
//        frame = new JFrame("Making Change");
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        frame.setPreferredSize(new Dimension(800, 600));
//        frame.setSize(new Dimension(800, 600));
//        frame.setLocation(200, 200);
//        frame.setResizable(false);
//
//        // Create the registerPanel and add it to the frame
//        var registerPanel = new RegisterPanel();
//        frame.getContentPane().add(registerPanel);
//
//        frame.pack();
//        frame.setVisible(true);
//    }
}
