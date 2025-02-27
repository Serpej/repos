
import java.util.Scanner;

public class Timeprogram {

    final static int GET_HOURS = 3600;
    final static int GET_MINUTES_AND_SECONDS = 60;
    public static void main(String[] args) {
        int seconds = 0;
        int hours = 0;
        int minutes = 0;
        int remainingSeconds = 0;
        Scanner in = new Scanner(System.in);

        // Ask for number of seconds and scan for answer.
        System.out.print("How many seconds? ");
        seconds = in.nextInt();

        // Calculate time
        hours = seconds / GET_HOURS;
       minutes = (seconds / GET_MINUTES_AND_SECONDS) - (hours * GET_MINUTES_AND_SECONDS);
        remainingSeconds = seconds % GET_MINUTES_AND_SECONDS;
        
        // Print calculation
        System.out.printf("That is %d hours, %d minutes and %d seconds%n", hours, minutes, remainingSeconds);
    

    }
}