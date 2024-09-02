package edu.uca.dhoelzeman.console;

import edu.uca.dhoelzeman.gui.MakingChange;

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
     * @param amt The amount of money to be converted
     * @return A {@link Purse} containing the individual {@link Denomination} values from the provided money value
     *
     * @see Purse
     * @see Denomination
     */
    public Purse makeChange(double amt) {
        var purse = new Purse();

        amt *= 100; // Convert amt to all cents

        for (var currencyValue : CurrencyValues.values()) {
            // Prevent unnecessary code execution if amt is less than a Penny
            if (amt < CurrencyValues.PENNY.value) {
                break;
            }

            // currencyValue.value is multiplied by 100 here, because amt was converted to cents above
            double new_amt = amt % (currencyValue.value * 100);
            int num = (int) (amt / (currencyValue.value * 100)); // The number of that bill to put in consoleClasses.Purse

            if (num != 0) {
                var form = currencyValue.value >= 1 ? CurrencyValues.Forms.Bill : CurrencyValues.Forms.Coin;
                var denomination = new Denomination(currencyValue.name, currencyValue.value, form, "NYI");
                purse.add(denomination, num);
            }

            amt = new_amt;
        }

        return purse;
    }
}
