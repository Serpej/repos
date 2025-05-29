import java.util.Scanner;

public class TemperatureWithArray {
    public static void main(String[] args) {
     	// Initialization for the scanner
        Scanner userInput = new Scanner(System.in); 
		
		// Declare variables that would be needed
        int noOfDays = 0;
        int day = 0;
        int daysAboveAverage = 0;
        double sum = 0.0;
        double max = 0.0;
        double min = 0.0;
        double average = 0.0;
        double temp = 0.0;
        double total = 0.0;
		double[] tempThatDay;
        String lineString = "";

		// Read the number of days from the user
        System.out.println("Number of days in the month?");
        lineString = userInput.nextLine(); // Read the userInput as a string
        noOfDays = Integer.parseInt(lineString);
		
		// Initialize variables
		tempThatDay = new double[noOfDays + 1];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        sum = 0;
		
		// Processing and Calculating
        for (day = 1; day < tempThatDay.length; day++) {
            System.out.println("Enter the temperature of day " + day);
            temp = userInput.nextInt();
            userInput.nextLine();
            tempThatDay[day] = temp;
            sum += total + temp;
            if (temp < min) {
                min = temp;
            } else if (temp > max) {
                max = temp;
            }
        }
        average = sum / noOfDays;
        for (int i = 1; i < tempThatDay.length; i++) {
            if (tempThatDay[i] > average) {
                daysAboveAverage++;
            }
        }
        System.out.println();

		// Printing with two decimal places
        for (int i = 1; i < tempThatDay.length; i++) {
            System.out.printf("day %d had a temperature of %.0f C%n", i, tempThatDay[i]);
        }
        System.out.println(); //new line for esthetics
        System.out.printf("The maximum temperature of the month was %.0f%n", max);
        System.out.printf("The min temperature of the month was %.0f%n", min);
        System.out.printf("The average temperature of the month was %.2f%n", average);
        System.out.printf("%d days was above average temperature this month.%n", daysAboveAverage);
        userInput.close();
 
    }
}
