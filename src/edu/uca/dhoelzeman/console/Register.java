package edu.uca.dhoelzeman.console;

import edu.uca.dhoelzeman.console.CurrencyValues.Forms;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * Contains {@link #makeChange(double)}
 */
public class Register {
    public static void main(String[] args) {
        var register = new Register();
        var scanner = new Scanner(System.in);

        System.out.print("Enter amount: ");
        double amt;
        try {
            amt = scanner.nextDouble();
        } catch(Exception e) {
            System.out.println("Invalid input. Exiting...");
            return;
        }

        var purse = register.makeChange(amt);
        System.out.println(purse);
    }


    /**
     * Converts the specified amount to their respective {@link Denomination} values
     *
     * @param amount The amount of money to be converted
     * @return A {@link Purse} containing the individual {@link Denomination} values from the provided money value
     *
     * @see Purse
     * @see Denomination
     */
    public Purse makeChange(double amount) {
        var purse = new Purse();

        // If value is 0 or a negative number, return early
        if (amount <= 0) {
            return purse;
        }

        // Rounds decimals >= .005 up to a penny
        amount = BigDecimal.valueOf(amount)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();

        amount *= 100; // Convert amt to all cents for easier calculations

        // Loops through each CurrencyValue and gets the correct amount of that denomination to add to the purse
        for (var currencyValue : CurrencyValues.values()) {
            // Prevent unnecessary code execution if amt is less than a Penny
            if (amount < CurrencyValues.PENNY.value) {
                break;
            }

            // currencyValue.value is multiplied by 100 here, because amt was converted to cents above
            double remainingAmount = amount % (currencyValue.value * 100);
            int num = (int) (amount / (currencyValue.value * 100)); // The number of that bill to put in Purse

            // Add the denomination to the purse
            if (num != 0) {
                Forms form = currencyValue.value >= 1 ? Forms.Bill : Forms.Coin;
                String img = "src/edu/uca/dhoelzeman/gui/images/" + currencyValue.name + ".png";
                var denomination = new Denomination(currencyValue.name, currencyValue.value, form, img);
                purse.add(denomination, num);
            }

            amount = remainingAmount;
        }

        return purse;
    }
}
