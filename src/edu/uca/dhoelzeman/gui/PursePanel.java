package edu.uca.dhoelzeman.gui;

import edu.uca.dhoelzeman.console.Purse;

import javax.swing.*;
import java.awt.*;

public class PursePanel extends JPanel {
    private Purse purse;

    public PursePanel() {
        super();

        this.purse = new Purse();
    }

    public void paintComponent(Graphics g) {

    }
}
