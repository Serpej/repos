/**
 * This class is for created potions.
 */

package potions;

import ingredients.*;
import java.util.List;

public class Potion {
    private String name = "";
    private String effect = "";
    private int value = 0;
    private List<Ingredient> ingredients = null;

    public Potion (String name, String effect, int value, List<Ingredient> ingredients) {
        this.name = name;
        this.effect = effect;
        this.value = value;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
    public int getValue() {
        return value;
    }

    public String toString() {
        return name;
    }

    public void describe() {
        System.out.println("Potion: " + name);
        System.out.println("Effect: " + effect);
        System.out.println("Ingredients:");
        for (Ingredient ingredient : ingredients) {
            System.out.println();
            ingredient.getName();
            ingredient.describe(); // calls polymorph

        }
    }

    
}
