import java.util.Scanner;

public class RollTheDice {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        // Declare variables
        int desiredRolls = 0;
        int currentThrow = 0;
        int noOfOnes = 0;
        int noOfTwos = 0;
        int noOfThrees = 0;
        int noOfFours = 0;
        int noOfFives = 0;
        int noOfSixes = 0;

        // Ask for number of rolls
        System.out.println("Enter amount of times to roll the dice:");
        desiredRolls = userInput.nextInt();

        // Create a loop with if statement, print and store result.
        for (int noOfRolls = 0; noOfRolls < desiredRolls; noOfRolls++) {
            currentThrow = (int) (Math.random() * 6) + 1;
            System.out.printf(currentThrow + " ");

            if (currentThrow == 1) {
                noOfOnes++;
            } else if (currentThrow == 2) {
                noOfTwos++;
            } else if (currentThrow == 3) {
                noOfThrees++;
            } else if (currentThrow == 4) {
                noOfFours++;
            } else if (currentThrow == 5) {
                noOfFives++;
            } else {
                noOfSixes++;
            }
        }

        // Print the number of # equal to value in variables.

        //Print number of ones as "#"
        System.out.printf("%n1: ");

        for (int i = 0; i < noOfOnes; i++) {
            System.out.printf("#");
        }

        //Print number of twos as "#"
        System.out.printf("%n2: ");

        for (int i = 0; i < noOfTwos; i++) {
            System.out.printf("#");
        }

        //Print number of threes as "#"
        System.out.printf("%n3: ");

        for (int i = 0; i < noOfThrees; i++) {
            System.out.printf("#");
        }

        //Print number of fours as "#"
        System.out.printf("%n4: ");

        for (int i = 0; i < noOfFours; i++) {
            System.out.printf("#");
        }

        //Print number of fives as "#"
        System.out.printf("%n5: ");

        for (int i = 0; i < noOfFives; i++) {
            System.out.printf("#");
        }

        //Print number of sixes as "#"
        System.out.printf("%n6: ");

        for (int i = 0; i < noOfSixes; i++) {
            System.out.printf("#");
        }
        System.out.print("%n");
        userInput.close();
        System.exit(0);
    }
}
