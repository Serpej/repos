import java.util.Scanner;
/**
 * This program is made to calculate how long it will take for someone to become financially independent,
 * using the method financially independent retire early (FIRE). It's assuming your currency is SEK.
 * One needs to type in the following infomation:
 * What kind of FIRE one wants to pursue (FAT fire, Lean Fire or Barrista Fire).
 * The information on these come from here: https://www.investopedia.com/terms/f/financial-independence-retire-early-fire.asp
 * Facts:
 *  - The nominal net interest for most global index funds are about 7%.
 *  - One needs to save 25 to 30 times their yearly expenses (depending on how FAT they want to live in retirement).
 *  - One withdrawls a maximum of 4% annualy plus adjustments for interestRate.
 */

public class Fire {

    public static final int MENU_CHOICE_ONE = 1;
    public static final int MENU_CHOICE_TWO = 2;
    public static final int MENU_CHOICE_THREE = 3;
    public static final int MENU_CHOICE_QUIT = -1;
    public static final int TWELVE_MONTHS = 12;
    public static final int LEAN_FIRE_KEY = 25;
    public static final int FAT_FIRE_KEY = 30;


    public static void main(String[] args) throws Exception {
        Scanner userInput = new Scanner(System.in);
        int annualExpenses = 0;
        double monthlySavings = 0.0f;
        int menuChoice = 0;
        int partTimeSalary = 0;
        double interestRate = 2.5f;
        
        System.out.println("---------------------------------");
        System.out.println("WELCOME TO THE FIRE-CALCULATOR!");
        System.out.println("---------------------------------");
        newLine();
        System.out.println("Choose which FIRE method to calculate:");
        System.out.println("1. LEAN-FIRE (Devoted to minimalist living and extreme savings).");
        System.out.println("2. FAT-FIRE (High salary and aggressive savings).");
        System.out.println("3. BARRISTA-FIRE (Part-time work and Savings)");
        System.out.println("q. EXIT PROGRAM");
        newLine();
        menuChoice = menuInput(userInput);
        annualExpenses = annualExpenses(userInput);
        monthlySavings = monthlySavings(userInput);
        System.out.println("Enter average net interest rate (7% is a good average):");
        interestRate = integerInput(userInput);

        switch (menuChoice) {
            case MENU_CHOICE_ONE:
                calculateFire(interestRate, annualExpenses, monthlySavings, LEAN_FIRE_KEY, partTimeSalary);
                break;

            case MENU_CHOICE_TWO:
                calculateFire(interestRate, annualExpenses, monthlySavings, FAT_FIRE_KEY, partTimeSalary);
                break;

            case MENU_CHOICE_THREE:
                partTimeSalary = partTimeJob(userInput);
                calculateFire(interestRate, annualExpenses, monthlySavings, partTimeSalary, partTimeSalary);
                break;

            case MENU_CHOICE_QUIT:
                System.exit(0);
                break;

            default:
                break;
        }

}

    /**
     * This method creates a new line.
     */
    public static void newLine() {
        System.out.println();
    }

    /**
     * This method is used to get the right input for the menu.
     * @param userInput
     * @return 1, 2, 3 or -1(q).
     */
    public static int menuInput(final Scanner userInput) {
        while (true) {
            System.out.println("Enter 1, 2, 3 or q:");

            // Read the whole line and trim away any whitespaces.
            String input = userInput.nextLine().trim();

            // If it's a non-numeric:
            if (input.equalsIgnoreCase("q")) {
                    return MENU_CHOICE_QUIT;
            // If its a numeric:
            } else if (input.matches("\\d+")) {
                int menuChoice = Integer.parseInt(input);
                if (menuChoice <= MENU_CHOICE_THREE && menuChoice >= MENU_CHOICE_ONE) {
                    return menuChoice;
                } else {
                    System.out.println("Invalid input, try agin.");
                }
            } else {
                System.out.println("Invalid input, try agin.");
            }
        }
    }

    /**
     * This method is used to get an integer input from the user.
     * @param userInput
     * @return Integer
     */
    public static int integerInput(final Scanner userInput) {
        int validNumber = 0;
        while (true) {
            String tempInput = userInput.nextLine().trim();
            if (tempInput.matches("\\d+")) {
                validNumber = Integer.parseInt(tempInput);
                break;
            } else {
                System.out.println("Invalid input, enter a number of integers.");
                //userInput.nextLine();
            }
        }
        return validNumber;
    }

    /**
     * This method takes userInput to return either an integer or a decimal number.
     * @param userInput
     * @return a double value
     */
    public static double doubleInput(final Scanner userInput) {
        double validNumber = 0.0;
        while (true) {
            String tempInput = userInput.nextLine().trim();
            if (tempInput.matches("\\d+(\\.\\d+)?")) {
                validNumber = Double.parseDouble(tempInput);
                break;
            } else {
                System.out.println("Invalid input, enter a percentage number.");
                //userInput.nextLine();
            }
        }
        return validNumber;
    }

    /**
     * This method asks the user for their monthly expenses, calculates and returns their annual expenses.
     * @param userInput
     * @return Annual expenses
     */
    public static int annualExpenses(final Scanner userInput) {
        System.out.println("Enter your monthly expenses: ");
        int monthlyExpenses = integerInput(userInput);
        int annualExpenses = monthlyExpenses * TWELVE_MONTHS;
        return annualExpenses;
    }

    /**
     * This method asks user for a monthly savings and returns it as a double.
     * @param userInput
     * @return monthly savings
     */
    public static double monthlySavings(final Scanner userInput) {
        System.out.println("Enter your intended monthly savings: ");
        double monthlySavings = doubleInput(userInput);
        return monthlySavings;
    }

    /**
     * This method calculates how long time it will take for the user to retire according to thei inputs, and prints it.
     * @param annualExpenses
     * @param monthlySavings
     * @param fireKey
     */
    public static void calculateFire(final double interestRate, final int annualExpenses, final double monthlySavings,final int fireKey, final int partTimeSalary) {
        double currentSavings = 0.0f;
        int years = 1;
        int tempAnnualExpenses = annualExpenses - (TWELVE_MONTHS * partTimeSalary);
        int keyFireValue = tempAnnualExpenses * fireKey;
        int numOfyears = addInterest(interestRate, monthlySavings, keyFireValue, currentSavings, years);
        

        newLine();
        System.out.println("---------------------------------");
        System.out.printf("Monthly Savings: %.0f kr%n", monthlySavings);
        System.out.printf("Annual Expenses: %d kr%n", tempAnnualExpenses);
        System.out.printf("Your Fire Number: %d kr%n", keyFireValue);
        System.out.printf("Years until you can retire: %d%n", numOfyears);
        System.out.println("---------------------------------");
    }

    /**
     * This method lets the user input his or her monthly salary from a part time job.
     * @param userInput
     * @return monthly salary
     */
    public static int partTimeJob(final Scanner userInput) {
        System.out.println("Enter average post taxes salary from your part-time job (once retired):");
        int salary = integerInput(userInput);
        return salary;
    }

    public static int addInterest(final double interestRate, final double monthlySavings, final int keyFireValue, final double currentSavings, final int years) {
        if (currentSavings >= keyFireValue) {
            return years;
        } else {
            double newSavings = currentSavings + (monthlySavings * TWELVE_MONTHS);
            double newSavingsWithInterest = newSavings * (1 + (interestRate / 100));
            return addInterest(interestRate, monthlySavings, keyFireValue, newSavingsWithInterest, years + 1);
        }
        
    }

}
