enum Form { Bill, Coin }


public record Denomination(String name, double amt, Form form, String img) {

}

