
import java.util.Scanner;

/**
 * For a particular program, you want to use an entered time value to tell whether it is lunchtime or not.
 *  Lunchtime is defined as the interval between the times 1200 -1300.
 */
public class Task44 {
    public static int BEFORE_LUNCH = 1159;
    public static int AFTER_LUNCH = 1301;
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int time = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.println("Enter a time in 24-hour format (HHMM) >");

            if (userInput.hasNextInt()) {
                time = userInput.nextInt();
                // if (time > BEFORE_LUNCH && time < AFTER_LUNCH) {
                //     System.out.println("Lunch time!");
                // } else {
                //     System.out.println("Not lunch time.. :(");
                // }
                if (time > BEFORE_LUNCH) {
                    if (time < AFTER_LUNCH) {
                        System.out.println("Lunch time!");
                    } else {
                        System.out.println("Not lunch time :(");
                    }
                }
            } else {
                System.out.println("Invalid input");
            }
            
        }
    
    }
}

