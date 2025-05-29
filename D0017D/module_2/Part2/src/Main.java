import java.util.Scanner;
import java.util.Random;

/**
 * The program is a game where the player will roll 3 dice to get a total sum of
 * 12 in order to win.
 * 
 * 1. Print GAME_START.
 * 2. Enter while loop "isPlaying" and print CHOOSE_DICE.
 * 3. Validate Scanner input through If statements:
 * *    If integer, check If int = 1, 2 or 3.
 *          If no, print INVALID_ENTRY and go back to CHOOSE_DICE.
 *          If yes, check If related die already has been rolled.
 *              If yes, print ALREADY_SELECTED_DICE, and go back to CHOOSE_DICE.
 *              If no, Randomize a numner between 1-6 and store it in related die.
 *                  Add value to sum variable and print result. Set isDiceRolled to "true".
 *      If "q": Set "isPlaying" to false, Print result (win + loss) and GAME_OVER.
 *          Terminate program.
 *      If not integer or "q", print INVALID_ENTRY and go back to CHOOSE_DICE.
 * 7. Validate the number of dice with non-zero values:
 *      If one or more isDiceRolled is "false", go back to CHOOSE_DICE.
 *      If all isDiceRolled is "true", go to step 8.
 * 8. Validate win, loss or tie:
 *      If win, increment winCounter and print ROUND_WON.
 *      If loss, increment lossCounter and print ROUND_LOST.
 *      If tie, print ROUND_TIE.
 * 9. Reset dice, boolean dice variables and sum values.
 * 10. Print NEXT_ROUND.
 * 
 * @author Jesper Hagerman (hagjes-5)
 */
class Main {
    /**
     * Below static strings are there to help you get the messages correct.
     * Autograder checks for these exact strings, so it is mentioned here.
     * You can rename them if you want, and you can directly use them in your code.
     * Just make sure these exact messages are used.
     */
    static final String GAME_START = "Welcome to dice game 12. You must roll 1-3 dice and try to get the sum of 12 ...\n";
    static final String CHOOSE_DICE = "Enter which dice you want to roll [1,2,3] (exit with q):";
    static final String ROUND_WON = "You won!!";
    static final String ROUND_LOST = "You lost!!";
    static final String ROUND_TIE = "You neither won nor lost the round.";
    static final String NEXT_ROUND = "Next round!";
    static final String GAME_OVER = "Game Over!";
    static final String ALREADY_SELECTED_DICE = "Sorry, you have already rolled that dice. Try again";
    static final String INVALID_ENTRY = "Sorry, that is an invalid entry. Try again. Valid entries are 1, 2, 3, and q\n";
    static final String AMOUNT_WIN_STRING = "#win: ";
    static final String AMOUNT_LOST_STRING = " #loss: ";
    static final String SUM_STRING = " sum: ";
    static final int MAX_DICE_VALUE = 6;
    static final int MIN_DICE_VALUE = 1;
    static final int DICE_SUM_TARGET_VALUE = 12;

