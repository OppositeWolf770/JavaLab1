public class Register {

    public Purse makeChange(double amt) {
        var purse = new Purse();

        double new_amt = amt % 100;

        purse.add(new Denomination(Names.ONE_HUNDRED, 100, Forms.Bill, "NYI"),((int) amt / 100));


        return purse;
    }
}
