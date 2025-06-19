import java.util.ArrayList;

public class Player {
    private String name;
    private int wins;
    private int draws;
    private int losses;
    private boolean bye;
    private int multiplier = 3;

    private ArrayList<Player> opponentsPlayed = new ArrayList<Player>();

    Player() {
        name = "unknown";
        bye = false;
    }

    Player(String name) {
        this.name = name;
        bye = false;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }
    public void setWins(int wins) {
        this.wins += wins;
    }

    public int getWinScore() {
        return (wins * multiplier) + draws;
    }

    public int getDraws() {
        return draws;
    }
    public void setDraws(int draws) {
        this.draws += draws;
    }

    public int getLosses() {
        return losses;
    }
    public void setLosses(int losses) {
        this.losses += losses;
    }

    public boolean hasBye() {
        return bye;
    }
    public void setBye(boolean bye) {
        this.bye = bye;
    }

    public void setPlayerScore(int wins, int losses, int draws) {
        this.wins += wins;
        this.draws += draws;
        this.losses += losses;  
    }

    public void getPlayerinfo() {
        System.out.println("Name: " + name);
        System.out.println("wins: " + wins);
        System.out.println("draws: " + draws);
        System.out.println("losses: " + losses);
        System.out.println("Bye: " + bye);
    }

    public String toString() {
        String s = name;
        return s;
    }

    public ArrayList<Player> getOpponentsPlayed() {
        return opponentsPlayed;
    }

    public void setOpponentsPlayed(ArrayList<Player> opponentsPlayed) {
        this.opponentsPlayed = opponentsPlayed;
    }


    public void addOpponent(Player opponent) {
        this.opponentsPlayed.add(opponent);
    }

}

