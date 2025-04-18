import java.util.Scanner;
import java.util.Date;
import java.util.Random;
/**
 * Describe briefly your program in steps.
 * 1. Enter While-loop
 * 2. Invoke menu() which prints the menu
 * 3. Listen for user input:
 * 4. Validate input.
 *     if 1, Ask for  
 @author Jesper Hagerman Borgström (hagjes-5)
 */
public class MA04 {

    // Constants for the item array
    public static final int ITEM_ID = 0;
    public static final int ITEM_COUNT = 1;
    public static final int ITEM_PRICE = 2;
    public static final int ITEM_COLUMN_SIZE = 3;
    public static final int INITIAL_ITEM_SIZE = 10;
    public static final int MAX_COUNT = 10;
    public static final int MAX_PRICE = 901;
    public static final int PLUS_HUNDRED = 100;

    // Constants for the sales array
    public static final int SALE_ITEM_ID = 0;
    public static final int SALE_ITEM_COUNT = 1;
    public static final int SALE_ITEM_PRICE = 2;
    public static final int SALE_COLUMN_SIZE = 3;
    public static final int MAX_SALES = 1000;

    // Other constants
    public static final int MENU_ITEM_1 = 1;
    public static final int MENU_ITEM_2 = 2;
    public static final int MENU_ITEM_3 = 3;
    public static final int MENU_ITEM_4 = 4;
    public static final int MENU_ITEM_5 = 5;
    public static final int MENU_ITEM_6 = 6;
    public static final int MENU_ITEM_Q = -1;

    public static final int ITEM_FOUND = 0;
    public static final int ITEM_NOT_FOUND = -1;
    public static final int INITIAL_ITEM_NUMBER = 999;

    private static Scanner userInputScanner = new Scanner(System.in);

    // /**
    //  * This method should be used only for unit testing on CodeGrade. Do not change this method!
    //  * Swaps userInputScanner with a custom scanner object bound to a test input stream
    //  *
    //  * @param inputScanner  test scanner object
    //  */
    // public static void injectInput(final Scanner inputScanner) {
    //     userInputScanner = inputScanner;
    // }

    public static void main(final String args[]) {
        int[][] items = new int[INITIAL_ITEM_SIZE][ITEM_COLUMN_SIZE]; // Data structure to store items
        int[][] sales = new int[MAX_SALES][SALE_COLUMN_SIZE]; // Data structure to store sales
        Date[] saleDates = new Date[MAX_SALES]; // Data structure to store sale dates
        int lastItemNumber = INITIAL_ITEM_NUMBER; // Keep track of last added ItemNumber
        int menyChoice = 0;
        int addedNumber = 0;
        int itemToRemove = -1;
        int itemId = 0;



        System.out.println("This is Marked Assignment 4");
        while (true) {
            menyChoice = menu();
            switch (menyChoice) {
                case 1:
                    System.out.println("How many items would you like to add?");
                    addedNumber = addNoOfItems();

                    // Updates lastItemNumber with latest ID.
                    lastItemNumber = finLastItemId(items);

                    items = insertItems(items, lastItemNumber, addedNumber);
                    
                    break;
                
                case 2:
                    System.out.println("Enter an item ID that you want removed:");
                    itemId = input();
                    itemToRemove = removeItem(items, itemId);
                    if (itemToRemove == 0) {
                        System.out.printf("Item with item ID %d was successfully removed%n", itemId);
                    } else {
                        System.out.printf("Item with item ID %d wasn't found%n", itemId);

                    }
                    break;

                case 3:
                    printItems(items);
                    break;
                case 4:
                    
                    break;
                
                case 5:
                    
                    break;

                case 6:
                    
                    break;
                default:
                    System.out.println("Try again.");
                    break;
            }
        }
       
    }

    /**
     * This method presents the user with different options and returns the users menyChoice.
     * @return the users menyChoice in the form of an int
     */
    public static int menu() {
        System.out.println();
        System.out.println("MENU");
        System.out.println("1. Insert items");
        System.out.println("2. Remove an item");
        System.out.println("3. Display a list of items");
        System.out.println("4. Register a sale");
        System.out.println("5. Display sales history");
        System.out.println("6. Sort and display sales history table");
        System.out.println("q. Quit");
        System.out.println("Your Selection:");
        return input();
    }

    /**
     * This method checks for user input and returns either a number between 1 and 6, or -1 if "q" is entered.
     * Otherwise it displays an error message.
     * @return An integer between 1 and 6 or -1.
     */
    public static int input() {
        int number = 0;
        while (true) {
                if (userInputScanner.hasNextInt()) {
                    number = userInputScanner.nextInt();
                    break;
                } else if (userInputScanner.hasNext()) {
                    String quitString = userInputScanner.next();
                    if (quitString.equalsIgnoreCase("q")) {
                        return MENU_ITEM_Q;
                    } else {
                    System.out.println("Invalid input, must be integer or 'q'.");
                    }
                }
        }
    return number;
    }

    /**
     * This method checks if the array parameter cannot hold the specified number of items.
     * It returns true if the array is full or can't hold the requested number.
     * @param items
     * @param noOfItems
     */
    public static boolean checkFull (final int[][] items, final int noOfItems) {
        int emptySpaces = spacesLeftInArray(items);
        if (emptySpaces < noOfItems) {
            return true;
        }
        return false;
    }

