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
        ingredientLibrary.add(new Water());
        ingredientLibrary.add(new EssenceOfFire());
        ingredientLibrary.add(new Coal());
        ingredientLibrary.add(new Capsicum());
        // Add more as needed
    }

    private void loadRecipes() {
        // adding a recipe to the ArrayList (A recipe object contains a potionName and a map (which contains any numner of key:values, in this case "ingredient name", quantity))
        recipes.add(new Recipe("Potion of Precision", Map.of("Water", 1, "Arrow Root", 2, "Essence of Air", 1, "Calendula", 2)));
        recipes.add(new Recipe("Potion of Fire Breathing", Map.of("Water", 1, "Essence of Fire", 1, "Coal", 1, "Capsicum", 1)));

    }

    public List<Ingredient> getAllIngredientsSorted() {
        return Collections.unmodifiableList(ingredientLibrary);
    } 

    public List<Recipe> getAllRecipes() {
        return Collections.unmodifiableList(recipes);
    } 
}



