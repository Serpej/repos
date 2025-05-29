import java.util.Scanner;
 /**
 * This is a simple rent a car program.
 * You are supposed to be able to add a car to the car fleet by entering registration number, make and model.
 * Then you can rent the car by searching for it (by registration number) and then adding pick up time and your name.
 * Lastly you can return the car and get a receipt for the cost and the time you rented it.
 * I sadly didnt have time to implement the last two features.
 * @author Jesper Hagerman (hagjes-5)
 **/

public class Main {

    // Menu constants
    public static final int MENU_ITEM_1 = 1;
    public static final int MENU_ITEM_2 = 2;
    public static final int MENU_ITEM_3 = 3;
    public static final int MENU_ITEM_4 = 4;
    public static final int MENU_ITEM_5 = 5;
    public static final int MENU_ITEM_Q = -1;

    // Other constants
    public static final int INITIAL_ALLOCAED_SPACE = 10;
    public static final int INITIAL_MINUTE_SPACE_ALLOCATED = 2;
    public static final int BASE_HUNDRED = 100;
    public static final double HOURLY_RATE = 120.0;
    public static final int MAX_MINUTES = 59;
    public static final int ZERO = 0;
    public static final int MAX_HOURS = 23;

    public static void main(final String[] args) {
        Scanner userInput = new Scanner(System.in);
        userInput.useDelimiter("[\\s+:]");

        String[] carRegNum = new String[INITIAL_ALLOCAED_SPACE];
        String[] carMakeAndModel = new String[INITIAL_ALLOCAED_SPACE];
        String[] nameOfRenter = new String[INITIAL_ALLOCAED_SPACE];
        int[][] timeOfPickup = new int[INITIAL_ALLOCAED_SPACE][INITIAL_MINUTE_SPACE_ALLOCATED];
        int[][] timeOfReturn = new int[INITIAL_ALLOCAED_SPACE][INITIAL_MINUTE_SPACE_ALLOCATED];
        int menuChoice = 0;

        while (true) {
            menuChoice = menu(userInput);
            switch (menuChoice) {
                case MENU_ITEM_1:
                    addCar(userInput, carRegNum, carMakeAndModel);
                    break;

                case MENU_ITEM_2:
                    rentCar(userInput, carRegNum, nameOfRenter, timeOfPickup);
                    break;

                case MENU_ITEM_3:
                    returnCar(userInput, carRegNum, carMakeAndModel, nameOfRenter, timeOfReturn, timeOfPickup);
                    break;

                case MENU_ITEM_4:
                    System.out.println("four");
                    break;

                case MENU_ITEM_5:
                    System.out.println("five");
                    break;

                case MENU_ITEM_Q:
                    System.out.println("Goodbye");
                    System.exit(0);
                    break;

                default:
                    break;
            }
        }

    }

    /**
     * This method presents the user with different options and returns the users menyChoice.
     * @param userInput
     * @return the users menyChoice in the form of an int
     */
    public static int menu(final Scanner userInput) {
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println("# LTU Rent-a-car");
        System.out.println("--------------------------------");
        System.out.println("1. Add car to fleet");
        System.out.println("2. Rent a car");
        System.out.println("3. Return a car");
        System.out.println("4. Print car fleet");
        System.out.println("5. Print rental summary");
        System.out.println("q. End program");
        System.out.println("> Enter your option:");
        return menuInput(userInput);
    }

    /**
     * This method takes userInput and validates into a String input.
     * @param userInput
     * @return a String.
     */
    public static String stringInput(final Scanner userInput) {
        while (true) {
            if (userInput.hasNext()) {
                String tempString = userInput.nextLine();
                return tempString;
            } else {
                System.out.println("Invalid input, try again:");
                userInput.nextLine();
            }
        }
    }

    /**
     * This method takes userInput and validates into a Int input.
     * @param userInput
     * @return an Int.
     */
    public static int intInput(final Scanner userInput) {
        while (true) {
            if (userInput.hasNextInt()) {
                int tempInt = userInput.nextInt();
                return tempInt;
            } else {
                System.out.println("Invalid input, try again:");
                userInput.nextLine();
            }
        }
    }

    /**
     * This method checks for user input and returns either a number between 1 and 5, or -1 if "q" is entered.
     * Otherwise it displays an error message.
     * @param userInput
     * @return An integer between 1 and 5 or -1.
     */
    public static int menuInput(final Scanner userInput) {
        int number = 0;
        while (true) {
            if (userInput.hasNextInt()) {
                number = userInput.nextInt();
                if (number > ZERO && number <= MENU_ITEM_5) {
                    break;
                } else {
                    System.out.println("invalid menu item, choose between 1 - 5 or q.");
                }
            } else if (userInput.hasNext()) {
                String quitString = userInput.next();
                if (quitString.equalsIgnoreCase("q")) {
                    return MENU_ITEM_Q;
                } else {
                    System.out.println("invalid menu item, must be integer or 'q'.");
                }
            }
        }
        return number;
    }

