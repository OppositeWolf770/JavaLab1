import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Purse {
    private final Map<Denomination, Integer> cash = new HashMap<>();

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

//        sum = Math.floor(sum * 100) / 100;
        System.out.println(sum);

        return sum;
    }

    public String toString() {
        return "" + getValue();
    }
}
