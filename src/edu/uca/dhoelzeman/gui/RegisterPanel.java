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

//    public RegisterPanel() {
//        super();
////        this.setLayout(new BorderLayout(1, 2));
////
////        // The register used for displaying the change
////        register = new Register();
////
////        // The Input Panel
////        inputPanel = new JPanel();
////
////        // Label about input panel
////        var inputLabel = new JLabel("Enter amount");
////        this.add(inputLabel, BorderLayout.NORTH);
////
////        // The Text Field
////        input = new JTextField("0", 10);
////        input.addActionListener(new InputListener()); // The listener that responds to the Enter key press
////        this.add(input, BorderLayout.NORTH);
////
////        // The panel to show the change
////        changePanel = new PursePanel();
//////        changePanel.setSize(new Dimension(200, 200));
//////        changePanel.setVisible(true);
////        changePanel.add(new JButton("PursePanel button"));
////        this.add(changePanel, BorderLayout.SOUTH);
////
////        // Adds the properties for the label
////        this.setPreferredSize(new Dimension(800, 600));
////        this.setBackground(Color.blue);
//    }

//    class InputListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            double amt;
//            try {
//                amt = Double.parseDouble(e.getActionCommand());
//            } catch (NumberFormatException ex) {
//                JOptionPane.showMessageDialog(null, "Invalid input (Double Expected)");
//                return;
//            }
////
//            register.makeChange(amt);
////
////            /*
////                TODO: Add actual register display functionality
////                and replace inputPanel with changePanel that displays
////                the coins and such returned
////             */
////            changePanel.removeAll();
////
////            JButton button = new JButton("Click Me!");
//////            button.setVisible(true);
////            changePanel.add(button);
////
////            // Redraws the inputPanel so that it is visible when the Enter key is pressed
////            changePanel.revalidate();
////            changePanel.repaint();
//        }
//    }
}
