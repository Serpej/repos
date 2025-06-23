package inventory;
import items.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;



public class Inventory {
    private Map<String, Item> itemMap = new HashMap<>();
    private ArrayList<Item> items = new ArrayList<>();

    public Inventory() {
        HealingPotion healingPotion = new HealingPotion("Potion of Healing", 50, 0.5, 4);
        Armor paddedArmor = new Armor("Padded Armor", 5, 8.0, 11, "Disadvantage", 0);
        Weapon shortSword = new Weapon("Short Sword", 10, 2.0, "1d6 piercing", "Finesse, Light");
        items.add(healingPotion);
        items.add(paddedArmor);
        items.add(shortSword);
        for (Item item : items) {
            itemMap.put(item.getName(), item);
        }
    }

    public void viewInventory() {
        System.out.println();
        if (items.isEmpty()) {
            System.out.println("Your inventory is empty, A hole in the bag perhaps?");
        } else {
            System.out.println();
            System.out.println("---------- INVENTORY ----------");
            for (Item item : items) {
                System.out.println(item);
                System.out.println();
            }
        }
    }
}
