public class Register {
    public Purse makeChange(double amt) {
        var purse = new Purse();

        for (var currencyValue : CurrencyValues.values()) {
            // Prevent unnecessary code execution if amt is 0
            if (amt == 0) {
                break;
            }

            double new_amt = amt % currencyValue.value;
            int num = (int) (amt / currencyValue.value); // The number of that bill to put in Purse

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
