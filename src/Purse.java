import java.math.BigDecimal;
import java.math.RoundingMode;
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
        double amt = getValue();

        for (var denomination : cash.keySet()) {
            cash.remove(denomination);
        }

        return amt;
    }

    public double getValue() {
        var sum = BigDecimal.valueOf(0);

        for (var entry : cash.entrySet() ) {
            sum = sum.add(BigDecimal.valueOf(entry.getKey().amt() * entry.getValue()));
//            sum += entry.getKey().amt() * entry.getValue();
        }

//        sum = sum.setScale(2, RoundingMode.HALF_UP);

//        sum = Math.floor(sum * 100) / 100;
        System.out.println(sum);

        return sum.doubleValue();
    }

    public String toString() {
        return "" + getValue();
    }
}
