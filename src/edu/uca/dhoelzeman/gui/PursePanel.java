package edu.uca.dhoelzeman.gui;

import edu.uca.dhoelzeman.console.Forms;
import edu.uca.dhoelzeman.console.Purse;
import edu.uca.dhoelzeman.console.Denomination;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * Holds a purse and has methods to display the purse contents
 * to the gui.
 */
public class PursePanel extends JPanel {
    private Purse purse;

    public PursePanel() {
        super();
    }

    // Sets the purse stored in a PursePanel instance
    public void setPurse(Purse purse) {
        this.purse = purse;
    }


    // Displays the cash on the screen
    public void displayCash() {
        // Early return if purse is null
        if (this.purse == null) {
            return;
        }

        // Loops through the denomination in the purse and adds it to the display
        for (var denomination : purse.getCash().entrySet()) {
            // The panel to hold the same types of bills together
            // Uses BoxLayout to align items vertically
            JPanel stackPanel = new JPanel();
            stackPanel.setLayout(new BoxLayout(stackPanel, BoxLayout.Y_AXIS));

            // Adds the label for the specific denomination above the images
            stackPanel.add(new JLabel(
                    denomination.getValue()
                            + " "
                            + denomination.getKey().name()
                            + (denomination.getKey().form() == Forms.Bill ? " Bills" : "")
                    )
            );

            // Adds an image for each number of that denomination in the purse (limit of 10 for performance)
            for (int num = 0; num < denomination.getValue(); num++) {
                // Limit the display of the specific denomination to improve performance
                if (num == 10) {
                    break;
                }

                // Resizes the icon to fit the specifications
                ImageIcon resizedIcon = getImageIcon(denomination);

                JLabel denominationLabel = new JLabel(resizedIcon);
                stackPanel.add(denominationLabel);
            }

            // Add the stack panel to the screen
            this.add(stackPanel);
        }
    }

    // Takes a denomination and returns the scaled down image of that denomination
    private static ImageIcon getImageIcon(Map.Entry<Denomination, Integer> denomination) {
        return scaleImageIcon(denomination.getKey().img(),
                              denomination.getKey().form() == Forms.Bill ? 100 : 50,
                              50);
    }

    // Scales an image down to the specified width and height
    private static ImageIcon scaleImageIcon(String imgPath, int width, int height) {
        ImageIcon originalIcon = new ImageIcon(imgPath);
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        // Flush the original image to prevent a memory leak
        originalImage.flush();

        return new ImageIcon(resizedImage);
    }
}
