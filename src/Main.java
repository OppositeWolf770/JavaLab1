import edu.uca.dhoelzeman.console.Register;
import edu.uca.dhoelzeman.gui.MakingChange;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var register = new Register();
        var scanner = new Scanner(System.in);

        // Initializes the GUI
        MakingChange.main();

        double amt;

        System.out.print("Enter amount: ");
        try {
            amt = scanner.nextDouble();
        } catch(Exception e) {
            System.out.println("Invalid input. Exiting...");
            return;
        }

        var purse = register.makeChange(amt);

        System.out.println(purse);
    }
}