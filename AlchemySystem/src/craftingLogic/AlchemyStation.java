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
import potions.Potion;

public class AlchemyStation {
    private RecipeBook recipeBook;
    private Menus menus;

    public AlchemyStation(RecipeBook recipeBook, Menus menus) {
        this.recipeBook = recipeBook;
        this.menus = menus;
    }
    Map<String, Integer> currentBrew = new HashMap<>();
    Ui ui = new Ui();
    
    

    public void craftPotion(String chosenPotion) {
        System.out.println("==== Alechemy Station ====");
        boolean continueBrewing = true;
        while (continueBrewing) {
            currentBrew = addIngredients();
            System.out.println("This is the content of your current brew: ");
            System.out.println();
            viewBrewIngredients(currentBrew);
            System.out.println();
            System.out.println("Do you want to add another ingredient to your brew?"); //Continue with user input here.
            menus.intYesOrNo();
            int answer = ui.intInput();
            switch (answer) {
                case 1:
                    continue;            
                case 2:
                    System.out.println("Let's see if you made it correctly...!");
                    continueBrewing = false;
                    break;
                default:
                    break;
            }
        }
        
    }

    public boolean choosePotion() {
        while (true) {
            System.out.println();
            menus.displayRecipes();
            System.out.println("Enter the potion you want to brew by typing the name: ");
            String answer = ui.stringInput();

            boolean found = false;
            
            List<Recipe> recipes = recipeBook.getAllRecipes();
            for (Recipe recipe : recipes) {
                if (recipe.getPotionName().equalsIgnoreCase(answer)) {
                    found = true;
                    String chosenPotion = recipe.getPotionName();
                    System.out.println();
                    System.out.println("So you want to make a " + recipe.getPotionName() + "?");
                    boolean backToMain = chosenPotion(chosenPotion);
                    if (backToMain) {
                        return true;
                    }
                    break;
                }
            }
            if (!found) {
                System.out.println("The recipe you are looking for doesn't exist. Take a look at them and try again.");
            }
        }
    }

    public boolean chosenPotion(String chosenPotion) {
        boolean continueBrewing = true;
        while (continueBrewing) {
            System.out.println();
            menus.chosenPotionMenu(chosenPotion);
            System.out.println("Choose a number in the menu above: ");
            int answer = ui.intInput();
            switch (answer) {
                case 1:
                    craftPotion(chosenPotion);
                    continueBrewing = false; //If ett object blev skapat.
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
                    return true; // För att slippa gå tillbaka till gamla potionen sen.
                case 5:
                    System.out.println();
                    System.out.println("Threw the mixture in the compost. Better safe than sorry.");
                    return true;
                default:
                    break;
            }
        }
        return false;
    }

    public Map<String, Integer> addIngredients() {
        System.out.println();
        System.out.println("Enter an ingredient from the list of ingredients using the numbers:");
        menus.displayIngredients();
        int answer = ui.intInput();
        System.out.println();
        //Make a new list (from the sorted method in Recipe Book)
        List<Ingredient> ingredients = recipeBook.getAllIngredientsSorted();

        // Check if the list contains the number.
        boolean ingredientNotFound = true;
        while (ingredientNotFound) {
            if (answer > 0 && answer <= ingredients.size()) {
                for(int i = 0; i < ingredients.size(); i++) {
                    int rightPotionIndex = answer - 1;
                    if (i == rightPotionIndex) {

                        // Add an amount of the ingredient to the current brew.
                        System.out.println();
                        System.out.println("Enter the amount of " + ingredients.get(i).getName() + " would you like to add in numbers: ");
                        int amount = ui.intInput();
                        currentBrew.put(ingredients.get(i).getName(), amount);
                        System.out.println();
                        System.out.println(amount + " of " + ingredients.get(i).getName() + "was mixed in the brew.");
                        System.out.println();
                    }
                    ingredientNotFound = false;
                }
            } else {
                System.out.println("Invalid potion number, try again.");
            }
        }

        return currentBrew;
    }

    public void viewPotionIngredients(String potionName) {
        System.out.println();
        for (Recipe recipe : recipeBook.getAllRecipes()) {
            String recipeName = recipe.getPotionName();
            if (recipeName.equalsIgnoreCase(potionName)) {
                recipe.getRequiredIngredients();
            }
        }
    }

    public void viewBrewIngredients (Map<String, Integer> currentBrew) {
        for (Map.Entry<String, Integer> entry : currentBrew.entrySet()) {
            String ingredientName = entry.getKey();
            int ingredientValue = entry.getValue();
            System.out.println("- " + ingredientValue + " x " + ingredientName);
        }
    }
}
