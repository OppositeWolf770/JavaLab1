import java.util.HashMap;
import java.util.Map;

public class Purse {
    private final Map<Denomination, Integer> cash = new HashMap<>();

    public void add(Denomination type, int num) {
        if (cash.containsKey(type)) {
            cash.put(type, cash.get(type) + num);
            return;
        }

        cash.put(type, num);
    }

    public double remove(Denomination type, int num) {

        return 0;
    }

    public double getValue() {
        for (var entry : cash.entrySet() ) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        return 0;
    }

    public String toString() {

        return "";
    }


}
