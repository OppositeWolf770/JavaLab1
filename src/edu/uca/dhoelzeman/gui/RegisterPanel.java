package edu.uca.dhoelzeman.gui;

import edu.uca.dhoelzeman.console.Register;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    private Register register;
    private JPanel inputPanel;
    private JTextField input;
    private PursePanel changePanel;

    public RegisterPanel(Register register) {
        this.register = register;
        this.inputPanel = new JPanel();
        this.input = new JTextField();
        this.changePanel = new PursePanel();
    }

    abstract class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }
}
