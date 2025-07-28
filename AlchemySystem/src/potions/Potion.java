/**
 * This class is for created potions.
 */

package potions;

import ingredients.*;
import java.util.Map;
import recipes.*;

public class Potion {
    private String name = "";
    private Map<String, Integer> ingredients = null;

    public Potion (String name, Map<String, Integer> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getPotionName() {
        return name;
    }
    public String toString() {
        return name;
    }

    public void getRequiredIngredients(){
        for (Map.Entry<String, Integer> entry : ingredients.entrySet()) {
            String ingredientName = entry.getKey();
            int ingredientValue = entry.getValue();
            System.out.println("- " + ingredientValue + " x " + ingredientName);
        }
    }
   
}
