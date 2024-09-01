package edu.uca.dhoelzeman.gui;

import edu.uca.dhoelzeman.console.Register;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    private Register register;
    private JPanel inputPanel;
    private JTextField input;
    private PursePanel changePanel;

    public RegisterPanel() {
        super();

        // The register used for displaying the change
        register = new Register();

        // The Input Panel
        inputPanel = new JPanel();

        // The Text Field
        input = new JTextField("0", 10);
        input.addActionListener(new InputListener()); // The listener that responds to the Enter key press
        this.add(input);

        // The panel to show the change
        inputPanel = new JPanel();
        inputPanel.setPreferredSize(new Dimension(200, 200));
        inputPanel.setBackground(Color.GREEN);
        this.add(inputPanel);

        // Adds the properties for the label
        this.setPreferredSize(new Dimension(200, 200));
        this.setBackground(Color.blue);
    }

    class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double amt = 0;
            boolean validInput;
            try {
                amt = Double.parseDouble(e.getActionCommand());
                validInput = true;
            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(null, "Invalid input (Double Expected)");
                validInput = false;
            }

            // Do not process amt if conversion was not successful
            if (!validInput) {
                return;
            }

            register.makeChange(amt);

            /*
                TODO: Add actual register display functionality
                and replace inputPanel with changePanel that displays
                the coins and such returned
             */
            JButton button = new JButton("Click Me!");
            button.setVisible(true);
            inputPanel.add(button);

            // Redraws the inputPanel so that it is visible when the Enter key is pressed
            inputPanel.revalidate();
            inputPanel.repaint();
        }
    }
}
