/**
 *  Alchemy System
 * Concept: Combine Ingredient subclasses (like Herb, Mineral, Essence) to create Potion objects.
 *
 * Use a Map<String, Ingredient> and Map<String, Recipe>.
 *
 * Include polymorphic applyEffect() methods.
 * 
 * Great for reinforcing HashMap usage.
 *
 * Prepares you for database tables of ingredients and recipes.
 */

package app;

import inventory.Inventory;
import utils.Menus;

public class App {
    public static void main(String[] args) throws Exception {
        Menus menu = new Menus();
        Inventory inventory = new Inventory();

        int choice = 0;



        System.out.println("Welcome to your inventory");
        boolean inventoryOpen = true;
        while (inventoryOpen) {
            choice = menu.mainMenu();

            switch (choice) {
                case 1:
                    inventory.viewInventory();
                    break;
                case 2:
                    inventory.addItem();
                    break;
                case 3:
                    inventory.removeItem();
                    break;
                case 4:
                    inventory.editItem();
                    break;
                case 5:
                    inventory.sortInventory();
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
