/**
 * This class is for created potions.
 */

package potions;

import ingredients.*;
import java.util.List;
import java.util.Map;
import recipes.*;

public class Potion {
    private String name = "";
    private Map<String, Integer> ingredients = null;

    public Potion (String name, Map<String, Integer> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }
    public String toString() {
        return name;
    }

    public void describe() {
        System.out.println("Potion: " + name);
        System.out.println("Ingredients:");
        recipes.getRequiredIngredients();
    }
   
}
