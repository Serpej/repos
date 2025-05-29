import java.util.Scanner;
import java.util.Random;
/**
 * 
 * This is the program for Marked Assignment 2
 *
 * This is a program where you enter a value and the program
 * generates that many random numbers.
 * The output is then sorted in even and odd values,
 *  ascending order and descending order respectively.
 * 
 * 1. Enter an amount of numbers.
 * 2. Check validity and "try catch" memory error.
 * 3. Randomize numbers and store them in an array.
 * 4. Separate integers into an "even array" and an "odd array".
 * 5. Sort the even numbers in ascending order and descending order.
 * 6. Print the values, separated by a hyphen.
 *
 *  @author Jesper Hagerman Borgström (hagjes-5)
 * @version 1.0
 */
public class Main {

    static final String USER_INPUT_PROMPT = "How many random numbers in the range 0 - 999 are desired?";
    static final String RANDOM_NUMBERS_LIST_MESSAGE = "Here are the random numbers:";
    static final String RANDOM_NUMBERS_SORTED_MESSAGE = "Here are the random numbers arranged:";
    static final String NO_ODD_NUMBERS_MESSAGE = "No Odd Numbers";
    static final String NO_EVEN_NUMBERS_MESSAGE = "No Even Numbers";
    static final String INVALID_INPUT_MESSAGE = "Invalid Input";
    static final int MIN_VALUE = 1;
    static final int MAX_VALUE = Integer.MAX_VALUE;
    static final int RANDOM_MAX_VALUE = 1000;

    public static void main(final String[] args) {
        Scanner userInput = new Scanner(System.in);
        Random rand = new Random();


        int enteredValue = 0;

        int[] evenArray = null;
        int evenCount = 0;

        int[] oddArray = null;
        int oddCount = 0;

        int sumCount = 0;
        int randomNum = 0;
        int[] randomNumberArray = null;


        boolean isValid = false;
        int temp = 0;

        // Enter an amount of numbers. Check validity.
        while (!isValid) {
            System.out.print(USER_INPUT_PROMPT + " ");
            if (userInput.hasNextInt()) {
                enteredValue = userInput.nextInt();
                if (enteredValue >= MIN_VALUE && enteredValue <= MAX_VALUE) {

                     // "Try catch" memory error.
                    try {
                        randomNumberArray =  new int[enteredValue];
                        evenArray = new int[enteredValue];
                        oddArray = new int[enteredValue];
                    } catch (OutOfMemoryError e) {

                        // If the read number was to large we print an error message.
                        System.out.println(INVALID_INPUT_MESSAGE + " The entered integer was to large.");
                        continue;
                    }
                    isValid = true;
                } else {
                    System.out.println(INVALID_INPUT_MESSAGE);
                }
            } else {
                System.out.println(INVALID_INPUT_MESSAGE);
                userInput.next();
            }
        }

        // Randomize numbers and store them in an array.
        for (int i = 0; i < randomNumberArray.length; i++) {
            randomNum = rand.nextInt(RANDOM_MAX_VALUE);
            randomNumberArray[i] = randomNum;

        }

        System.out.println(); // New line for aesthetics

        // Separate integers into an "even array" and an "odd array".

        for (int num: randomNumberArray) {
            if (num % 2 == 0) {
                evenArray[evenCount] = num;
                evenCount++;
            } else {
                oddArray[oddCount] = num;
                oddCount++;
            }
        }

        sumCount = evenCount + oddCount;

        // Sort the even numbers in ascending oder
        for (int i = 0; i < evenCount; i++) {
            for (int j = 0; j < evenCount - 1; j++) {
                if (evenArray[j] > evenArray[j + 1]) {
                    temp = evenArray[j + 1];
                    evenArray[j + 1] = evenArray[j];
                    evenArray[j] = temp;
                }
            }
        }

        // Sort odd numbers in descending order.
        for (int i = 0; i < oddCount; i++) {
            for (int j = 0; j < oddCount - 1; j++) {
                if (oddArray[j] < oddArray[j + 1]) {
                    temp = oddArray[j + 1];
                    oddArray[j + 1] = oddArray[j];
                    oddArray[j] = temp;
                }
            }
        }

        // Print the result.

        System.out.println(RANDOM_NUMBERS_LIST_MESSAGE);
        for (int num : randomNumberArray) {
            System.out.printf("%d ", num);
        }
        System.out.println("\n");
        System.out.println(RANDOM_NUMBERS_SORTED_MESSAGE);
        // Fixa NO EVEN /ODD NUMBERS. Kanske med if statement?
        if (evenCount == 0) {
            System.out.printf(NO_EVEN_NUMBERS_MESSAGE);
        } else {
            for (int i = 0; i < evenCount; i++) {
                System.out.printf("%d ", evenArray[i]);
            }
        }
        System.out.printf("- ");
        if (oddCount == 0) {
            System.out.printf(NO_ODD_NUMBERS_MESSAGE);
        } else {
            for (int i = 0; i < oddCount; i++) {
                System.out.printf("%d ", oddArray[i]);
            }
        }
        System.out.println("\n");
        System.out.printf("Of the above %d numbers, %d were even and %d were odd.%n", sumCount, evenCount, oddCount);
        userInput.close();
    }
} // end of class