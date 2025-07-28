/**
 * This class is made to hold all the ingredients and recipes in separate lists, to view in the program.
 */

package recipes;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


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
        ingredientLibrary.add(new SwiftRoot());
        ingredientLibrary.add(new BetaVulgaris());
        ingredientLibrary.add(new EssenceOfNight());
        ingredientLibrary.add(new Valeriana());
        ingredientLibrary.add(new Camomille());
        ingredientLibrary.add(new AloeVera());
        ingredientLibrary.add(new EssenceOfEarth());
    }

    private void loadRecipes() {
        // adding a recipe to the ArrayList (A recipe object contains a potionName and a map (which contains any numner of key:values, in this case "ingredient name", quantity))
        recipes.add(new PotionOfPrecision());
        recipes.add(new PotionOfFirebreathing());
        recipes.add(new PotionOfSpeed());
        recipes.add(new PotionOfSleep());
        recipes.add(new PotionOfHealing());
    }

    public List<Ingredient> getAllIngredientsSorted() {
        ingredientLibrary.sort(Comparator.comparing(Ingredient::getType));
        return Collections.unmodifiableList(ingredientLibrary);
    } 

    public List<Recipe> getAllRecipes() {
        return Collections.unmodifiableList(recipes);
    } 
}



