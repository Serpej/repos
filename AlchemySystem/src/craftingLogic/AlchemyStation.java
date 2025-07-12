/**
 * This class holds all the logic for crafting a potion and showing already crafted ones.
 */

package craftingLogic;

import java.util.List;

import recipes.*;
import ui.Ui;
import utils.Menus;
import ingredients.*;

public class AlchemyStation {
    RecipeBook recipeBook = new RecipeBook();
    Ui ui = new Ui();
    Menus menus = new Menus();
    

    public void craftPotion() {
        System.out.println("==== Alechemy Station ====");
        System.out.println();
        System.out.println("So, you want to create a potion?");
        System.out.println("Enter a number to choose a potion to see the what ingredients it requires: ");
        menus.displayRecipes();
        int answer = ui.intInput();
        //switch case time!
        // Make this when you've made all your potions
    }

    public void addIngredients() {
        System.out.println("Enter an ingredient from the list of ingredients using the numbers:");
        menus.displayIngredients();
        int answer = ui.intInput();

        //Make a new list (from the sorted method in Recipe Book)
        List<Ingredient> ingredients = recipeBook.getAllIngredientsSorted();

        // Check if the list contains the number.
        while (true) {
            if (answer > 0 && answer <= ingredients.size()) {
                for(int i = 0; i < ingredients.size(); i++) {
                    int rightPotionIndex = answer - 1;
                    if (i == rightPotionIndex) {
                        // Add ingredient to they concotion (List?)
                    }
                    break;
                }
            } else {
                System.out.println("Invalid potion number, try again.");
            }
        }


        // Find the potion using the arrayList index (-1).
        // Add ingredient to new potion
        // When done, add it to the list of recipes (if it succeeds).
        // If the potion doesn't match any of the already made object. go back to main menu.
    }

}