    public static void main(final String[] args) {

        int inputInt = 0;
        String inputQuit = "";

        int dice1Value = 0; // The value of the first dice
        boolean isDice1Rolled = false; // Whether the first dice is rolled or not

        int dice2Value = 0; // The value of the second dice
        boolean isDice2Rolled = false; // Whether the second dice is rolled or not

        int dice3Value = 0; // The value of the third dice
        boolean isDice3Rolled = false; // Whether the third dice is rolled or not

        int sum = 0; // The sum of the dice values
        int winCounter = 0; // The number of wins
        int lossCounter = 0; // The number of losses

        boolean isPlaying = true; // Whether the game is being played or not

        Scanner userInput = new Scanner(System.in);
        Random rand = new Random();

        System.out.println(GAME_START);

        while (isPlaying) {
            System.out.printf(CHOOSE_DICE);

            // Validate Scanner input through If statements:
            if (userInput.hasNextInt()) {
                inputInt = userInput.nextInt();

                switch (inputInt) {
                    case 1:
                        if (!isDice1Rolled) {

                            // Randomize value, add it to the sum and print result.
                            dice1Value = rand.nextInt(MAX_DICE_VALUE) + MIN_DICE_VALUE;
                            sum += dice1Value;
                            System.out.printf("%d %d %d" + SUM_STRING + "%d ", dice1Value, dice2Value, dice3Value, sum);
                            System.out.println(AMOUNT_WIN_STRING + winCounter + AMOUNT_LOST_STRING + lossCounter);
                            isDice1Rolled = true;
                        } else {
                            System.out.println(ALREADY_SELECTED_DICE);
                        }
                        break;
                    
                    case 2:
                        if (!isDice2Rolled) {
                            dice2Value = rand.nextInt(MAX_DICE_VALUE) + MIN_DICE_VALUE;
                            sum += dice2Value;
                            System.out.printf("%d %d %d" + SUM_STRING + "%d ", dice1Value, dice2Value, dice3Value, sum);
                            System.out.println(AMOUNT_WIN_STRING + winCounter + AMOUNT_LOST_STRING + lossCounter);
                            isDice2Rolled = true;
                        } else {
                            System.out.println(ALREADY_SELECTED_DICE);
                        }
                        break;
                    
                    case 3:
                        if (!isDice3Rolled) {
                            dice3Value = rand.nextInt(MAX_DICE_VALUE) + MIN_DICE_VALUE;
                            sum += dice3Value;
                            System.out.printf("%d %d %d" + SUM_STRING + "%d ", dice1Value, dice2Value, dice3Value, sum);
                            System.out.println(AMOUNT_WIN_STRING + winCounter + AMOUNT_LOST_STRING + lossCounter);
                            isDice3Rolled = true;
                        } else {
                            System.out.println(ALREADY_SELECTED_DICE);
                        }    
                        break;
                
                    default:
                        System.out.println(INVALID_ENTRY);
                        break;
                }

            //Terminate program if user enters "q".
            } else if (userInput.hasNext()) {
                inputQuit = userInput.next();
                if (inputQuit.equalsIgnoreCase("q")) {
                    System.out.println(AMOUNT_WIN_STRING + winCounter + AMOUNT_LOST_STRING + lossCounter);
                    System.out.println(GAME_OVER);
                    isPlaying = false;
                    userInput.close();
                    System.exit(0);
                } else {
                    System.out.println(INVALID_ENTRY);
                }
            }

            // increment counters and print win, loss or tie message.
            if (isDice1Rolled && isDice2Rolled && isDice3Rolled) {
                if (sum > DICE_SUM_TARGET_VALUE) {
                    lossCounter++;
                    System.out.printf("%d %d %d" + SUM_STRING + "%d ", dice1Value, dice2Value, dice3Value, sum);
                    System.out.println(AMOUNT_WIN_STRING + winCounter + AMOUNT_LOST_STRING + lossCounter);
                    System.out.println(ROUND_LOST);
                } else if (sum < DICE_SUM_TARGET_VALUE) {
                    System.out.printf("%d %d %d" + SUM_STRING + "%d ", dice1Value, dice2Value, dice3Value, sum);
                    System.out.println(AMOUNT_WIN_STRING + winCounter + AMOUNT_LOST_STRING + lossCounter);
                    System.out.println(ROUND_TIE);
                } else {
                    winCounter++;
                    System.out.printf("%d %d %d" + SUM_STRING + "%d ", dice1Value, dice2Value, dice3Value, sum);
                    System.out.println(AMOUNT_WIN_STRING + winCounter + AMOUNT_LOST_STRING + lossCounter);
                    System.out.println(ROUND_WON);
                }

                // Reset values
                dice1Value = 0;
                dice2Value = 0;
                dice3Value = 0;
                sum = 0;
                isDice1Rolled = false;
                isDice2Rolled = false;
                isDice3Rolled = false;

                System.out.println(NEXT_ROUND);
            }

        }
        userInput.close();
    }
}