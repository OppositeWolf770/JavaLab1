package edu.uca.dhoelzeman.console;

/**
 * Holds the denomination values for use in the {@link Register} class
 * and functions stored in the {@link Purse} class.<br><br>
 *
 * Using this enum allows for modular addition and deletion of {@link Denomination}
 * values in the future easily.
 */
public enum CurrencyValues {
    HUNDRED("Hundred-Dollar", 100, Forms.Bill),
    FIFTY("Fifty-Dollar", 50, Forms.Bill),
    TWENTY("Twenty-Dollar", 20, Forms.Bill),
    TEN("Ten-Dollar", 10, Forms.Bill),
    FIVE("Five-Dollar", 5, Forms.Bill),
    ONE("One-Dollar", 1, Forms.Bill),
    QUARTER("Quarter", 0.25, Forms.Coin),
    DIME("Dime", 0.10, Forms.Coin),
    NICKEL("Nickel", 0.05, Forms.Coin),
    PENNY("Penny", 0.01, Forms.Coin);

    public enum Forms {
        Bill,
        Coin
    }

    // Contains the images directory for all the denominations
    public static final String base_url = "src/edu/uca/dhoelzeman/gui/images/";

    // The data about the specific Denomination
    public final double value;
    public final String name;
    public final Forms form;
    public final String img;

    /**
     * Constructs the denomination using the values provided
     */
    CurrencyValues(String name, double value, Forms form) {
        this.name = name;
        this.value = value;
        this.form = form;
        this.img = base_url + name + ".png";
    }
}
