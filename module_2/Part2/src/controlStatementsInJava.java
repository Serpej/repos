import java.util.Scanner;
/**
 * This is a simple exercise in how to use Control Statements.
 */

public class controlStatementsInJava {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        double operand1 = 0.0;
        double operand2 = 0.0;
        
        System.out.println("Enter an operand: ");

        while (!userInput.hasNextDouble()) {

            if (userInput.hasNextDouble()) {
                operand1 = userInput.nextDouble();
            } else {
                System.out.println("You need to enter a number, Enter an operand: ");
            }
        }
    }
}
