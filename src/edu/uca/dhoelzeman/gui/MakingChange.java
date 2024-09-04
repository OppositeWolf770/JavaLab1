package edu.uca.dhoelzeman.gui;

import edu.uca.dhoelzeman.console.Register;

import javax.swing.*;
import java.awt.*;

/**
 * The main class for the GUI portion of the lab.
 * Contains the main function and sets up the
 * frame for the program.
 */
public class MakingChange {
    private static JFrame frame;

    public static void main(String[] args) {
        // Set up the Window for the GUI Application and
        // configures its settings
        frame = new JFrame("Making Change");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000, 600));
        frame.setResizable(false);
        frame.setIconImage(new ImageIcon(Register.base_url + "register.png")
                .getImage()
        );

        // Add a new instance of a RegisterPanel and add it to the frame
        var registerPanel = new RegisterPanel();
        frame.add(registerPanel);

        // Pack the frame and make it visible
        frame.pack();
        frame.setVisible(true);
    }
}
