import java.util.Scanner;
import java.util.Date;
import java.util.Random;
/**
 * Describe briefly your program in steps.
 * 1. Enter While-loop
 * 2. Invoke menu() which prints the menu and invokes input() which listens for and valdates user input.
 *      if input is valid it corresponds to a choice in a switch case:
 *          2.1 Asks for number of items to insert and stores the result via addNoOfItems().
 *              Finds the last item ID through findLastItemId().
 *              Lastly inserts items in items[][] through insertItems();
 *          2.2 Asks for a in item ID to remove and listens for answer through input().
 *              Takes the variable and searches through items[][] with removeItem().
 *              Lastly it checks if item was removed or not and tells the user.
 *          2.3
 *              Prints all the items in items[][] with printItems();
 *          2.4
 *              Asks user for item ID to sell and then an amount to sell, gets variables through input().
 *              Then it invokes sellItem() to check that the amount to sell is valid and updates sales[][] items[][] and salesDates[].
 *          2.5 Invokes printSales() to print sales[][] and salesDates[] arrays in a table.
 *          2.6 Invokes sortedTable() to first sort the sales[][] and salesDates[] arrays in ascending order according to the item IDs,
 *              and then prints them in a table.
 *          2.7 Prints "Goodbye" and exits the program safely.
 * @author Jesper Hagerman Borgström (hagjes-5)
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

    public static final int SUCCESS = 0;
    public static final int FAILED = -1;
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

    public static void main(final String[] args) {
        int[][] items = new int[INITIAL_ITEM_SIZE][ITEM_COLUMN_SIZE]; // Data structure to store items
        int[][] sales = new int[MAX_SALES][SALE_COLUMN_SIZE]; // Data structure to store sales
        Date[] saleDates = new Date[MAX_SALES]; // Data structure to store sale dates
        int lastItemNumber = INITIAL_ITEM_NUMBER; // Keep track of last added ItemNumber
        int menyChoice = 0;
        int addedNumber = 0;
        int itemToRemove = -1;
        int itemId = 0;
        int itemIdToSell = 0;
        int amountToSell = 0;



        System.out.println("This is Marked Assignment 4");
        while (true) {
            menyChoice = menu();
            switch (menyChoice) {
                case MENU_ITEM_1:
                    System.out.println("How many items would you like to add?");
                    addedNumber = addNoOfItems();

                    // Updates lastItemNumber with latest ID.
                    lastItemNumber = findLastItemId(items);
                    items = insertItems(items, lastItemNumber, addedNumber);
                    break;

                case MENU_ITEM_2:
                    System.out.println("Enter an item ID that you want removed:");
                    itemId = input();
                    itemToRemove = removeItem(items, itemId);
                    if (itemToRemove == 0) {
                        System.out.printf("Item with item ID %d was successfully removed%n", itemId);
                    } else {
                        System.out.printf("Item with item ID %d wasn't found%n", itemId);

                    }
                    break;

                case MENU_ITEM_3:
                    printItems(items);
                    break;

                case MENU_ITEM_4:
                    System.out.println("Enter item ID to sell");
                    itemIdToSell = input();
                    System.out.println("Enter amount of items to sell");
                    amountToSell = input();
                    sellItem(sales, saleDates, items, itemIdToSell,  amountToSell);
                    break;

                case MENU_ITEM_5:
                    printSales(sales, saleDates);
                    break;

                case MENU_ITEM_6:
                    sortedTable(sales, saleDates);
                    break;

                case MENU_ITEM_Q:
                    System.out.println();
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid optin, try again.");
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
     * @return true if the array is full or false if it still has empty spaces.
     */
    public static boolean checkFull(final int[][] items, final int noOfItems) {
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
        int[][] newItemsArray = items;
        boolean checkArraySize = checkFull(items, noOfItems);
        if (checkArraySize) {
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

                } else if (column == ITEM_COUNT) {
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
 * @return Last item ID or if it can't it will return 999 or 100 depending on the length of the array.
 */
    public static int findLastItemId(final int[][] items) {
        for (int row = items.length - 1; row >= 0; row--) {
            if (items[row][ITEM_ID] != 0) {
                return items[row][ITEM_ID];
            }
        }
        if (items.length < MAX_SALES) {
            return INITIAL_ITEM_NUMBER;
        } else {
            return INITIAL_ITEM_NUMBER + 1;
        }

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
                System.out.println("Invalid input. Enter an integer, try again.");
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
    public static int getRandomNumberInRange(final int range, final int floor) {
        Random rand = new Random();
        int randomNumber = (rand.nextInt(range) + floor);
        return randomNumber;
    }

/**
 * This method takes an array of arrays and checks how many spaces in index 0 of the inner array is 0.
 * @param items
 * @return an integer equal to the number of places with 0 at index 0.
 */
    public static int spacesLeftInArray(final int[][] items) {
        int emptySpaces = 0;
        for (int row = 0; row < items.length; row++) {
            if (items[row][ITEM_ID] == 0) {
                emptySpaces++;
            }
        }
        return emptySpaces;
    }
/**
 * This method takes an item ID as an argument and looks for it in the items array. If it finds the matching ID, it sets all elements in the column to 0.
 * @param items
 * @param itemId
 * @return 0 if successfully removed item, otherwise -1.
 */
    public static int removeItem(final int[][] items, final int itemId) {
        for (int row = 0; row < items.length; row++) {
            if (items[row][ITEM_ID] == itemId) {
                items[row][ITEM_ID] = 0;
                items[row][ITEM_COUNT] = 0;
                items[row][ITEM_PRICE] = 0;
                return SUCCESS;
            }
        }
        System.out.println("Could not find Item ID");
        return FAILED;
    }
/**
 * This method uses bubble sort to sort the columns of items array into ascending order according to ITEM_ID.
 * @param items
 */
    public static void sortItemsById(final int[][] items) {
        for (int i = 0; i < items.length - 1; i++) {
            for (int row = 0; row < (items.length - i) - 1; row++) {
                if (items[row][ITEM_ID] > items[row + 1][ITEM_ID]) {
                    int[] temp = items[row];
                    items[row] = items[row + 1];
                    items[row + 1] = temp;
                }
            }
        }
    }
/**
 * This method prints the elements in the array items (and the elements within the elements that are arrays).
 * @param items
 */
    public static void printItems(final int[][] items) {
        sortItemsById(items);
        System.out.println();
        for (int row = 0; row < items.length; row++) {
            for (int column = 0; column < items[row].length; column++) {
                if (column == ITEM_ID) {
                    System.out.printf("ItemID: %d, ", items[row][column]);
                } else if (column == ITEM_COUNT) {
                    System.out.printf("Count: %d, ", items[row][column]);
                } else if (column == ITEM_PRICE) {
                    System.out.printf("Price: %d %n", items[row][column]);
                }
            }
        }
        System.out.println();
    }

/**
 * This method first checks if the items array has a sufficient stock to sell the requested amount. If it does, the correct ITEM_COUNT gets assigned the left over stock
 * and a sum is calculated based on the total price of the sold items. Then the correct indexes in sales is found and assigned the same ID, sold amount and sum.
 * Lastly the salesDate array gets a date assigned to it in the corresponding index.
 * @param sales
 * @param salesDate
 * @param items
 * @param itemIdToSell
 * @param amountToSell
 * @return 0 if items were successfully sold, -1 if the ID wasn't found, or the current stock if there aren't enough available to sell.
 */
    public static int sellItem(final int[][] sales, final Date[] salesDate, final int[][] items, final int itemIdToSell, final int amountToSell) {
        Date date = new Date();
        int numberInStock = 0;
        int itemsLeft = 0;
        int sum = 0;

        for (int row = 0; row < items.length; row++) {
            if (items[row][ITEM_ID] == itemIdToSell) {
                //Check number in stock.
                numberInStock = items[row][ITEM_COUNT];
                if (items[row][ITEM_COUNT] >= amountToSell) {

                    //Calculate the number of items left.
                    itemsLeft = items[row][ITEM_COUNT] - amountToSell;

                    //Calculate the sum of the price.
                    sum = items[row][ITEM_PRICE] * amountToSell;

                    //Assign a number as the new stock in items array.
                    items[row][ITEM_COUNT] = itemsLeft;

                    // Insert item ID, number of items sold and the total sum for the items in the sales array.
                    for (int salesRow = 0; salesRow < sales.length; salesRow++) {
                        if (sales[salesRow][SALE_ITEM_ID] == 0) {
                            sales[salesRow][SALE_ITEM_ID] = items[row][ITEM_ID];
                            sales[salesRow][SALE_ITEM_COUNT] = amountToSell;
                            sales[salesRow][SALE_ITEM_PRICE] = sum;
                            salesDate[salesRow] = date;
                            break;
                        }
                    }
                    return SUCCESS;
                } else {
                    System.out.printf("Failed to sell specified amount. Current stock is %d.%n", numberInStock);
                    numberInStock = items[row][ITEM_COUNT];
                    return numberInStock;
                }
            }
        }
        System.out.println("Could not find item ID.");
        return FAILED;
    }
/**
 * This method prints the values of the sales array-
 * @param sales
 * @param salesDate
 */
    public static void printSales(final int[][] sales, final Date[] salesDate) {
        System.out.println();
        for (int row = 0; row < sales.length; row++) {
            for (int column = 0; column < sales[row].length; column++) {
                if (column == SALE_ITEM_ID && sales[row][column] != 0) {
                    System.out.printf("Date: %tD ItemID: %d, ", salesDate[row], sales[row][column]);
                } else if (column == SALE_ITEM_COUNT && sales[row][column] != 0) {
                    System.out.printf("Amound Sold: %d, ", sales[row][column]);
                } else if (column == SALE_ITEM_PRICE && sales[row][column] != 0) {
                    System.out.printf("Sum: %d %n", sales[row][column]);
                }
            }
        }
        System.out.println();
    }

/**
 * This method takes the sales array and sorts it in ascending order according to the Item ID.
 * Then it sorts the salesDate array to match the new index positions with sales.
 * @param sales
 * @param salesDate
 */
    public static void sortedTable(final int[][]sales, final Date[] salesDate) {
        for (int i = 0; i < sales.length - 1; i++) {
            for (int row = 0; row < (sales.length - i) - 1; row++) {
                if (sales[row][SALE_ITEM_ID] > sales[row + 1][SALE_ITEM_ID]) {
                    int[] temp = sales[row];
                    sales[row] = sales[row + 1];
                    sales[row + 1] = temp;

                    Date tempDate = salesDate[row];
                    salesDate[row] = salesDate[row + 1];
                    salesDate[row + 1] = tempDate;
                }
            }
        }
        printSales(sales, salesDate);
    }
}
