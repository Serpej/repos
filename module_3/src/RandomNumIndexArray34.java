import java.util.Scanner;
import java.util.Random;

public class RandomNumIndexArray34 {
    static final int MAX_ARRAY_SIZE = 51;
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Random rand = new Random();

        int arraySize = 0;
        int[] arrayOfNums;
        int searchValue = 0;
        int index = -1;

        System.out.println("Enter a number for the array (max 50): ");

        // Input Validation
        if (userInput.hasNextInt()) {
            arraySize = userInput.nextInt();
            if (arraySize < MAX_ARRAY_SIZE && arraySize > 0) {
                System.out.printf("Your array now contains %d elements. %n", arraySize);
                System.out.println();
            } else {
                System.out.println("Invalid number. Program terminated.");
                userInput.close();
                System.exit(0);
            }
        } else {
            System.out.println("you need to enter an integer. Program terminated.");
            userInput.close();
            System.exit(0);
        }
        arrayOfNums = new int[arraySize];

        // Fill the array with generated numbers.
        for (int i = 0; i < arrayOfNums.length; i++) {
            arrayOfNums[i] = rand.nextInt(101);
        }

        // Print the array.
        System.out.printf("%s %s %n","Index", "Value");
        for (int i = 0; i < arrayOfNums.length; i++) {
            System.out.printf("%-5d %-5d %n", i, arrayOfNums[i]);
        }
        System.out.println();
        System.out.println("What number would you want to search for: ");
        
        // Input Validation
        if (userInput.hasNextInt()) {
            searchValue = userInput.nextInt();
            
            // Search for given value
            for (int i = 0; i < arrayOfNums.length; i++) {
                if (arrayOfNums[i] == searchValue) {
                    index = i;
                    break;
                }
            }
        } else {
            System.out.println("you need to enter an integer. Program terminated.");
            userInput.close();
            System.exit(0);
        }
        // If value was found, print
        if (index == -1) {
            System.out.println("The value wasn't found.Program terminated.");
            userInput.close();
            System.exit(0);
        }

        // Print the result
        System.out.printf("The value was found at index %d.%n", index);
        userInput.close();
        System.exit(0);
    }
}
