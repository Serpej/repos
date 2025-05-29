import java.util.Scanner;

public class methodTemperatureexcersice {
public static void main(String[] args) {
     	// Initialization for the scanner
        Scanner userInput = new Scanner(System.in); 
		
		// Declare variables that would be needed
        int noOfDays = 0;
        int daysAboveAverage = 0;
        double sum = 0.0;
        double max = 0.0;
        double min = 0.0;
        double average = 0.0;
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
        enterTemp(tempThatDay);
        sum = addAll(tempThatDay);
        min = minTemp(tempThatDay);
        max = maxTemp(tempThatDay);
        average = average(sum, noOfDays);
        daysAboveAverage = warmerDays(tempThatDay, average);

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
    // Takes user input and puts each temperature into each day in the array.
    public static void enterTemp (double[] tempThatDay) {
        Scanner userInput = new Scanner(System.in); 
        double temp = 0.0;
        for (int day = 1; day < tempThatDay.length; day++) {
            System.out.println("Enter the temperature of day " + day);
            temp = userInput.nextInt();
            userInput.nextLine();
            tempThatDay[day] = temp;
        }
        userInput.close();
    }
    // Sums up all the temperatures
    public static double addAll(double[] tempThatDay) {
        double sum = 0.0;
        for (int day = 1; day < tempThatDay.length; day++) {
            sum += tempThatDay[day];
        }
        return sum;
    }
    // Calculates the minimum temperature within the array.
    public static double minTemp(double[] tempThatDay) {
        double min = Integer.MAX_VALUE;
        for (int day = 1; day < tempThatDay.length; day++) {
            if (tempThatDay[day] < min) {
                min = tempThatDay[day];
            }
       } 
        return min;
    }
    // Calculates the maximum temperature within the array.
    public static double maxTemp(double[] tempThatDay) {
        double max = Integer.MIN_VALUE;
        for (int day = 1; day < tempThatDay.length; day++) {
            if (tempThatDay[day] > max) {
                max = tempThatDay[day];
            }
       } 
        return max;
    }
    // Calculates the average temperature of all the days.
    public static double average(double sum, double noOfDays) {
        double average = sum / noOfDays;
        return average;
    }
    // Checks how many days were above average.
    public static int warmerDays(double[] tempThatDay, double average) {
        int daysAboveAverage = 0;
        for (int i = 1; i < tempThatDay.length; i++) {
            if (tempThatDay[i] > average) {
                daysAboveAverage++;
            }
        }
        return daysAboveAverage;
    }
}
