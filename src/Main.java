import javax.swing.*;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var register = new Register();
        var scanner = new Scanner(System.in);

        double amt;

        System.out.print("Enter amount: ");

        try {
            amt = scanner.nextDouble();
        } catch(Exception e) {
            System.out.println("Invalid input. Exiting...");
            return;
        }

        var purse = register.makeChange(new BigDecimal(Double.toString(amt)));

        purse.getValue();

        System.out.println(purse);

//        purse.remove();
    }
}