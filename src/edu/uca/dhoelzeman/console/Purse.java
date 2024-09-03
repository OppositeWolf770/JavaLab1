package edu.uca.dhoelzeman.console;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 */
public class Purse {
    private final Map<Denomination, Integer> cash = new LinkedHashMap<>();

    public Map<Denomination, Integer> getCash() {
        return cash;
    }

    /** Adds the specified number of a denomination to the purse
     * @param denomination The denomination to be added (100 Note, 1 Note, Quarter)
     * @param num The number of that denomination to add to the purse
     * @see Denomination
     */
    public void add(Denomination denomination, int num) {
        if (cash.containsKey(denomination)) {
            cash.put(denomination, cash.get(denomination) + num);
            return;
        }

        cash.put(denomination, num);
    }

    /** Removes the specified number of a denomination from the purse
     * @param type The type of the denomination (100 Note, 1 Note, Quarter)
     * @param num The number of that denomination to remove
     * @return The amount in the purse after removal of a denomination amount
     * @see Denomination
     * @see CurrencyValues
     */
    public double remove(Denomination type, int num) {
        double amt = getValue();

        for (var denomination : cash.keySet()) {
            cash.remove(denomination);
        }

        return amt;
    }

    public double getValue() {
        double sum = 0;

        for (var entry : cash.entrySet() ) {
            sum += entry.getKey().amt() * entry.getValue();
        }

        return sum;
    }

    /**
     * @return The cash in the purse in an output friendly String format
     */
    public String toString() {
        if (getValue() == 0) {
            return "Empty Purse";
        }

        StringBuilder builder = new StringBuilder();

        // Loops through the denominations in the purse
        for (var denomination : cash.entrySet()) {
            var name = denomination.getKey().name();
            var num = denomination.getValue();
            var form = denomination.getKey().form();

            // Builds the registerOutput to be returned
            builder.append(num).append(" ")
                   .append(name)
                   .append(form == CurrencyValues.Forms.Bill ? " Note" : "")
                   .append("\n");
        }

        return builder.toString();
    }
}
