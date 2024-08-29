package edu.uca.dhoelzeman.gui;

import edu.uca.dhoelzeman.console.Register;

import javax.swing.*;

public class MakingChange {
    private static final JFrame frame = new JFrame("Register");

    public static void initialize(Register register) {
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var registerPanel = new RegisterPanel(register);

        frame.add(registerPanel);

        frame.setVisible(true);
    }

}
