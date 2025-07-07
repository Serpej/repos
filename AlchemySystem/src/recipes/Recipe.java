/**
 * This class is for individual recipes, made out of different ingredients in different quantites.
 */

package recipes;

import java.util.Map;

public class Recipe {
    private String potionName;
    private Map<String, Integer> requiredIngredients;

    public Recipe(String potionName, Map<String, Integer> requiredIngredients) {
        this.potionName = potionName;
        this.requiredIngredients = requiredIngredients;
    }

    public String getPotionName() {
        return potionName;
    }

    public Map<String, Integer> getRequiredIngredients() {
        return requiredIngredients;
    }

    public void addRecipe() {

    }
}
