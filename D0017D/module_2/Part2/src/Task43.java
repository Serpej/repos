import java.util.Scanner;
/**
 * A kiosk sells scoops of ice cream in variants one, two, or three scoops. 
 * A girl who wants to buy one of the variants has a limited weekly allowance. 
 * She can therefore buy one of the three variants only if she has enough money. 
 * Create a program that gives the girl's weekly allowance, and the prices below show which variants the girl can buy.
 * Your program when a weekly allowance is entered, can print which option she can buy.
 */
public class Task43 {
    public static int ONE_SCOOP = 5;
    public static int TWO_SCOOPS = 10;
    public static int THREE_SCOOPS = 15;
    public static int DIRT_POOR = 4;
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int allowance = 0;
        boolean isvalid = false;

            while (!isvalid) {
                System.out.println("How much allowance do you give");
                if (userInput.hasNextInt()) {
                    allowance = userInput.nextInt();
                    if (allowance >= THREE_SCOOPS) {
                        System.out.println("She can afford three scoops of ice cream");
                        userInput.close();
                        isvalid = true;
                    } else if (allowance >= TWO_SCOOPS) {
                        System.out.println("She can afford two scoops of ice cream");
                        userInput.close();
                        isvalid = true;
                    } else if (allowance >= ONE_SCOOP) {
                        System.out.println("She can afford one scoop of ice cream");
                        userInput.close();
                        isvalid = true;
                    } else {
                        System.out.println("He can't afford ice cream");
                        userInput.close();
                        isvalid = true;
                    }
                } else {
                    userInput.nextLine();
                    System.out.println("invalid input, enter a number:");
            }
            
        }
    }
}
