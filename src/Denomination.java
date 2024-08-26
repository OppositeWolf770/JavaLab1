enum CurrencyValues {
    ONE_HUNDRED(100, Forms.Bill),
    FIFTY(50, Forms.Bill),
    TWENTY(20, Forms.Bill),
    TEN(10, Forms.Bill),
    FIVE(5, Forms.Bill),
    ONE(1, Forms.Bill),
    QUARTER(0.25, Forms.Coin),
    DIME(0.10, Forms.Coin),
    NICKEL(0.05, Forms.Coin),
    PENNY(0.01, Forms.Coin);

    enum Forms {
        Bill,
        Coin
    }

    public final double value;
    public final Forms form;

    CurrencyValues(double value, Forms form) {
        this.value = value;
        this.form = form;
    }
}

public record Denomination(CurrencyValues name, double amt, CurrencyValues.Forms form, String img) {}

