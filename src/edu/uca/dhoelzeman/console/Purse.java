package edu.uca.dhoelzeman.console;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Holds a Collection of Denominations and provides methods to modify
 * the collection and print it out as a string
 */
public class Purse {
    // Holds the money that is in the purse and the amount of each denomination
    // Uses a Link
    private final Map<Denomination, Integer> cash = new LinkedHashMap<>();

    // Getter for the cash Map
    public Map<Denomination, Integer> getCash() {
        return cash;
    }

    // Adds the specified number of a denomination to the purse
    public void add(Denomination denomination, int num) {
        if (cash.containsKey(denomination)) {
            cash.put(denomination, cash.get(denomination) + num);
            return;
        }

        cash.put(denomination, num);
    }

    // Removes the specified number of a denomination from the purse
    public double remove(Denomination denomination, int num) {
        // If none of that denomination exists in the purse, do nothing and return the value of the purse
        if (!cash.containsKey(denomination)) {
            return getValue();
        }

        // Gets the state of the purse before and after removal
        int currentAmount = getCash().get(denomination);
        int newAmount = currentAmount - num;

        // Remove the entire denomination if result is <= 0
        if (newAmount <= 0) {
            getCash().remove(denomination);
        } else {
            // Otherwise, just remove the indicated amount
            getCash().put(denomination, newAmount);
        }

        // Return the value of the purse after the removal
        return getValue();
    }

    // Returns the total amount of money in the purse
    public double getValue() {
        double sum = 0;

        // Loops through each denomination and adds its value to the sum
        // according to the amount of that denomination in the purse
        for (var entry : getCash().entrySet() ) {
            sum += entry.getKey().value() * entry.getValue();
        }

        return sum;
    }

    /**
     * Called when the purse is sent to the output stream
     * @return The cash in the purse in an output friendly String format
     */
    public String toString() {
        // Early return if the purse is empty
        if (getCash().isEmpty()) {
            return "Empty Purse";
        }

        // Contains the string block after denominations are added to it
        var purseContents = new StringBuilder();

        // Loops through the denominations in the purse
        for (var denomination : cash.entrySet()) {
            // Defines the values for the denomination in
            // variables to make the string builder more readable
            final String name = denomination.getKey().name();
            final int num = denomination.getValue();
            final String formMsg = denomination.getKey().form() == Forms.Bill ? " Note" : "";

            // Builds the registerOutput to be returned
            purseContents.append(num).append(" ")
                   .append(name)
                   .append(formMsg)
                   .append("\n");
        }

        return purseContents.toString();
    }
}
