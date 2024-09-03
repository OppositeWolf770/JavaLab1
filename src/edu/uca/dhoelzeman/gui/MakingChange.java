package edu.uca.dhoelzeman.gui;

import javax.swing.*;
import java.awt.*;

public class MakingChange {
    private static JFrame frame;

    public static void main(String[] args) {
        frame = new JFrame("Making Change");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000, 600));
        frame.setIconImage(new ImageIcon("src/edu/uca/dhoelzeman/gui/images/register.png")
                .getImage()
        );


        // Add the registerPanel to the window frame
        var registerPanel = new RegisterPanel();
        frame.add(registerPanel);

        // Pack the frame and make it visible
        frame.pack();
        frame.setVisible(true);
    }
}
