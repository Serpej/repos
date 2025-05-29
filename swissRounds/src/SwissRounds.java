import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class SwissRounds {
    public static int WIN_DRAW_LOSS = 1;
    public static int HALF = 2;
    public static int WIN = 3;
    public static int DRAW = 1;
    public static int LOSS = 0;
    public static void main(String[] args) throws Exception {
        Scanner userInput = new Scanner(System.in);
        userInput.useDelimiter("[\\s+]");

        String[] namesOfPlayers = null;
        int[][] statsOfPlayers = null;
        String[] matchUps = null;
        String[] playersWithByes = null;
        int noOfRounds = 0;
        int noOfPlayers = 0;
        String answer = "";
        int choice = 0;

        System.out.println("Welcome to the SwissRounds Calculator!");
        
        // Store amount of players in variable and make two arrays with that amount of memory. One for names and one for stats
        System.out.println("How many players are you:");
        noOfPlayers = inputInt(userInput); 
        statsOfPlayers = new int[noOfPlayers][WIN_DRAW_LOSS];
        namesOfPlayers = new String[noOfPlayers];

        // Add player names to the array.
        for (int i = 0; i < namesOfPlayers.length; i++) {
            System.out.println("Enter a player name or press q to choose number of rounds:");
            answer = inputString(userInput);
            if (answer.equalsIgnoreCase("q")) {
                break;
            } else {
                namesOfPlayers[i] = answer;
            }
        }

        newLine();

        // Print the players
        for (int i = 0; i < namesOfPlayers.length; i++) {
            System.out.printf("%d. %s%n", i + 1, namesOfPlayers[i]);
        }

        newLine();
        
        // Calculate numOfRounds (log2(noOfPlayers)
        noOfRounds = log2(noOfPlayers);
        
        // Ask if they want the recommended rounds or another number.
        noOfRounds = selectRounds(userInput, noOfRounds);
        System.out.printf("There will be %d round(s).%n", noOfRounds);

        newLine();

        // Decide if someone needs a bye
        if (noOfPlayers % 2 != 0) {
            playersWithByes = new String[noOfPlayers];
            playersWithByes = addBye(noOfPlayers, playersWithByes, statsOfPlayers, namesOfPlayers);
        }
        // NÅGONTING ÄR GALET HÄR, VID JÄMNT ANTAL SPELARE ÄR ARRAYEN NULL, MEN INTE VID UDDA ANTAL SPELARE.
        // Get the first pairing
        matchUps = firstPairing(noOfPlayers, namesOfPlayers, playersWithByes);

        newLine();

        while (true) {
            newLine();
            System.out.println("Enter a menu number:");
            System.out.println("------------------------------");
            System.out.println("Menu:");
            System.out.println("1. Add a match score.");
            System.out.println("2. View current score board.");
            System.out.println("3. Register walkover.");
            System.out.println("4. Next round");
            System.out.println("5. Exit program");
            System.out.println("------------------------------");
            choice = inputInt(userInput);
            switch (choice) {
                case 1:
                    addScore(statsOfPlayers, namesOfPlayers, matchUps, userInput);
                    break;
                case 2:
                    viewScore(statsOfPlayers, namesOfPlayers);
                    break;
                case 3:
                    //removePlayer(statsOfPlayers, namesOfPlayers, userInput);
                    break;
                case 4:

                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }

        //userInput.close();
    }

    /**
     * This method is used to create new lines in the program.
     */
    public static void newLine() {
        System.out.println();
    }

    /**
     * This method waits for a user input, validates it and returns a string from it.
     * @param userInput
     * @return A player name or q to quit.
     */
    public static String inputString(Scanner userInput) {

        String tempString = "";
        while (true) {
            if (!userInput.hasNext()) {
                System.out.println("Invalid input, try again:");
                userInput.nextLine();
            } else {
                break;
            }
        }
        tempString = userInput.nextLine();
        
        return tempString;
    }

    /**
    * This method waits for a user input, validates it and returns an int from it.
    * @param userInput
    * @return A number.
    */
    public static int inputInt(Scanner userInput) {
        int tempInt = 0;
        while (true) {
            if (!userInput.hasNextInt()) {
                userInput.nextLine();
                System.out.println("Invalid input. Please enter a number:");
            } else {
                tempInt = userInput.nextInt();
                if (userInput.hasNextLine()) {
                    userInput.nextLine();
                }
                break;
            }
        }    
        return tempInt;
    }

    /**
     * This method returns the number of zero bits preceding the highest-order one bit in the binary representation of an integer. 
     * By subtracting the result from 31, you can find the position of the highest-order one bit, which corresponds to the log base 2 of the integer.
     * @param number
     * @return log 2 base of the integer
     */
    public static int log2(int number) {
        return 31 - Integer.numberOfLeadingZeros(number);
    }

    /**
     * This method enters a loop to validate whether the user wants to use the recommended number of rounds or enter a custom number.
     * @param userInput
     * @param noOfRounds
     * @return The wanted number of rounds.
     */
    public static int selectRounds(Scanner userInput, int noOfRounds) {
        while (true) {
            System.out.printf("Do you want the recomended number of rounds (%d)? y/n:%n", noOfRounds);
            String answer = inputString(userInput);
            if (answer.equalsIgnoreCase("y")) {
                break;
            } else if(answer.equalsIgnoreCase("n")){
                System.out.println("Enter a custom number of rounds:");
                noOfRounds = inputInt(userInput);
                break;
            } else {
                System.out.println("You must enter either y or n to continue:");
            }
        }
        return noOfRounds;
    }


    /**
     * This method pairs the names within the namesOfPlayers array two by two.
     * If this is a name left out, that player gets a buy.
     * Lastly the method prints the pairs and the player with the buy.
     * 
     * @param playersWithByes
     * @param namesOfPlayers
     * @param noOfPlayers
     * @return A shuffled copy of the name array, to use as a match up.
     */
    public static String[] firstPairing(int noOfPlayers, String[] namesOfPlayers, String[] playersWithByes) {
        Random rand = new Random();
        String[] tempNameArray = new String[namesOfPlayers.length - 1];

        // If there is an odd number of players, check for byes.
        if (noOfPlayers % 2 != 0) {
            int tempIndex = 0;
            for (int i = 0; i < namesOfPlayers.length; i++) {
                boolean isInPlayersWithByes = false;
    
                // Check if current name is in playersWithByes
                for (String bye : playersWithByes) {
                    if (bye != null && bye.equals(namesOfPlayers[i])) {
                        isInPlayersWithByes = true;
                        break;
                    }
                }
    
                // If the name is not in playersWithByes, add it to tempArray and increase the index.
                if (!isInPlayersWithByes) {
                    tempNameArray[tempIndex++] = namesOfPlayers[i];
                }
            }
        }

        // Shuffle the indexes using Fisher-Yates shuffle. 
        for (int i = 0; i < tempNameArray.length; i++) {
            int randomIndex =  rand.nextInt(tempNameArray.length);
            String temp = tempNameArray[randomIndex];
            tempNameArray[randomIndex] = tempNameArray[i];
            tempNameArray[i] = temp;
        }

        // Pair the names
        System.out.println("Pairings for the first match:");

        newLine();

        int bulletListCount = 0;
        for (int i = 0; i < tempNameArray.length - 1; i += 2) {
            bulletListCount++;
            System.out.printf("%d. %s VS %s%n", bulletListCount, tempNameArray[i], tempNameArray[i + 1]);
        }
        newLine();        
        return tempNameArray;
    }
    /**
     * This method checks if the number of players are odd, and assigns a bye to a player
     * not currently in the playersWithByes array.
     * @param matchUps
     * @param noOfPlayers
     * @param playersWithByes
     * @param statsOfPlayer
     * @return Returns the array with names of players who has a bye.
     */
    public static String[] addBye(int noOfPlayers, String[] playersWithByes, int[][] statsOfPlayers, String[] namesOfPlayers) {

        // Search for a player without a bye.
        for (int i = namesOfPlayers.length - 1; i >= 0; i--) {
            if (playersWithByes[i] == null || !playersWithByes[i].equals(namesOfPlayers[i])) {

                // Assign a bye to a player not given one previously.
                playersWithByes[i] = namesOfPlayers[i];
                System.out.printf(" Player with bye: %s%n", playersWithByes[i]);


                // Find the player in the original array and give them points for the bye.
                for (int j = 0; j < namesOfPlayers.length; j++) {
                    if (namesOfPlayers[j].equals(playersWithByes[i])) {
                        statsOfPlayers[j][0] = WIN;
                        break;
                    }
                }
                break;
            }
        }        
        return playersWithByes;
    }

    /**
     * This method prints the current matchup , then asks for a name. If it finds that name in the matchups, it asks for their match outcome.
     * @param statsOfPlayers
     * @param namesOfPlayers
     * @param matchUps
     * @param userInput
     * @return returns statsOfPlayers array with a new score in it.
     */
    public static int[][] addScore(int[][] statsOfPlayers, String[] namesOfPlayers, String[] matchUps, Scanner userInput) {
        newLine();
        int bulletListCount = 0;
        boolean found = false;
        
        // Print Matchups again
        for (int i = 0; i < matchUps.length - 1; i += 2) {
            bulletListCount++;
            System.out.printf("%d. %s VS %s%n", bulletListCount, matchUps[i], matchUps[i + 1]);
        }

        
        System.out.println("Enter a player name:");
        String playerName = inputString(userInput);

        // Find the player
        for (int i = 0; i < matchUps.length; i++) {
            if (playerName.equals(matchUps[i])) {
                System.out.printf("Enter match score for %s:%n", playerName);
                int score = inputInt(userInput);

                // Add the score to the statsOfPlayer array
                for (int j = 0; j < namesOfPlayers.length; j++) {
                    if (playerName.equals(namesOfPlayers[j])) {
                        statsOfPlayers[j][0] += score ;
                        System.out.printf("The current score for %s is now %d.", playerName, statsOfPlayers[j][0]);
                        found = true;
                        break;
                    }
                }
            }
        }

        // if the player wasn't found, print error message.
        if (!found) {
            System.out.println("Could't find the name.");
        }
        return statsOfPlayers;
    }

    /**
     * This method makes a copy of the stats and the names, then it sorts them both according to the highest
     * scores of the players and print's them.
     * @param statsOfPlayers
     * @param namesOfPlayers
     */
    public static void viewScore(int[][] statsOfPlayers, String[] namesOfPlayers) {

        // Step 1: Make a copy of statsOfPlayers and namesOfPlayers.
        int[][] tempScores = Arrays.copyOf(statsOfPlayers, statsOfPlayers.length);
        for (int i = 0; i < tempScores.length; i++) {
                tempScores[i] = Arrays.copyOf(statsOfPlayers[i], statsOfPlayers[i].length);
        }
        String[] tempNames = Arrays.copyOf(namesOfPlayers, namesOfPlayers.length);

        // Step 2: Sort them according to the highest score of statsOfPlayers.
        for (int i = 0; i < tempScores.length - 1; i++) {
            for (int j = 0; j < tempScores.length -1  - i; j++) {
                if (tempScores[j][0] < tempScores[j + 1][0]) {
                    int[] scoreHolder = tempScores[j];
                    tempScores[j] = tempScores[j + 1];
                    tempScores[j + 1] = scoreHolder;
    
                    // Swap names
                    String nameHolder = tempNames[j];
                    tempNames[j] = tempNames[j + 1];
                    tempNames[j + 1] = nameHolder;
                }
            }
        }
        // Step 3 (Optional): Calculate tiebreakers.
        
        // Step 4: Print the score.
        newLine();
        System.out.println("----------SCOREBOARD----------");
        for (int i = 0; i < tempScores.length; i++) {
            System.out.printf("%s %d%n", tempNames[i], tempScores[i][0]);
        }

    
    }

    // public static void removePlayer(int [][]statsOfPlayers, String[] namesOfPlayers, Scanner userInput) {
    //     newLine();
    //     System.out.println("Enter a player name to remove from the tournament:");
    //     String forfeitPlayer = inputString(userInput);

    //     // Find the index of the player to remove
    //     //int indexToRemove = 
    //     for (String Player : namesOfPlayers) {
    //         if (namesOfPlayers[i] != null && Player.equalsIgnoreCase(forfeitPlayer)) {
    //             // Remove player from names of players and from stats of players
    //             // Create a new array to use instead of namesOfPlayers and statsOfPlayers
    //         }
    //     }
    // }
}
