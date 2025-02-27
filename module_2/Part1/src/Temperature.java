import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
     	// Initialization for the scanner
        Scanner userInput = new Scanner(System.in); 
		
		// Declare variables that would be needed
        int noOfDays = 0;
        int day = 0;
        double sum = 0.0;
        double max = 0.0;
        double min = 0.0;
        double average = 0.0;
        double temp = 0.0;
        double total = 0.0;
		
		// Read the number of days from the user
        System.out.println("Number of days in the month?");
        noOfDays = userInput.nextInt();
        userInput.nextLine();// Clear the input buffer
		
		// Initialize variables
		day = 1;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        sum = 0;
		
		// Processing and Calculating
		while (day <= noOfDays) {
            System.out.println("Enter the temperature of day " + day);
            
            temp = userInput.nextInt();
            userInput.nextLine();
            
            sum += total + temp;

            if (temp < min) {
                min = temp;
            } else if (temp > max) {
                max = temp;
            }

            day++;
        }

        average = sum / noOfDays;
				
		// Printing with two decimal places
        System.out.printf("The maximum temperature of the month was %.0f%n", max);
        System.out.printf("The min temperature of the month was %.0f%n", min);
        System.out.printf("The maximum temperature of the month was %.2f%n", average);
 
    }
}
