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
    

    public Inventory() {
        HealingPotion healingPotion = new HealingPotion("Potion of Healing", 50, 0.5, 4);
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
        Menus menu = new Menus();
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
                
                break;
            case 4:
                
                break;
            case 5:
                
                break;
        
            default:
                break;
        }
    }

    private void createArmor() {
        System.out.println("Enter a name for the Armor: ");
        String armorName = ui.stringInput(userInput);
        System.out.println();
        System.out.println("Enter the value for the Armor: ");
        int armorValue = ui.intInput(userInput);
        System.out.println();
        System.out.println("Enter the weight for the Armor: ");
        double armorWeight = ui.doubleInput(userInput);
        System.out.println();
        System.out.println("Enter the Armor Class for the Armor: ");
        int armorClass = ui.intInput(userInput);
        System.out.println();
        System.out.println("Does the armor gives you disadvantage on stealth? Enter 'Disadvantage' or 'None': ");
        String armorStealth = ui.stringInput(userInput);
        System.out.println();
        System.out.println("Enter the required Strength for the Armor: ");
        int armorStrength = ui.intInput(userInput);
        System.out.println();
        Armor newArmor = new Armor(armorName, armorValue, armorWeight, armorClass, armorStealth, armorStrength);
        items.add(newArmor);
    }

    private void createWeapon() {
        System.out.println("Enter a name for the Weapon: ");
        String weaponName = ui.stringInput(userInput);
        System.out.println();
        System.out.println("Enter the value for the Weapon: ");
        int weaponValue = ui.intInput(userInput);
        System.out.println();
        System.out.println("Enter the weight for the Weapon: ");
        double weaponWeight = ui.doubleInput(userInput);
        System.out.println();
        System.out.println("Enter the weapon damage: ");
        String weaponDamage = ui.stringInput(userInput);
        System.out.println();
        System.out.println("Enter any weapon properites: ");
        String weaponProperties = ui.stringInput(userInput);
        System.out.println();
        Weapon newWeapon = new Weapon(weaponName, weaponValue, weaponWeight, weaponDamage, weaponProperties);
        items.add(newWeapon);
    }
}
