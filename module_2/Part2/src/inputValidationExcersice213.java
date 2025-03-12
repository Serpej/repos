import java.util.Scanner;

public class inputValidationExcersice213 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        boolean isValidInput = false;
        int numberRead = 0;

        while(!isValidInput) {
            System.out.println("Enter a number between 1 and 5, or press q to quit: ");

            if (userInput.hasNextInt()) {
                numberRead = userInput.nextInt();
                if (numberRead <= 5 && numberRead >= 1) {
                    System.out.printf("You entered %d%n", numberRead);
                    userInput.close();
                    isValidInput = true;
                }
            }
            else if (userInput.hasNext()) {
                String inString = userInput.next();
                if (inString.equalsIgnoreCase("q")) {
                    System.out.println("I am exiting");
                    userInput.close();
                    isValidInput = true;
                 
                }
            }
        }
    }
}