    /**
     * This method takes user input and validates it into a valid hour.
     * @param userInput
     * @return an integer between 0 and 23.
     */
    public static int getHours(final Scanner userInput) {
        while (true) {
            if (userInput.hasNextInt()) {
                int hour = userInput.nextInt();
                if (hour >= ZERO && hour <= MAX_HOURS) {
                    return hour;
                }
            } else {
                System.out.println("invalid time format, try again:");
                userInput.nextLine();
            }
        }
    }

    /**
     * This method takes a user input and validates it into a valid minute
     * @param userInput
     * @return an integer between 0 and 59.
     */
    public static int getMinutes(final Scanner userInput) {
        while (true) {
            if (userInput.hasNextInt()) {
                int minutes = userInput.nextInt();
                if (minutes >= ZERO && minutes <= MAX_MINUTES) {
                    return minutes;
                }
            } else {
                System.out.println("invalid time format, try again:");
                userInput.nextLine();
            }
        }
    }

        /**
     * This method checks that the input is a registration number and returns it as a String.
     * @param userInput
     * @return A registration number (String).
     */
    public static String carRegInput(final Scanner userInput) {
        String pattern = "^[A-Z]{3}\\d{3}$";

        while (true) {
            if (userInput.hasNext()) {
                String tempRegString = userInput.next();
                if (tempRegString.matches(pattern)) {
                    userInput.nextLine();
                    return tempRegString;
                } else {
                    System.out.println("invalid registration number. Enter three capital letters followed by three integer (ex 'ABC123'):");
                    userInput.nextLine();
                }
            } else {
                System.out.println("No input detected, please try again:");
                userInput.nextLine();
            }
        }
    }

    /**
     * This method clear the input buffer
     * @param userInput
     */
    public static void clearBuffer(final Scanner userInput) {
        if (userInput.hasNextLine()) {
            userInput.nextLine();
        }
    }

    /**
     * This method asks for registration number, make and model and puts them in two separate arrays.
     * @param userInput
     * @param carRegNum
     * @param carMakeAndModel
     */
    public static void addCar(final Scanner userInput, final String[] carRegNum, final String[] carMakeAndModel) {
        System.out.println("> Enter registration number:");
        String tempRegNum = carRegInput(userInput);
        System.out.println("> Enter make and model:");
        String tempMakeAndModel = stringInput(userInput);
        boolean isNewCar = true;

        // Check if the registration number already is in the fleet.
        isNewCar = isNewReg(carRegNum, tempRegNum);
        if (!isNewCar) {
            System.out.printf("number %s already exists.%n", tempRegNum);
        }
        // Add registration number to carRegNum array and make and model to carMakeAndModel array.
        if (isNewCar) {
            for (int i = 0; i < carRegNum.length; i++) {
                if (carRegNum[i] == null) {
                    carRegNum[i] = tempRegNum;
                    carMakeAndModel[i] = tempMakeAndModel;
                    System.out.printf("%s with registration number %s was added to the car fleet.", carMakeAndModel[i], carRegNum[i]);
                    break;
                }
            }
        }
    }

    /**
     * This method takes the registration number array and compares all the elements with the given registration number to see if it already exists.
     * @param carRegNum
     * @param regNum
     * @return True or False.
     */
    public static boolean isNewReg(final String[] carRegNum, final String regNum) {
        boolean isNewCar = true;
        for (int i = 0; i < carRegNum.length; i++) {
            if (carRegNum[i] == null) {
                continue;
            } else if (carRegNum[i].equals(regNum)) {
                isNewCar = false;
                break;
            }
        }
        return isNewCar;
    }

