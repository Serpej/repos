import java.util.Scanner;
/**
 * A simple program to tell if your water is boiling
 */
public class Task42 {
    public static int BOILING_POINT = 100;
    public static int MIN_TEMP = 1;
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        int temp = 0;
  
        System.out.println("Enter a temperature:");
        
        if (userInput.hasNextInt()) {
            temp = userInput.nextInt();
            if (temp == BOILING_POINT) {
                System.out.println("The water is boiling!");
                userInput.close();
                System.exit(0);
            } else if (temp >=  MIN_TEMP && temp < 100)  {
                System.out.println("The power is on.");
                System.out.println("The water is " + temp + " degrees.");
                userInput.close();
                System.exit(0);
            } else if (temp > BOILING_POINT) {
                System.out.println("Error! The water is temperature can't exceed 100 degrees");
                userInput.close();
                System.exit(0);
            } else {
                System.out.println("The power supply is off.");
                userInput.close();
                System.exit(0);
            }
        }



    }
}
