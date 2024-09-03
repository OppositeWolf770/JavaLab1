package edu.uca.dhoelzeman.gui;

import edu.uca.dhoelzeman.console.Register;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {
    private final Register register;
    private JPanel inputPanel;
    private JTextField input;
    private final PursePanel changePanel;

    public RegisterPanel() {
        super();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // The register used for displaying the change
        register = new Register();

        // The Input Panel
        inputPanel = new JPanel();

        // Label describing the Text Field
        var inputLabel = new JLabel("Enter amount");
        inputPanel.add(inputLabel);


        // The Text Field for the user to enter the amount to convert
        input = new JTextField("", 10);
        input.addActionListener(new InputListener()); // The listener that responds to the Enter key press
        inputPanel.add(input);

        this.add(inputPanel);
//
        // The panel to show the change
        changePanel = new PursePanel();
        changePanel.setPreferredSize(new Dimension(100, 1000));
        this.add(changePanel);
    }

    class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (changePanel == null) {
                return;
            }

            // Get the amount entered and try to convert it to a Double
            double amt;
            try {
                amt = Double.parseDouble(e.getActionCommand());

                if (amt < 0) {
                    throw new IllegalArgumentException("Amount cannot be negative");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input (Double Expected)");
                return;
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return;
            }

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
