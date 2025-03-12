import java.util.Scanner;

public class MultidimentionalArrays33 {
    static final int ROWS = 1;
    static final int COLUMNS = 5;
    static final String[] C_VALUES = {"White", "Red", "Green", "Black", "Blue"};
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int[][] numOfDecks = new int[ROWS][COLUMNS];
        



        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.printf("Enter Marks for %s, on row %d:%n ", C_VALUES[j], (j + 1));
                if (userInput.hasNextInt()) {
                    numOfDecks[i][j] = userInput.nextInt();
                } else {
                    System.out.println("Invalid input.");
                    userInput.next();
                }
            }
        }

        System.out.printf("%10s %10s %10s %10s %10s %n","White", "Red", "Green", "Black", "Blue");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.printf("%10s ", numOfDecks[i][j]);
            }
            System.out.println();
        }
    }
}
