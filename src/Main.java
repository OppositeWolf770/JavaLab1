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

        register.makeChange(amt);
    }
}