/**
 * Holds the denomination values for use in the <code>Register</code> class
 * and functions stored in the <code>Purse</code> class
 * @see Register
 * @see Purse
 */
enum CurrencyValues {
    ONE_HUNDRED("Hundred", 100, Forms.Bill),
    FIFTY("Fifty", 50, Forms.Bill),
    TWENTY("Twenty", 20, Forms.Bill),
    TEN("Ten", 10, Forms.Bill),
    FIVE("Five", 5, Forms.Bill),
    ONE("One", 1, Forms.Bill),
    QUARTER("Quarter", 0.25, Forms.Coin),
    DIME("Dime", 0.10, Forms.Coin),
    NICKEL("Nickel", 0.05, Forms.Coin),
    PENNY("Penny", 0.01, Forms.Coin);

    enum Forms {
        Bill,
        Coin
    }

    public final double value;
    public final String name;
    public final Forms form;

    CurrencyValues(String name, double value, Forms form) {
        this.name = name;
        this.value = value;
        this.form = form;
    }
}

public record Denomination(String name, double amt, CurrencyValues.Forms form, String img) {}

