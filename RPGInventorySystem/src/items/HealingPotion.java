package items;

import java.util.Random;
/**
 * "HealingPotion is a subclass of Item — it inherits all fields and methods from the Item class."
 */

public class HealingPotion extends Item  {
    private int HealingAmount;

    Random random = new Random();
    int d4 = random.nextInt(4) + 1;
    

    public HealingPotion(String name, int value, double weight, int HealingAmount) {
        super(name, value, weight); // Call the constructor in Item.
        this.HealingAmount = HealingAmount + d4;
    }

    @Override
    public void use() {
        System.out.println("You drink the " + name + " and recover " + HealingAmount + " HP.");
    }

    @Override
    public String toString() {
        return getName() + ":\nHeals 4 + 1d4 HP\n(Value: " + value + " gp, Weight: " + weight + " lb)";
    }
}
