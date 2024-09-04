package edu.uca.dhoelzeman.gui;

import edu.uca.dhoelzeman.console.Register;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Contains the register and a PursePanel to show the contents of a purse
 * when makeChange is called
 */
public class RegisterPanel extends JPanel {
    private final Register register;
    private final JPanel inputPanel;
    private final JTextField input;
    private final PursePanel changePanel;

    public RegisterPanel() {
        super();

        // Use the Box Layout using the Y_AXIS to get things aligned vertically
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // The register used for making the change
        register = new Register();

        // The Input Panel to hold the components for the input
        inputPanel = new JPanel();

        // Label informing the user about the text box
        var inputLabel = new JLabel("Enter amount:");
        inputPanel.add(inputLabel);


        // The Text Field for the user to enter the amount to convert
        input = new JTextField("", 10);
        input.addActionListener(new InputListener()); // The listener that responds to the Enter key press
        inputPanel.add(input);
        this.add(inputPanel);

        // The panel to show the change
        changePanel = new PursePanel();
        changePanel.setPreferredSize(new Dimension(100, 1000));
        this.add(changePanel);
    }

    // Listens for input on the text box to show the purse contents images
    class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (changePanel == null) {
                return;
            }

            // Get the amount entered and try to convert it to a Double
            double amt;
            try {
                amt = Double.parseDouble(e.getActionCommand());

                // Throws an exception if the value is negative
                if (amt < 0) {
                    throw new IllegalArgumentException("Amount cannot be negative");
                }
            // Display a message box indicating the particular user input error
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input (Double Expected)", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Clear the changePanel before adding the new change amount
            changePanel.removeAll();

            // Set the purse and display the cash to the user
            changePanel.setPurse(register.makeChange(amt));
            changePanel.displayCash();

            // Refresh window to show the changes in the purse
            RegisterPanel.this.revalidate();
            RegisterPanel.this.repaint();
        }
    }
}
