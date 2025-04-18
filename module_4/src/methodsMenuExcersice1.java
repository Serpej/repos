import java.util.Scanner;
/**
 * This is a program that calls a menu and awaits a choice from the user
 */

public class methodsMenuExcersice1 {
    public static void main(String[] args) {

        menu();
    }
    public static int menu() {
        Scanner userInput =  new Scanner(System.in);
        boolean validInput  = false;
        int answer = -1;
        String choice = "Your choice: ";
        String deposit = "Deposit money";
        String withdraw =  "Withdraw money";
        String balance = "Balance sheet";
        String exit =  "Finish";

        while (!validInput) {
            System.out.println("Menu");
            System.out.printf("1. %s%n", deposit);
            System.out.printf("2. %s%n", withdraw);
            System.out.printf("3. %s%n", balance);
            System.out.printf("4. %s%n", exit);
            if (userInput.hasNextInt()) {
                answer = userInput.nextInt();
                userInput.close();
                validInput = true;
            } else {
                System.out.println("Error, invalid input. Try again.");
                System.out.println();
                userInput.nextLine();
            }
        }
        if (answer == 1) {
            System.out.printf("%s%s%n", choice, deposit);
            return 1;
        } else if (answer == 2) {
            System.out.printf("%s%s%n", choice, withdraw);
            return 2;
        } else if (answer == 3) {
            System.out.printf("%s%s%n", choice, balance);
            return 3;
        } else if (answer == 4) {
            System.out.println("Goodbye.");
            System.exit(0);
        }
        return -1;
    }
}
