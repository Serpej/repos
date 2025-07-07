/**
 * This class is made to hold all the ingredients, to view in the program.
 */

package recipes;

import java.util.HashMap;
import java.util.Map;

public class RecipeBook {
    
    private Map<String, Recipe> recipes = new HashMap<>();

    public void addRecipe(Recipe recipe) {
    recipes.put(recipe.getPotionName(), recipe);
    }

    public Recipe getRecipe(String potionName) {
        return recipes.get(potionName);
    }

    public boolean hasRecipe(String potionName) {
        return recipes.containsKey(potionName);
    }
}



