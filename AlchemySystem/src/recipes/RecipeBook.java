/**
 * This class is made to hold all the ingredients and recipes in separate lists, to view in the program.
 */

package recipes;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;


import ingredients.*;

public class RecipeBook {

    private List<Ingredient> ingredientLibrary = new ArrayList<>();
    private List<Recipe> recipes = new ArrayList<>();

    public RecipeBook() {
        loadIngredients();
        loadRecipes();
    }

    private void loadIngredients() {
        ingredientLibrary.add(new ArrowRoot());
        ingredientLibrary.add(new Calendula());
        ingredientLibrary.add(new EssenceOfAir());
        // Add more as needed
    }

    private void loadRecipes() {
        // adding a recipe to the ArrayList (A recipe object contains a potionName and a map (which contains any numner of key:values, in this case "ingredient name", quantity))
        recipes.add(new Recipe("Potion of Precision", Map.of("Arrow Root", 2, "Essence of Air", 1, "Calendula", 2)));
    }

    public List<Ingredient> getAllIngredients() {
        return Collections.unmodifiableList(ingredientLibrary);
    } 

    public List<Recipe> getAllRecipes() {
        return Collections.unmodifiableList(recipes);
    } 

    public void displayIngredients() {
        System.out.println("==== List of Ingredients ====");
        System.out.println();
        for (int i = 0; i < ingredientLibrary.size(); i++) {
            int bullet = i + 1;
            System.out.println( bullet + ". "+ ingredientLibrary.get(i).getName());
            System.out.println("  " + "'" + ingredientLibrary.get(i).describe() + "'");
            System.out.println();
        }
    }

    public void displayRecipes() {
        System.out.println("==== List of known Recipes ====");
        for (Recipe recipe : recipes) {
            System.out.println("- " + recipe.getPotionName());
        }
        System.out.println();
    }
}



