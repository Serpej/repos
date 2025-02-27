import java.util.Scanner;

public class TimeConverter {
    public static int FROM_MINUTES = 60;
    public static int FROM_HOURS = 3600;
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        userInput.useDelimiter(":|\\s+");

        // Declare variables
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        int sum = 0;

        // Ask user for time
        System.out.println("Enter hour, min, and seconds in the format (hh:mm:ss):");
        hours = userInput.nextInt();
        minutes = userInput.nextInt();
        seconds = userInput.nextInt();

        // Calculate hours, minutes and seconds
        
        sum = hours * FROM_HOURS;

        sum += minutes * FROM_MINUTES;

        sum += seconds;
        

        // Print result as seconds
        System.out.printf("It will be %d seconds.%n", sum);
        userInput.close();
    }
}
