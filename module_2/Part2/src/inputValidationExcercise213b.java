import java.util.Scanner;

public class inputValidationExcercise213b {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        boolean isValidInput = false;
        float numberRead = 0.0f;

        while(!isValidInput) {
            System.out.println("Enter a floating point number between 0.0 and 0.1: ");

            if (userInput.hasNextFloat()) {
                numberRead = userInput.nextFloat();
                if (numberRead >= 0.0 && numberRead <= 0.1) {
                    System.out.println("you entered " + numberRead);
                    isValidInput = true;
                    userInput.close();
                }
            }
            else if (userInput.hasNext()) {
                String inString = userInput.next();
                if (inString.equalsIgnoreCase("q")) {
                    System.out.println("I am exiting");
                    isValidInput = true;
                    userInput.close();
                }
            }
        }
    }
}
