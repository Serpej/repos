package inventory;

import items.*;
import utils.Menus;
import java.util.ArrayList;
import java.util.Scanner;
import gameUI.GameUI;




public class Inventory {
    private ArrayList<Item> items = new ArrayList<>();
    Scanner userInput = new Scanner(System.in);
    GameUI ui = new GameUI();
    Menus menu = new Menus();

    public Inventory() {
        Utility healingPotion = new Utility("Potion of Healing", 50, 0.5, "Heals 4 + 1d4");
        Armor paddedArmor = new Armor("Padded Armor", 5, 8.0, 11, "Disadvantage", 0);
        Weapon shortSword = new Weapon("Short Sword", 10, 2.0, "1d6 piercing", "Finesse, Light");
        items.add(healingPotion);
        items.add(paddedArmor);
        items.add(shortSword);
    }

    public void viewInventory() {
        System.out.println();
        if (items.isEmpty()) {
            System.out.println("Your inventory is empty, A hole in the bag perhaps?");
        } else {
            System.out.println();
            System.out.println("---------- INVENTORY ----------");
            System.out.println();
            for (Item item : items) {
                System.out.println(item);
                System.out.println();
            }
        }
    }

    public void addItem() {
        
        System.out.println();
        System.out.println(" Enter a number to choose what to add:");
        System.out.println();
        int choice =  menu.addItemMenu();
        switch (choice) {
            case 1:
                createArmor();
                break;
            case 2:
                createWeapon();
                break;
            case 3:
                createUtilityItem();
                break;
            case 4:
                System.out.println();
                System.out.println("Exiting to main menu.");
                System.out.println();
                break;
        
            default:
                break;
        }
    }

    private void createArmor() {
        System.out.println("Enter a name for the Armor: ");
        String armorName = ui.stringInput();
        System.out.println();
        System.out.println("Enter the value for the Armor: ");
        int armorValue = ui.intInput();
        System.out.println();
        System.out.println("Enter the weight for the Armor: ");
        double armorWeight = ui.doubleInput();
        System.out.println();
        System.out.println("Enter the Armor Class for the Armor: ");
        int armorClass = ui.intInput();
        System.out.println();
        System.out.println("Does the armor gives you disadvantage on stealth? Enter 'Disadvantage' or 'None': ");
        String armorStealth = ui.stringInput();
        System.out.println();
        System.out.println("Enter the required Strength for the Armor: ");
        int armorStrength = ui.intInput();
        System.out.println();
        Armor newArmor = new Armor(armorName, armorValue, armorWeight, armorClass, armorStealth, armorStrength);
        items.add(newArmor);
    }

    private void createWeapon() {
        System.out.println("Enter a name for the Weapon: ");
        String weaponName = ui.stringInput();
        System.out.println();
        System.out.println("Enter the value for the Weapon: ");
        int weaponValue = ui.intInput();
        System.out.println();
        System.out.println("Enter the weight for the Weapon: ");
        double weaponWeight = ui.doubleInput();
        System.out.println();
        System.out.println("Enter the weapon damage: ");
        String weaponDamage = ui.stringInput();
        System.out.println();
        System.out.println("Enter any weapon properites: ");
        String weaponProperties = ui.stringInput();
        System.out.println();
        Weapon newWeapon = new Weapon(weaponName, weaponValue, weaponWeight, weaponDamage, weaponProperties);
        items.add(newWeapon);
    }

        private void createUtilityItem() {
        System.out.println("Enter a name for the item ");
        String utilityName = ui.stringInput();
        System.out.println();
        System.out.println("Enter the value for the item: ");
        int utilityValue = ui.intInput();
        System.out.println();
        System.out.println("Enter the weight for the item: ");
        double utilityWeight = ui.doubleInput();
        System.out.println();
        System.out.println("Enter any item properites: ");
        String utilityProperties = ui.stringInput();
        System.out.println();
        Utility newUtility = new Utility(utilityName, utilityValue, utilityWeight, utilityProperties);
        items.add(newUtility);
    }

    public void removeItem() {
        Item itemToRemove = null;
        System.out.println("Enter the name of an item you want removed: ");
        String answer = ui.stringInput();
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(answer)) {
                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove != null) {
            System.out.println();
            items.remove(itemToRemove);
            System.out.println(itemToRemove.getName() + " was removed form your inventory.");
        } else {
            System.out.println();
            System.out.println("Item not found.");
        }
        
    }

    public void editItem() {
        Item itemToEdit = null;
        boolean found = false;
        System.out.println();
        System.out.println("Enter the name of an item you want to edit: ");
        String answerString = ui.stringInput();
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(answerString)) {
                itemToEdit= item;
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println();
            System.out.println("Item not found.");
        } else {
            itemToEdit.edit(ui, menu);
        }

    }

    public void sortInventory() {
        System.out.println("How would you like to sort your Inventory? Enter a number: ");
        menu.sortInventoryMenu();
        int answerInt = ui.intInput();
        switch(answerInt) {
            case 1:
                //sortAlpabetically(items);
                break;
            
            case 2:
                //sortByType(items);
                break;

            case 3:
                //sortChronologically(items);
                break;
        }
    }

}
