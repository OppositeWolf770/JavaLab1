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
    public static final String base_url = "src/images/";

    public static final Denomination HUNDRED = new Denomination("Hundred-Dollar", 100, Forms.Bill, base_url + "Hundred-Dollar.png"),
                                     FIFTY = new Denomination("Fifty-Dollar", 50, Forms.Bill, base_url + "Fifty-Dollar.png"),
                                     TWENTY = new Denomination("Twenty-Dollar", 20, Forms.Bill, base_url + "Twenty-Dollar.png"),
                                     TEN = new Denomination("Ten-Dollar", 10, Forms.Bill, base_url + "Ten-Dollar.png"),
                                     FIVE = new Denomination("Five-Dollar", 5, Forms.Bill, base_url + "Five-Dollar.png"),
                                     ONE = new Denomination("One-Dollar", 1, Forms.Bill, base_url + "One-Dollar.png"),
                                     QUARTER = new Denomination("Quarter", 0.25, Forms.Coin, base_url + "Quarter.png"),
                                     DIME = new Denomination("Dime", 0.10, Forms.Coin, base_url + "Dime.png"),
                                     NICKEL = new Denomination("Nickel", 0.05, Forms.Coin, base_url + "Nickel.png"),
                                     PENNY = new Denomination("Penny", 0.01, Forms.Coin, base_url + "Penny.png");

    private final Denomination[] denominations = {HUNDRED, FIFTY, TWENTY, TEN, FIVE, ONE, QUARTER, DIME, NICKEL, PENNY};

    public static void main(String[] args) {
        var register = new Register();
        var scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter amount: ");

        // Attempt to assign console input to value
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

        amount *= 100; // Convert value to all cents for easier calculations

        // Loops through each denomination and gets the correct amount of that denomination to add to the purse
        for (var denomination : denominations) {
            // Prevent unnecessary code execution if value is less than a Penny
            if (amount < PENNY.value() * 100) {
                break;
            }

            // denomination.value is converted to cents to be used in calculations
            double remainingAmount = amount % (denomination.value() * 100);
            int num = (int) (amount / (denomination.value() * 100)); // The number of that bill to put in Purse

            // Add the denomination to the purse if num != 0
            if (num != 0) {
                purse.add(denomination, num);
            }

            // Update amount after adding the denomination to the purse
            amount = remainingAmount;
        }

        return purse;
    }
}
