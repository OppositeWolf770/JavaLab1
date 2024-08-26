public class Register {

    public Purse makeChange(double amt) {
        var purse = new Purse();

        int i;

        for (i = 0; amt - 100 >= 0; i++) {

        }

        while (amt - 100 >= 0) {
            purse.add(new Denomination("100 Note", 100, Form.Bill, "NYI"), 1);

            System.out.println(amt);
        }


        return purse;
    }
}
