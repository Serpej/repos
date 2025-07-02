package utils;

import java.util.Scanner;
import gameUI.GameUI;

public class Menus {

    Scanner userInput = new Scanner(System.in);
    GameUI ui = new GameUI();

    /**
     * This method prints the main menu and takes a validated integer from the user, and returns it.
     * @return
     */
    public int mainMenu() {
        int choice = 0;
        boolean isWrongNumber = true;
        while (isWrongNumber) {
            System.out.println();
            System.out.println("---------- MENU ----------");
            System.out.println("1. View Inventory");
            System.out.println("2. Add an item to inventory");
            System.out.println("3. Remove an item from inventory");
            System.out.println("4. Edit item in inventory");
            System.out.println("5. Sort inventory");
            System.out.println("6. Exit inventory");
            System.out.println();
            choice = ui.intInput();
            if (choice < 7 && choice > 0) {
                isWrongNumber = false;
            } else {
                System.out.println("You need to enter a number between 1 and 6. Try again.");
            }
        }
        return choice;
    }

    /**
     * This method prints the add item menu and takes a validated integer from the user, and returns it.
     * @return
     */
    public int addItemMenu() {
        int choice = 0;
        boolean isWrongNumber = true;
        while (isWrongNumber) {
            System.out.println();
            System.out.println("1. Add a new armor");
            System.out.println("2. Add a new weapon");
            System.out.println("3. Add a utility item");
            System.out.println("4. Exit to main menu");
            System.out.println();
            choice = ui.intInput();
            if (choice < 6 && choice > 0) {
                isWrongNumber = false;
            } else {
                System.out.println("You need to enter a number between 1 and 4. Try again.");
            }
        }
        return choice;
    }

    public void viewEditWeapon() {
        System.out.println();
        System.out.println("1. Edit value");
        System.out.println("2. Edit weight");
        System.out.println("3. Edit damage");
        System.out.println("4. Edit properties");
        System.out.println();
    }
    

    public void viewEditArmor() {
        System.out.println();
        System.out.println("1. Edit value");
        System.out.println("2. Edit weight");
        System.out.println("3. Edit armor class");
        System.out.println("4. Edit disadvantage on stealth for armor");
        System.out.println("4. Edit the required strength for the armor");
        System.out.println();
    }


    public void viewEditUtility() {
        System.out.println();
        System.out.println("1. Edit value");
        System.out.println("2. Edit weight");
        System.out.println("3. Edit properties");
        System.out.println();
    }

    public void sortMenu() {
        System.out.println();
        System.out.println("1. Alphabetical");
        System.out.println("2. By type");
        System.out.println("3. Chronolocial");
    }

}
