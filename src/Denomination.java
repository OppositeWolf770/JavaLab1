enum Forms { Bill, Coin }
enum Names { ONE_HUNDRED, FIFTY, TWENTY, TEN, FIVE, ONE, QUARTER, DIME, NICKEL, PENNY }

public record Denomination(Names name, double amt, Forms form, String img) {}