    /**
     * This method is called from insertItems() when checkFull() returns true (that is, when your array is too small).
     * The method allocates the necessary amount of memory to a new array and copies the existing array into it.
     * @param items
     * @param noOfItems
     * @return a new, extended array with the appropriate amount of allocated memory.
     */
    public static int[][] extendArray(final int[][]items, final int noOfItems) {
        int newMemoryAllocation =  items.length + noOfItems;
        int[][] extendedRows = new int[newMemoryAllocation][ITEM_COLUMN_SIZE];
        
        // Copy existing rows in the items array.
        for (int row = 0; row < items.length; row++) {
            extendedRows[row][ITEM_ID] = items[row][ITEM_ID];
            extendedRows[row][ITEM_COUNT] = items[row][ITEM_COUNT];
            extendedRows[row][ITEM_PRICE] = items[row][ITEM_PRICE];
        }
        return extendedRows;
    }

/**
 * 
 * @param items
 * @param lastItemId
 * @param noOfItems
 * @return a possibly extended array with a number of random numbers inserted as number of sales and price.
 */
    public static int[][] insertItems(final int[][] items, final int lastItemId, final int noOfItems) {
        int placeHolderID = lastItemId;
        int tempNoOfItems = noOfItems;
        int startRow = 0;
        int newItemsArray[][] = items;
        boolean checkArraySize = checkFull(items, noOfItems);
        
        if (checkArraySize == true) {
            int emptySpaces = spacesLeftInArray(items);
            int spacesToAdd = noOfItems - emptySpaces;
            newItemsArray = extendArray(items, spacesToAdd);
        }

        //Check at what row to start iterating through KOLLA FRÅN 32:00 på videon!!
        for (int row = 0; row < newItemsArray.length; row++) {
            if (newItemsArray[row][ITEM_ID] == 0) {
                startRow = row;
                break;
            }
        }
        // Add item ID, random sale count and random sale price to each index in the columns
        for (int row = startRow; row < newItemsArray.length && tempNoOfItems > 0; row++) {
            for (int column = 0; column < newItemsArray[row].length; column++) {
                if (column ==  ITEM_ID) {
                    //Add an item ID to the first element of the inner array.
                    placeHolderID++;
                    newItemsArray[row][ITEM_ID] = placeHolderID;
                    // Countdown for the number of places to fill
                    tempNoOfItems--;

                } else if(column == ITEM_COUNT) {
                    //Add a random sale count to the item.
                    newItemsArray[row][ITEM_COUNT] = getRandomNumberInRange(MAX_COUNT, 1);

                } else if (column == ITEM_PRICE) {
                    //Add a random price to the item.
                    newItemsArray[row][ITEM_PRICE] = getRandomNumberInRange(MAX_PRICE, PLUS_HUNDRED);
                }
            }
        }
        
        return newItemsArray;
    }
    
/**
 * This method iterates through the items array backwards to find the last item ID
 * that is not 0 and returns it. If no such ID was found, it returns 999.
 * @param items
 * @return Last item ID or 999 as default.
 */
    public static int finLastItemId(final int[][] items) {
        for (int row = items.length -1; row >= 0; row--) {
            if (items[row][ITEM_ID] != 0) {
                return items[row][ITEM_ID];
            }
        }
        return INITIAL_ITEM_NUMBER;
    }

/**
 * This method listens for user input, validates the input and returns an integer or an error message.
 * @return An integer or an error message.
 */
    public static int addNoOfItems() {
        int number = 0;
        while (true) {
            if (userInputScanner.hasNextInt()) {
                number = userInputScanner.nextInt();
                if (number < 1) {
                    System.out.println("Error, enter a positive integer.");
                }
                break;
                } else if (userInputScanner.hasNext()) {
                    System.out.println("Input must be integer, try again.");
                    userInputScanner.next();   
                }
        }
    return number;
    }
/**
 * This method takes to integers and generates a random number based on a range and a floor.
 * @param range
 * @param floor
 * @return A random integer.
 */
    public static int getRandomNumberInRange(int range, int floor) {
        Random rand = new Random();
        int randomNumber = (rand.nextInt(range) + floor);
        return randomNumber;
    }

/**
 * This method takes an array of arrays and checks how many spaces in index 0 of the inner array is 0.
 * @param items
 * @return an integer equal to the number of places with 0 at index 0.
 */
    public static int spacesLeftInArray(final int items[][]) {
        int emptySpaces = 0;
        for (int row = 0; row < items.length; row++) {
            if (items[row][ITEM_ID] == 0) {
                emptySpaces++;
            }
        }
        return emptySpaces;
    }

    public static int removeItem(final int[][] items, final int itemId) {
        for (int row = 0; row < items.length; row++) {
            if (items[row][ITEM_ID] == itemId) {
                items[row][ITEM_ID] = 0;
                items[row][ITEM_COUNT] = 0;
                items[row][ITEM_PRICE] = 0;
                return ITEM_FOUND;
            }
        }
        return ITEM_NOT_FOUND;
    }
/**
 * This method prints the elements in the array items (and the elements within the elements that are arrays).
 * @param items
 */
    public static void printItems(final int[][] items) {
        System.out.println();
        for (int row = 0; row < items.length; row++) {
            for (int column = 0; column < items[row].length; column++) {
                if (column == ITEM_ID) {
                    System.out.printf("ItemID: %d, ", items[row][column]);
                } else if(column == ITEM_COUNT) {
                    System.out.printf("Count: %d, ", items[row][column]);
                } else if(column == ITEM_PRICE) {
                    System.out.printf("Price: %d %n", items[row][column]);
                }
            }
        }
        System.out.println();
    }
}
