import java.util.Scanner;

/**
* This program computes the amount of kWh and SEK made with certain assumptions.
* Step 1: Declare Constants.
* Step 2: Declare Variables.
* Step 3: Ask user for month and date and validate input.
* Step 4: Ask user for sunrise and validate input.
* Step 5: same as step 4, but for sunset.
* Step 6: Calculate the total sun time from sunrise and sunset and validate amount.
* Step 7: Calculate production.
* Step 8: Calculate money
* Step 9: Print result
* @author Jesper Hagerman (hagjes-5)
*/

class PA02WithMethods {

    static final int NUM_OF_PANELS = 26;
    static final float PANEL_HEIGHT = 1f;
    static final float PANEL_WIDTH = 1.7f;
    static final int SOLAR_RADIATION = 166;
    static final float PANEL_AREA = PANEL_WIDTH * PANEL_HEIGHT;
    static final float EFFICIENCY = 0.2f;
    static final float ELECTRIC_PRICE = 0.9f;
    static final int DAYS_IN_JUNE_MAX = 30;
    static final int DAYS_IN_JULY_MAX = 31;
    static final int MAX_HOURS = 23;
    static final int MAX_MINUTES = 59;
    static final int MAX_MINS_IN_DAY = 1440;
    static final int JUNE = 6;
    static final int JULY = 7;
    static final int CONVERT_HOURS_AND_MINUTES = 60;
    static final int CONVERT_TO_KW = 1000;
    


    public static void main(final String[] args) {


        Scanner userInput = new Scanner(System.in);
        int month = 0;
        double hour = 0.0;
        double minutes = 0.0;
        int day = 0;
        double sunriseTime = 0.0;
        double sunsetTime = 0.0;
        double sunTimeMinutes = 0.0;
        double sunTimeHours = 0.0;
        double production = 0.0;
        double value = 0.0; 

        userInput.useDelimiter("[-|\\s+]");

        //Ask user for month and date
        System.out.print("Enter today's date [mm-dd]> ");
        
        // Validate month and date
        if (userInput.hasNextInt()) {
            month = userInput.nextInt();
            day = userInput.nextInt();
            if(!isBetweenMonth(month, JUNE, JULY)) {
                System.exit(0);
            }
            if (!isValidDate(month, day, JUNE, JULY)) {
                System.exit(0);
            }
        } else {
            invalidFormat();
        }
        
        //Ask user for sunrise
        System.out.print("Enter the time of sunrise [hh: mm]> ");

        userInput.useDelimiter("[:/\\s+]");

        //Validate hours for sunrise
        if (userInput.hasNextInt()) {
            hour = userInput.nextInt();
            if (!isValidHour(hour)) {
                System.exit(0);
            }
        } else {
            invalidFormat();
        }

        //Validate minutes for sunrise
        if (userInput.hasNextInt()) {
            minutes = userInput.nextInt();
            if (!isValidMinutes(minutes)) {
                System.exit(0);
            }
        } else {
            invalidFormat();
        }
        
        // Store input as hours
        sunriseTime = minutes + (hour * CONVERT_HOURS_AND_MINUTES);

        //Same as step 4, but for sunset
        System.out.print("Enter the time of sunset [hh: mm]> ");

        // Validate hours for sunset
        if (userInput.hasNextInt()) {
            hour = userInput.nextInt();
            if (!isValidHour(hour)) {
                System.exit(0);
            }
        } else {
            invalidFormat();
        }

        // Validate minutes for sunset
        if (userInput.hasNextInt()) {
            minutes = userInput.nextInt();
            if (!isValidMinutes(minutes)) {
                System.exit(0);
            }
        } else {
            invalidFormat();
        }

        // Store input as hours
        sunsetTime = minutes + (hour * CONVERT_HOURS_AND_MINUTES);

        // Calculate the total sun time from sunrise and sunset
        sunTimeMinutes = sunsetTime - sunriseTime;
        sunTimeHours = sunTimeMinutes / CONVERT_HOURS_AND_MINUTES;
        
        //Validate that the time is correct amount and that sunrise is a smaller amount the sunset.
        if (sunTimeMinutes > MAX_MINS_IN_DAY) {
            System.out.println("Error! Invalid time format. The day can only have between 0 and 24 hours");
            System.exit(0);
            
        } else if (sunsetTime < sunriseTime ) {
            System.out.println("Error! Sunrise must be before sunset.");
            System.exit(0);
        }

        //Calculate production
        production = sunTimeHours * SOLAR_RADIATION * EFFICIENCY * PANEL_AREA * NUM_OF_PANELS / CONVERT_TO_KW;

        //Calculate money                
        value = production * ELECTRIC_PRICE;
        
        //Print result
        System.out.printf("Sun hours: %.1f hours %n", sunTimeHours);
        System.out.printf("The production on %d/%d is: %.2f kWh to a value of: SEK %.2f%n", day, month, production, value);
        userInput.close();
    }

    // Validate month
    public static boolean isBetweenMonth(int month, int startMonth, int endMonth) {
        if (month != startMonth && month != endMonth) {
            System.out.printf("Error! Invalid month. You have entered %d, but only 6 or 7 is allowed.%n", month);
            return false;
        }
        return true;
    }

    // Validate date
    public static boolean isValidDate(int month, int day, int startMonth, int endMonth) {
        int daysInMonth[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (day < 1) {
            System.out.println("Error! Invalid day.");
            return false;
        } else if (month == startMonth && day > daysInMonth[month - 1]){
            System.out.printf("Error! Invalid day. You entered %d but June only has 30 days.%n", day);
            return false;
        } else if (month == endMonth && day > daysInMonth[month - 1]){
            System.out.printf("Error! Invalid day. You entered %d but July only has 31 days.%n", day);
            return false;
        }
        return true;
    }

    //Validate hours
    public static boolean isValidHour(double hours) {

        if (hours > MAX_HOURS || hours < 0) {
            System.out.printf("Error! Invalid time. Hours must be between 0 and 23, you entered %.0f. %n", hours);
            return false;
        }
        return true;
    }

    //Validate minutes
    public static boolean isValidMinutes(double minutes) {
        if (minutes > MAX_MINUTES || minutes < 0) {
            System.out.printf("Error! Invalid time. Minutes must be between 0 and 59, you entered %.0f. %n", minutes);
            return false;   
        }
        return true;
    }

    public static void invalidFormat() {
        System.out.println("Error! Invalid format.");
        System.exit(0);
    }
}
