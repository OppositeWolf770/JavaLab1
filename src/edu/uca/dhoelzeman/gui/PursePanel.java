package edu.uca.dhoelzeman.gui;

import edu.uca.dhoelzeman.console.CurrencyValues;
import edu.uca.dhoelzeman.console.Purse;
import edu.uca.dhoelzeman.console.Denomination;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PursePanel extends JPanel {
    private Purse purse;

    public PursePanel() {
        super();
    }

    public void setPurse(Purse purse) {
        this.purse = purse;
    }


    public void displayCash() {
        if (this.purse == null) {
            return;
        }

        for (var denomination : purse.getCash().entrySet()) {
            // The panel to hold the same types of bills together
            JPanel stackPanel = new JPanel();
            stackPanel.setLayout(new BoxLayout(stackPanel, BoxLayout.Y_AXIS));
            stackPanel.add(new JLabel(
                    denomination.getValue()
                            + " "
                            + denomination.getKey().name()
                            + (denomination.getKey().form() == CurrencyValues.Forms.Bill ? " Bills" : "")
                    )
            );

            for (int num = 0; num < denomination.getValue(); num++) {
                // Limit the display of the specific denomination to improve performance
                if (num == 10) {
                    break;
                }

                ImageIcon resizedIcon = getImageIcon(denomination);

                var denominationLabel = new JLabel(resizedIcon);
                stackPanel.add(denominationLabel);
            }

            this.add(stackPanel);
        }
    }

    private static ImageIcon getImageIcon(Map.Entry<Denomination, Integer> denomination) {
        return scaleImageIcon(denomination.getKey().img(),
                              denomination.getKey().form() == CurrencyValues.Forms.Bill ? 100 : 50,
                              50);
    }

    private static ImageIcon scaleImageIcon(String imgPath, int width, int height) {
        ImageIcon originalIcon = new ImageIcon(imgPath);
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        originalImage.flush();

        return new ImageIcon(resizedImage);
    }
}
