public class Player {
    private String name;
    private int win;
    private int draw;
    private int loss;
    private boolean bye;

    Player() {
        name = "unknown";
        win = 0;
        draw = 0;
        loss = 0;
        bye = false;
    }

    Player(String name) {
        this.name = name;
        win = 0;
        draw = 0;
        loss = 0;
        bye = false;
    }

    public void setPlayerName(String name) {
        this.name = name;
    }

    public void setPlayerScore(int win, int loss, int draw) {
        this.win = win;
        this.draw = draw;
        this.loss = loss;
    }

    public int getPlayerScore() {
        int multiplier = 3;
        return win * multiplier;
    }

    public boolean setBye(boolean bye) {
        this.bye = bye;
        return bye;
    }

    public void getPlayerinfo() {
        System.out.println("Name: " + name);
        System.out.println("Wins: " + win);
        System.out.println("Draws: " + draw);
        System.out.println("Losses: " + loss);
        System.out.println("Bye: " + bye);
    }

    public String toString() {
        String s =  "Player Name: " + name + " Wins: " + win + " Draws: " + draw + " Losses: " + loss + " bye: " + bye;
        return s;
    }
}
