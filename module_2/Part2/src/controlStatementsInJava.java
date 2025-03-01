import java.util.Scanner;
/**
 * This is a simple exercise in how to use Control Statements.
 */

public class controlStatementsInJava {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        double operand1 = 0.0;
        double operand2 = 0.0;
        String falseInput = "";
        
        System.out.println("Enter a number for your first operand: ");

        if (!userInput.hasNextDouble()) {
            while (!userInput.hasNextDouble()) {
                falseInput = userInput.next(); // You have to store the input to negate an infinite loop
                System.out.println("You need to enter a number, enter a first operand: ");
            }
      
        } else {
            operand1 = userInput.nextDouble();
        }

        System.out.printf("Cool, you chose %.0f. Now enter a number for your second operand: %n", operand1);

        if (!userInput.hasNextDouble()) {
            while (!userInput.hasNextDouble()) {
                falseInput = userInput.next(); // You have to store the input to negate an infinite loop
                System.out.println("Come on, you already know what to do!: ");
            }

        } else {
            operand2 = userInput.nextDouble();
        }
    
    }
}
