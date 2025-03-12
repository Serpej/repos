import java.util.Scanner;
/**
 * A simple program to check if user is eligible for a driver's license.
 */
public class Task41 {
    public static int LEGAL_AGE = 18;
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        boolean isValid = false;
        int age = 0;
        int waitTime = 0;

        System.out.println("Enter you age: ");

        while (!isValid) {
            if (userInput.hasNextInt()) {
                age = userInput.nextInt();
                if (age >= LEGAL_AGE) {
                    System.out.println("You entered " + age + ". Your are eligible for a driver's license.");
                    isValid = true;
                } else if (age < LEGAL_AGE) {
                    waitTime = LEGAL_AGE - age;
                    System.out.println("You entered " + age + ". You need to wait " + waitTime + " year(s) before you can get a driver's license.");
                    isValid = true;
                }
            } else {
                System.out.println("invalid answer.");
            }
        }
        userInput.close();
        System.exit(0);
    }
}
