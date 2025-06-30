import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class SwissRoundsWithObjects {

    public static int WIN_DRAW_LOSS = 1;
    public static int HALF = 2;
    public static int WIN = 3;
    public static int DRAW = 1;
    public static int LOSS = 0;
    private static int currentRound = 0;
    private static boolean finalScore = false;

    public static void main(String[] args) throws Exception {
        Scanner userInput = new Scanner(System.in);
        userInput.useDelimiter("[\\s+\\-]");

        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Player> matchUps = new  ArrayList<Player>();
        int noOfRounds = 0;
        int noOfPlayers = 0;
        String playerName = "";
        int choice = 0;

        System.out.println("Welcome to the SwissRounds Calculator!");
        

        // Add player names to the array.
        while (true) {
            System.out.println("Enter a player name or press q to choose number of rounds:");
            playerName = inputString(userInput);
            
            if (playerName.equalsIgnoreCase("q")) {
                break;
            } else {
                Player newPlayer = new Player(playerName);
                players.add(newPlayer);
                System.out.println(newPlayer + " was added to the match.");
                newLine();
            }
        }

        noOfPlayers = players.size();

        newLine();

        // Print the players
        for (int i = 0; i < players.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, players.get(i));
        }

        newLine();
        
        // Calculate numOfRounds (log2(noOfPlayers)
        noOfRounds = log2(noOfPlayers);
        
        // Ask if they want the recommended rounds or another number.
        noOfRounds = selectRounds(userInput, noOfRounds);
        System.out.printf("There will be %d round(s).%n", noOfRounds);

        newLine();

        // Get the first pairing
        matchUps = firstPairing(players);

        newLine();

        while (!finalScore) {
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
                
                    addScore(matchUps, players, userInput);
                    break;
                case 2:

                    viewWinScore(players);
                    break;
                case 3:
                    removePlayer(userInput, players, matchUps);
                    break;
                case 4:
                    // Den här behöver fixas med! 
                    // Det är också något skumt med counten på mängden rundor.
                    
                    nextRound(players, matchUps, noOfRounds);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
        userInput.close();
        System.exit(0);
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
     * This method takes an input and validates it to be a score (to integers with either a space or a hyphen in between).
     * Then it adds the score to the player.
     * @param players
     * @param userInput
     * @param playerIndex
     * @param playerName
     */
    public static void scoreInput(ArrayList<Player> players, Scanner userInput, int playerIndex, String playerName) {
                String tempInput= "";
        while (true) {
            System.out.println("Enter the score for " + playerName + " ('2-0'): ");
             tempInput = userInput.nextLine();
            if (tempInput.matches("\\d[ -]\\d")) {
                String[] parts = tempInput.split("[ -]");
                int wins = Integer.parseInt(parts[0]);
                int losses = Integer.parseInt(parts[1]);

                // increases wins.
                if (wins >= 1) {
                    players.get(playerIndex).setPlayerScore(1, losses, 0);
                } else {
                    players.get(playerIndex).setPlayerScore(wins, losses, 0);
                }
                break;

            } else if (tempInput.matches("\\d[ -]\\d[ -]\\d")) {
                String[] parts = tempInput.split("[ -]");
                int wins = Integer.parseInt(parts[0]);
                int losses = Integer.parseInt(parts[1]);
                int draw = Integer.parseInt(parts[2]);
                players.get(playerIndex).setPlayerScore(wins, losses, draw);
                break;
            } else {
                System.out.println("Invalid input. Please enter a score (for example '2-1' or '1-1-1'): ");
            }
        }
    }

    /**
     * Shuffles the Array List Fisher-Yates style. 
     * @param players
     * @return Array list shuffled.
     */
    public static ArrayList<Player> shufflePlayers(ArrayList<Player> players) {
        Collections.shuffle(players);

        return players;
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
     * This method pairs the names within players Array list after checking for byes.
     * Lastly the method prints the pairs and the player with the buy.
     * 
     * @param ArrayList<Player> players
     * @return A shuffled copy of the array list without the bye player (if there is one), to use as a match up.
     */
    public static ArrayList<Player> firstPairing(ArrayList<Player> players) {
        ArrayList<Player> firstPairing = new ArrayList<Player>();
        Player playerWithBye = new Player();
        
        // Round count to know when to stop
        SwissRoundsWithObjects.currentRound++;

        shufflePlayers(players);

        addBye(players);
        
        // Add all players without a bye to a new Arraylist.
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            if (!p.hasBye()) {
                firstPairing.add(p);
            } else {
                playerWithBye = p;
            }
        }

        // Pair the names
        System.out.println("Pairings for the first match:");

        newLine();

        int bulletListCount = 0;
        for (int i = 0; i < firstPairing.size() - 1; i += 2) {
            bulletListCount++;
            System.out.printf("%d. %s VS %s%n", bulletListCount, firstPairing.get(i), firstPairing.get(i + 1));
        }

        if (players.size() % 2 != 0) {
            System.out.println(playerWithBye + " got a bye.");
        }
        currentRound++;
 
        newLine();       
        return firstPairing;
    }

    /**
     * This method assigns a bye to a player that currently doesnt have one.
     * @param players
     */
    public static Player addBye(ArrayList<Player> players) {
        Player playerWithBye = null;
        //check if there is an odd number of players.
        if (players.size() % 2 != 0) {

            shufflePlayers(players);

            // Search for a player without a bye.
            for (int i = 0; i < players.size(); i++) {
                Player p = players.get(i);
                if (!p.hasBye()) {
                    p.setBye(true);
                    p.setPlayerScore(1, 0, 0);
                    playerWithBye= p;
                    break;
                    
                }
            }
        }
        return playerWithBye;
    }

    /**
     * This method prints the current matchup , then asks for a name. If it finds that name in the matchups, it asks for their match outcome.
     * @param players
     * @param matchUps
     * @param userInput
     * @return returns statsOfPlayers array with a new score in it.
     */
    public static void addScore(ArrayList<Player> matchUps, ArrayList<Player> players, Scanner userInput) {
        newLine();
        int bulletListCount = 0;
        boolean found = false;
        
        // Print Matchups again
        for (int i = 0; i < matchUps.size() - 1; i += 2) {
            bulletListCount++;
            System.out.printf("%d. %s VS %s%n", bulletListCount, matchUps.get(i), matchUps.get(i + 1));
        }

        
        System.out.println("Enter a player name:");
        String playerName = inputString(userInput);

        // Find the player
        for (int i = 0; i < matchUps.size() -1; i += 2) {
            Player p1 = matchUps.get(i);
            Player p2 = matchUps.get(i + 1);

            if (playerName.equals(p1.getName())) {

                // Add the score for p1.
                for (int j = 0; j < players.size(); j++) {
                    ;
                    if (playerName.equals(players.get(j).getName())) {
                        scoreInput(players, userInput, j, playerName);
                        found = true;
                        break;
                    }
                }

                // Add the opponents to players.
                p1.addOpponent(p2);
                p2.addOpponent(p1);
                break;

            } else if (playerName.equals(p2.getName())) {

                // Add score for p2.
                for (int j = 0; j < players.size(); j++) {
                    if (playerName.equals(players.get(j).getName())) {
                        scoreInput(players, userInput, j, playerName);
                        found = true;
                        break;
                    }
                }

                p2.addOpponent(p1);
                p1.addOpponent(p2);
                break;
            }
        }

        // if the player wasn't found, print error message.
        if (!found) {
            System.out.println("Could't find the name.");
        }
    }

    /**
     * This method makes a copy of the stats and the names, then it sorts them both according to the highest
     * scores of the players and print's them.
     * @param players
     */
    public static void viewWinScore(ArrayList<Player> players) {

        // Step 2: Sort them according to the highest winScore.
        players.sort((a, b) -> Integer.compare(b.getWinScore(), a.getWinScore()));
        // Step 3 (Optional): Calculate tiebreakers.
        
        // Step 4: Print the score.
        newLine();
        System.out.println("----------SCOREBOARD----------");
        for (int i = 0; i < players.size(); i++) {
            System.out.printf("%s %d%n", players.get(i).getName(), players.get(i).getWinScore());
        }
    
    }

    /**
     * This method takes user input as a string and searches for a player name. 
     * If it's found, it removes the name from matchUps and players ArrayLists, and gives the opponent a win.
     * @param userInput
     * @param players
     * @param matchUps
     */
    public static void removePlayer(Scanner userInput, ArrayList<Player> players, ArrayList<Player> matchUps) {
        System.out.println("Enter a player that will be removed from the tournament: ");
        String playerName = inputString(userInput);
        boolean found = false;
        
        
        
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            Player playerToRemove = null;
            int opponentIndex = 0;
            if (playerName.equals(p.getName())) {
                
                // Search if they are in current matchUps 
                if (matchUps.contains(p)) {
                    for (int j = 0; j < matchUps.size(); j++) {
                        if (playerName.equals(matchUps.get(j).getName())) {
                            
                            playerToRemove = matchUps.get(j);

                            // Depending on their index, their opponent is either before or after them in the ArrayList.
                            if (j % 2 == 0) {
                                opponentIndex = j + 1;
                            } else if (j % 2 != 0) {
                                opponentIndex = j - 1;
                            }

                            // Removes player form matchUps and give the opponent a win.
                            matchUps.get(opponentIndex).setPlayerScore(1, 0, 0);
                            matchUps.remove(playerToRemove);
                        }
                    }
                }
                System.out.println(p + " was removed from the tournament.");
                players.remove(p);
                found = true;
            } 
    
        }

        if (!found) {
            System.out.println("Couldn't find player.");
        }
    }

    /**
     * This method divides the players into winner or losing brackets and then checks the number of rounds.
     * If there is another round it matchmakes those with a separate method. Otherwise it prints the final score.
     * @param players
     * @param matchUps
     * @param noOfRounds
     */
    public static void nextRound(ArrayList<Player> players, ArrayList<Player> matchUps, int noOfRounds) {
        ArrayList<Player> winnerBracket = new ArrayList<>();
        ArrayList<Player> losingBracket = new ArrayList<>();
        matchUps.removeAll(matchUps);
        int bulletListCount = 0;

        
        if (currentRound < noOfRounds) {
            SwissRoundsWithObjects.currentRound++;

            Player playerWithBye = addBye(players);

            for (int i = 0; i < players.size(); i++) {
                Player p = players.get(i);
                if (p.equals(playerWithBye)) {
                    continue;
                } else {
                    if (p.getLosses() == 0) {
                        winnerBracket.add(p);
                    } else {
                        losingBracket.add(p);
                    }
                }
            }

            System.out.println("Match ups for ound number " + currentRound + " are:");

            newLine();

            matchMakePlayers(winnerBracket, matchUps);
            matchMakePlayers(losingBracket, matchUps);

            for (int i = 0; i < matchUps.size() -1; i += 2) {
                bulletListCount++;
                System.out.printf("%d. %s VS %s%n", bulletListCount, matchUps.get(i), matchUps.get(i + 1));
            }
        } else {
            newLine();
            System.out.println("Here is the final score!");
            viewWinScore(players);
            SwissRoundsWithObjects.finalScore =  true;
        }
    }
/**
 * This method takes an Arraylist, iterates through the players and finds a pair that havent yet met eachother.
 * @param Bracket
 * @param matchUps
 */
    public static void matchMakePlayers(ArrayList<Player> Bracket, ArrayList<Player> matchUps) {
        ArrayList<Player> tempBracket = new ArrayList<>(Bracket);

        while (tempBracket.size() > 1) {
            Player currentPlayer = tempBracket.get(0);

            for (int i = 1; i < tempBracket.size(); i++) {
                Player opponent = tempBracket.get(i);
                if (!currentPlayer.getOpponentsPlayed().contains(opponent)) {
                    
                    // Found a new opponent.
                    matchUps.add(currentPlayer);
                    matchUps.add(opponent);

                    // Remove players from the matchmaking system of the round.
                    tempBracket.remove(i); 
                    tempBracket.remove(0);
                    break;
                }
            }
        }
    }

}

