import java.util.Scanner;
/**
 * This is a test on how to use While loops
 * to validate user input.
 */

public class validatingWithWhile {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        
        double answer = 0.0;
        String word = "";
        
        System.out.println("Enter a number:");
        
        while (!userInput.hasNextDouble()) {
            word = userInput.next();
            System.err.println(word + " is not a number");
            System.out.println("Enter a number :");
        }
        answer = userInput.nextDouble();
        System.out.printf("You entered %.0f.%n", answer);
        userInput.close();
        System.exit(0);
    }
}
