package edu.uca.dhoelzeman.gui;

import javax.swing.*;

public class MakingChange {
    private static JFrame frame;

    public static void initialize() {
        frame = new JFrame("Register");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Create the registerPanel and add it to the frame
        var registerPanel = new RegisterPanel();
        frame.getContentPane().add(registerPanel);

        frame.pack();
        frame.setVisible(true);
    }
}