    /**
     * This method asks for a registration number, a time and a name to rent a given car in the carRegNum array.
     * @param userInput
     * @param carRegNum
     * @param nameOfRenter
     * @param pickUpTime
     */
    public static void rentCar(final Scanner userInput, final String[] carRegNum, final String[] nameOfRenter, final int[][] pickUpTime) {
        System.out.println("> Enter car's registration number: ");
        String tempRentCar = carRegInput(userInput);

        boolean isCarNew = isNewReg(carRegNum, tempRentCar);

        if (!isCarNew) {

            // Check if the car is rented.
            for (int i = 0; i < carRegNum.length; i++) {
                if (carRegNum[i] != null && carRegNum[i].equals(tempRentCar)) {
                    if (nameOfRenter[i] != null && !nameOfRenter[i].equals("")) {
                        System.out.printf("car %s not available.%n", carRegNum[i]);
                        return;
                    }
                }
            }

            System.out.println("> Enter time of pickup (ex 12:00):");
            int pickUpHour = getHours(userInput);
            int pickUpMinutes = getMinutes(userInput);

            // Clear the input Buffer
            clearBuffer(userInput);

            System.out.println("> Enter renter's name:");
            String rentName = stringInput(userInput);
            for (int i = 0; i < carRegNum.length; i++) {
                if (carRegNum[i] != null && carRegNum[i].equals(tempRentCar)) {
                    nameOfRenter[i] = rentName;
                    pickUpTime[i][0] = pickUpHour;
                    pickUpTime[i][1] = pickUpMinutes;
                    System.out.printf("Car with registration number %s was rented by %s at %02d:%02d.%n", tempRentCar, rentName, pickUpTime[i][0], pickUpTime[i][1]);
                    return;
                }
            }
        } else {
            System.out.printf("car %s not found", tempRentCar);
        }
    }

    /**
     * Thsi method asks for a registration number, checks if it is rented and then for a time of return.
     * Finally it calculates the cost of the rent and prints a recepit.
     * @param userInput
     * @param carRegNum
     * @param carMakeAndModel
     * @param nameOfRenter
     * @param timeOfReturn
     * @param timeOfPickup
     * @return a total cost in datatype double.
     */
    public static double returnCar(final Scanner userInput, final String[] carRegNum, final String[] carMakeAndModel, final String[] nameOfRenter, final int[][] timeOfReturn, final int[][] timeOfPickup) {
        System.out.println("> Enter car's registration number: ");
        String tempRentCar = carRegInput(userInput);
        boolean isCarRented = false;
        String nameofRenter = "";
        double totalCost = 0;

        // Check if car is rented.
        for (int i = 0; i < carRegNum.length; i++) {
            if (carRegNum[i] != null && carRegNum[i].equals(tempRentCar)) {
                if (nameOfRenter[i] != null && !nameOfRenter[i].equals("")) {
                    isCarRented = true;
                    break;
                } else {
                    System.out.printf("car %s not rented.%n", carRegNum[i]);
                    return 0;
                }
            }
        }

        if (isCarRented) {
            System.out.println("Enter time of return (ex.13:00):");
            int returnHour = getHours(userInput);
            int returnMinutes = getMinutes(userInput);

            // Clear the input Buffer
            clearBuffer(userInput);

            for (int i = 0; i < carRegNum.length; i++) {
                if (carRegNum[i] != null && carRegNum[i].equals(tempRentCar)) {
                    int index = i;
                    nameofRenter = nameOfRenter[i];
                    nameOfRenter[i] = "";
                    timeOfReturn[i][0] = returnHour;
                    timeOfReturn[i][1] = returnMinutes;

                    double rentedTime = rentTime(carRegNum, timeOfPickup, timeOfReturn, index);

                    totalCost = rentedTime * HOURLY_RATE;

                    System.out.println("===================================");
                    System.out.println("LTU Rent-a-car");
                    System.out.println("===================================");
                    System.out.printf("Name: %s%n", nameofRenter);
                    System.out.printf("Car: %s (%s)%n", carMakeAndModel[i], carRegNum[i]);
                    System.out.printf("Time: %02d:%02d-%02d:%02d (%.02f hours)%n", timeOfPickup[i][0], timeOfPickup[i][1], timeOfReturn[i][0], timeOfReturn[i][1], rentedTime);
                    System.out.printf("Total cost: %.02f SEK%n", totalCost);
                    System.out.println("===================================");
                }
            }

        } else {
            System.out.printf("car %s not found.%n", tempRentCar);
        }
        return totalCost;
    }
    /**
     * This Method calculates the time the car has been rented.
     * @param carRegNum
     * @param timeOfPickup
     * @param timeOfReturn
     * @param index
     * @return a time in decimal format (ex 5.12 hours).
     */
    public static double rentTime(final String[] carRegNum, final int[][] timeOfPickup, final int[][] timeOfReturn, final int index) {
        double rentedHours = timeOfReturn[index][0] - timeOfPickup[index][0];
        double rentedMinutes = timeOfReturn[index][1] - timeOfPickup[index][1];
        rentedMinutes = rentedMinutes / BASE_HUNDRED;
        rentedHours += rentedMinutes;
        double rentedTime = rentedHours;
        return rentedTime;
    }
}

