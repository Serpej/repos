/**
 * This class holds all the logic for crafting a potion and showing already crafted ones.
 */

package craftingLogic;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

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
    Ui ui = new Ui();
    
    Map<String, Integer> currentBrew = new HashMap<>();
    List<Potion> craftedPotions = new ArrayList<>();
   
    

    public Map<String, Integer> craftPotion(String chosenPotion) {
        System.out.println("==== Alechemy Station ====");
        boolean continueBrewing = true;
        while (continueBrewing) {
            currentBrew = addIngredients();
            System.out.println("This is the content of your current brew: ");
            System.out.println();
            viewBrewIngredients(currentBrew);
            System.out.println();
            System.out.println("Do you want to add another ingredient to your brew?");
            menus.intYesOrNo();
            int answer = ui.intInput();
            switch (answer) {
                case 1:
                    continue;            
                case 2:
                    continueBrewing = false;
                    break;
                default:
                    break;
            }
        }

        return currentBrew;
        
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
        boolean stayInCraftingStation = true;
        boolean potionWasMade = false;
        while (stayInCraftingStation) {
            System.out.println();
            menus.chosenPotionMenu(chosenPotion);
            System.out.println("Choose a number in the menu above: ");
            int answer = ui.intInput();
            switch (answer) {
                case 1:
                    currentBrew = craftPotion(chosenPotion);
                    printCurrentbrewAndRecipe(currentBrew, chosenPotion);
                    boolean rightIngredients = compareBrewWithPotion(chosenPotion, currentBrew);
                    if (rightIngredients) {
                        currentBrew.clear();
                        potionWasMade = makePotion(chosenPotion);
                        System.out.println("A " + chosenPotion + " was made and put into your list of crafted potions. Congratulations!");
                        return true;
                    } else {
                        System.out.println("The ingredients weren't quite right.\nThrew away the potion. Luckily it didn't blow up in your face...");
                        return true;
                    }
                case 2:
                    viewPotionIngredients(chosenPotion);
                    break;
                case 3:
                    //Remove ingredient
                    break;
                case 4:
                    System.out.println("New potion it is!");
                    choosePotion();
                    return true;
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
        menus.displayIngredientsShort();
        int answer = ui.intInput();
        System.out.println();
        
        List<Ingredient> ingredients = recipeBook.getAllIngredientsSorted();

        
        boolean ingredientNotFound = true;
        while (ingredientNotFound) {
            if (answer > 0 && answer <= ingredients.size()) {
                for(int i = 0; i < ingredients.size(); i++) {
                    int rightPotionIndex = answer - 1;
                    if (i == rightPotionIndex) {

                        System.out.println();
                        System.out.println("Enter the amount of " + ingredients.get(i).getName() + " would you like to add in numbers: ");
                        int amount = ui.intInput();
                        currentBrew.put(ingredients.get(i).getName(), amount);
                        System.out.println();
                        System.out.println(amount + " of " + ingredients.get(i).getName() + " was mixed in the brew.");
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

    public boolean compareBrewWithPotion(String chosenPotion, Map<String, Integer> currentBrew) {
        boolean found = false;
        for (Recipe recipe : recipeBook.getAllRecipes()) {
            if (recipe.getPotionName().equals(chosenPotion)) {
                if(recipe.getRecipe().equals(currentBrew)) {
                    found = true;
                    return true;
                }
            }
        }
        if (!found) {
            System.out.println("Could not find the potion you were trying to brew...");
        }
        return false;
    }

    public boolean makePotion(String chosenPotion) {
        for (Recipe recipe : recipeBook.getAllRecipes()) {
            if (recipe.getPotionName().equalsIgnoreCase(chosenPotion)) {
                Potion newPotion = new Potion(recipe.getPotionName(), recipe.getRecipe());
                craftedPotions.add(newPotion);
                return true;
            }
        }
        return false;
    }

    public void printCurrentbrewAndRecipe(Map<String, Integer> currentBrew, String chosenPotion) {
        System.out.println("==== Recipe for " + chosenPotion + " ====");
        viewPotionIngredients(chosenPotion);
        System.out.println();
        System.out.println("==== Your current brew ====");
        viewBrewIngredients(currentBrew);
        System.out.println();
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
        sortByKey(currentBrew);
    }

    public void viewCraftedPotions() {
        System.out.println();
        for (Potion potion : craftedPotions) {
            System.out.println(potion.getPotionName());
            potion.getRequiredIngredients();
            System.out.println();
        }
    }

    public void sortByKey(Map<String, Integer> brew) {
        TreeMap<String, Integer> sorted = new TreeMap<>();
        sorted.putAll(brew);

        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            String ingredientName = entry.getKey();
            int ingredientValue = entry.getValue();
            System.out.println("- " + ingredientValue + " x " + ingredientName);

        }
    }
}
