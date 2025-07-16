/**
 * This class holds all the logic for crafting a potion and showing already crafted ones.
 */

package craftingLogic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import recipes.*;
import ui.Ui;
import utils.Menus;
import ingredients.*;

public class AlchemyStation {
    RecipeBook recipeBook = new RecipeBook();

    Map<String, Integer> currenctBrew = new HashMap<>();

    Ui ui = new Ui();
    Menus menus = new Menus();
    

    public void craftPotion() {
        System.out.println("==== Alechemy Station ====");
        choosePotion();
        while (true) {
            addIngredients();
            System.out.println("Do you want to add another ingredient to your brew?"); //Continue with user input here.
        }
        
    }

public void choosePotion() {
    while (true) {
        System.out.println();
        menus.displayRecipes();
        System.out.println("Enter the potion you want to brew: ");
        String answer = ui.stringInput();
        
        List<Recipe> recipes = recipeBook.getAllRecipes();
        for (Recipe recipe : recipes) {
            if (recipe.getPotionName().equalsIgnoreCase(answer)) {
                String chosenPotion = recipe.getPotionName();
                System.out.println("So you want to make a " + recipe.getPotionName() + "?");
                System.out.println();
                chosenPotion(chosenPotion);
                break;
            } else {
                System.out.println("The recipe you are looking for doesn't exist. Take a look at them and try again.");
            }
        }
    }
}

public void chosenPotion(String chosenPotion) {
    System.out.println();
    menus.chosenPotionMenu();
    System.out.println("Choose a number in the menu above: ");
    int answer = ui.intInput();
    switch (answer) {
        case 1:
            //Craft Potion
            break;
        case 2:
            viewPotionIngredients(chosenPotion);
            break;
        case 3:
            //Remove ingredient
            break;
        case 4:
            System.out.println("New potion it is!");
            choosePotion();
            break;
        case 5:
            System.out.println("Threw the mixture in the compost. Better safe than sorry.");
            break;

        default:
            break;
    }
}

public void addIngredients() {
    System.out.println();
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

                    // Add an amount of the ingredient to the current brew.
                    System.out.println("Enter the amount of " + ingredients.get(i).getName() + "would you like to add in numbers: ");
                    int amount = ui.intInput();
                    currenctBrew.put(ingredients.get(i).getName(), amount);
                    System.out.println(amount + " of " + ingredients.get(i).getName() + "was mixed in the brew.");
                    System.out.println();
                }
                break;
            }
        } else {
            System.out.println("Invalid potion number, try again.");
        }
    }
        // Add ingredient to new potion
        // When done, add it to the list of recipes (if it succeeds).
        // If the potion doesn't match any of the already made object. go back to main menu.
}

public void viewPotionIngredients(String potionName) {
    for (Recipe recipe : recipeBook.getAllRecipes()) {
        String recipeName =recipe.getPotionName();
        if (recipeName.equalsIgnoreCase(potionName)) {
            recipe.getRequiredIngredients();
        }
    }
}
}
