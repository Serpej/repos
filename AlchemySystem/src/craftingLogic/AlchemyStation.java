/**
 * This class holds all the logic for crafting a potion and showing already crafted ones.
 */

package craftingLogic;

import recipes.*;
import ui.Ui;
import utils.Menus;

public class AlchemyStation {
    RecipeBook recipeBook = new RecipeBook();
    Ui ui = new Ui();
    Menus menus = new Menus();
    

    public void craftPotion() {
        System.out.println("==== Alechemy Station ====");
        System.out.println();
        System.out.println("So, you want to create a potion?");
        System.out.println("Choose a potion to see the ingre");
        menus.displayRecipes();
        int answer = ui.intInput();
        //Maybe this should be a separate method in main menu? 
        


        System.out.println("Enter an ingredient from the list of ingredients using the numbers:");
        menus.displayIngredients();
        answer = ui.intInput();
        // Find the potion using the arrayList index (-1).
        // Add ingredient to new potion
        // When done, add it to the list of recipes (if it succeeds).
        // If the potion doesn't match any of the already made object. go back to main menu.
    }

}
