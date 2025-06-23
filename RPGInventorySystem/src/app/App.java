package app;

import inventory.Inventory;
import utils.Menus;
import gameUI.GameUI;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner userInput = new Scanner(System.in);
        Menus menu = new Menus();
        GameUI ui = new GameUI();
        Inventory inventory = new Inventory();
        System.out.println("Welcome to your inventory");

        boolean inventoryOpen = true;


        while (inventoryOpen) {
            menu.mainMenu();
            int choice = ui.intInput(userInput);

            switch (choice) {
                case 1:
                    inventory.viewInventory();
                    break;
                case 2:
                    //addItem();
                    break;
                case 3:
                    //removeItem();
                    break;
                case 4:
                    //editItem();
                    break;
                case 5:
                    //sortInventory();
                    break;
                case 6:
                    System.out.println("Closing Inventory");
                    System.exit(0);
                    break;
           
                default:
                    break;
            }
        }
    }
}
