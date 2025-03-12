import java.util.Scanner;

public class Taski46 {
    static final int ISLESS_ZERO = -1;
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        boolean isValid = false;
        int num = 0;

        while (!isValid) {
            System.out.println("Enter a number: ");
            if (userInput.hasNextInt()) {
                num = userInput.nextInt();
                if (num > ISLESS_ZERO) {
                    System.out.println("You entered a too big number.");
                } else {
                    System.out.println("You entered " + num);
                    userInput.close();
                    isValid = true;
                }

            } else {
                String invalidInput = userInput.nextLine();
                System.out.println("Invalid input. You entered " +  "\"" + invalidInput + "\"");
            }
        }

    }
}
