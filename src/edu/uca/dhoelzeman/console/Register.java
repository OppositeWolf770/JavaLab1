package edu.uca.dhoelzeman.console;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;


 /**
  * Main Class for the Console Program. Contains the main function,
  * and the function to make the change for a provided Purse.
  */
public class Register {
    public static void main(String[] args) {
        var register = new Register();
        var scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter amount: ");

        // Attempt to assign console input to amt
        double amt;
        try {
            amt = scanner.nextDouble();
        } catch(InputMismatchException e) {
            // Exit early if user does not enter a Double
            System.out.println("Invalid input. Exiting...");
            return;
        }

        // Make the change and output the purse contents to the console
        var purse = register.makeChange(amt);
        System.out.println(purse);
    }


     /**
      * Converts the specified amount to their respective denomination values and
      * return a purse containing that amount
      */
    public Purse makeChange(double amount) {
        var purse = new Purse();

        // If amount is <= 0, return early
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

            // currencyValue.value is converted to cents to be used in calculations
            double remainingAmount = amount % (currencyValue.value * 100);
            int num = (int) (amount / (currencyValue.value * 100)); // The number of that bill to put in Purse

            // Add the denomination to the purse if num != 0
            if (num != 0) {
                var denomination = new Denomination(currencyValue.name, currencyValue.value, currencyValue.form, currencyValue.img);
                purse.add(denomination, num);
            }

            // Update amount after adding the denomination to the purse
            amount = remainingAmount;
        }

        return purse;
    }
}
