public class Register {
    public Purse makeChange(double amt) {
        var purse = new Purse();

        amt *= 100; // Convert amt to all cents

        for (var currencyValue : CurrencyValues.values()) {
            // Prevent unnecessary code execution if amt is 0
            if (amt == 0) {
                break;
            }

            // currencyValue.value is multiplied by 100 here, because amt was converted to cents above
            double new_amt = amt % (currencyValue.value * 100);
            int num = (int) (amt / (currencyValue.value * 100)); // The number of that bill to put in Purse

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
