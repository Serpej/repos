import java.util.Scanner;

public class RolltheDiceArrayexercise  {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        // Declare variables
        int desiredRolls = 0;
        int currentThrow = 0;
        int[] frequency = new int[7];
        

        // Ask for number of rolls
        System.out.println("Enter amount of times to roll the dice:");
        desiredRolls = userInput.nextInt();

        // Create a loop with if statement, print and store result.
        for (int noOfRolls = 0; noOfRolls < desiredRolls; noOfRolls++) {
            currentThrow = (int) (Math.random() * 6) + 1;
            System.out.printf(currentThrow + " ");
            frequency[currentThrow] =  frequency[currentThrow] +1;
        }

        // Print the number of # equal to value in variables.
     
        for (int diceNr = 1; diceNr <= 6; diceNr++) {
            System.out.printf("%n" + diceNr + ":");

            // For each number, print one "#" for every time it was rolled.
            for (int i = 0; i < frequency[diceNr]; i++) {
                System.out.print("#");
            }
        }
        System.out.println();
        userInput.close();
        System.exit(0);
    }
}
