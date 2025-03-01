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
        char operator;
        
        System.out.println("Enter a number for your first operand  (0-100): ");

        if (!userInput.hasNextDouble()) {
            while (!userInput.hasNextDouble()) {
                falseInput = userInput.next(); // You have to store the input to negate an infinite loop
                System.out.println("You need to enter a number, enter a first operand (0-100): ");
            }
            operand1 = userInput.nextDouble();
            
        } else {
            operand1 = userInput.nextDouble();
        }

        System.out.printf("Cool, you chose %.0f. Now enter a number for your second operand (0-100): %n", operand1);

        if (!userInput.hasNextDouble()) {
            while (!userInput.hasNextDouble()) {
                falseInput = userInput.next(); // You have to store the input to negate an infinite loop
                System.out.println("Come on, you already know what to do!: ");
            }
            operand2 = userInput.nextDouble();

        } else {
            operand2 = userInput.nextDouble();
        }
        
        if (operand1 >= 0 && operand1 <= 100 && operand2 >= 0 && operand2 <= 100) {
            System.out.println("Alright, and now your operator (+, -, *, /, %): ");
            //System.out.printf("Alright, %.0f and %.0f, and now your operator (+, -, *, /, %): %n", operand1, operand2);

            operator = userInput.next().charAt(0);

            switch (operator) {
                case '+':
                System.out.println("The result is " + (operand1 + operand2));
                    break;
                
                case '-':
                System.out.println("The result is " + (operand1 - operand2));
                    break;

                case '*':
                System.out.println("The result is " + (operand1 * operand2));
                    break;
                
                case '/':
                System.out.println("The result is " + (operand1 / operand2));
                    break;

                case '%':
                System.out.println("The result is " + (operand1 % operand2));
                    break;
        
                default:
                System.out.println("Invalid input, try again: ");
                    break;
            }
        } else {
            System.out.println("Invalid input, try again: ");

        }
    userInput.close();
    }
}
