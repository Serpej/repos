/**
 * This class is for individual recipes, made out of different ingredients in different quantites.
 */

package recipes;

import java.util.Map;



public abstract class Recipe {
    private String potionName;
    private Map<String, Integer> requiredIngredients;

    public Recipe(String potionName, Map<String, Integer> requiredIngredients) {
        this.potionName = potionName;
        this.requiredIngredients = requiredIngredients;
    }

    public String getPotionName() {
        return potionName;
    }

    public Map<String, Integer> getRecipe() {
        return requiredIngredients;
    }

    public void getRequiredIngredients(){
        for (Map.Entry<String, Integer> entry : requiredIngredients.entrySet()) {
            String ingredientName = entry.getKey();
            int ingredientValue = entry.getValue();
            System.out.println("- " + ingredientValue + " x " + ingredientName);
        }
    }

    public void describe() {
        System.out.println("Potion: " + potionName);
        System.out.println("Ingredients:");
        this.getRequiredIngredients();
    }
}
