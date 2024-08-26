import java.math.BigDecimal;
import java.math.RoundingMode;


public class Register {
    public Purse makeChange(BigDecimal amt) {
        var purse = new Purse();

        for (var currencyValue : CurrencyValues.values()) {
            BigDecimal new_amt = amt.remainder(new BigDecimal(currencyValue.value))
                    .setScale(2, RoundingMode.HALF_UP);
            int num = amt.divide(new BigDecimal(currencyValue.value), 2, RoundingMode.HALF_UP)
                    .intValue();


            if (num != 0) {
                var form = currencyValue.value > 0 ? CurrencyValues.Forms.Bill : CurrencyValues.Forms.Coin;
                var denomination = new Denomination(currencyValue, currencyValue.value, form, "NYI");
                purse.add(denomination, num);
            }

            amt = new_amt;
        }

        return purse;
    }
}
