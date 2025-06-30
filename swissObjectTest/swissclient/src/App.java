import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner userInput = new Scanner(System.in);
        int noOfPlayers = 0;
        String playerName = "";

        Player player = new Player();

        System.out.println("Enter number of players: ");
        noOfPlayers = userInput.nextInt();
        userInput.nextLine();

        ArrayList<Player> players = new ArrayList<Player>();

        for (int i = 0; i < noOfPlayers; i++) {
            System.out.println("Enter name of player: ");
            playerName = userInput.nextLine();
            Player newPlayer = new Player(playerName);
            players.add(newPlayer);
        }

        for(int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i));
        }
        
        userInput.close();
    }
}
