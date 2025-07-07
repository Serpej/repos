package app;

import java.util.HashMap;
import java.util.Map;

import utils.Menus;
import ui.Ui;

import recipes.*;

public class App {
    public static void main(String[] args) throws Exception {
        Menus menus = new Menus();
        Ui inputs = new Ui();
        int intAnswer = 0;

        RecipeBook book = new RecipeBook();

        // Define the required ingredients by name and quantity
        Map<String, Integer> potionOfPrecisionIngredients = new HashMap<>();
        potionOfPrecisionIngredients.put("Arrow Root", 1);
        potionOfPrecisionIngredients.put("Essence of Air", 1);
        potionOfPrecisionIngredients.put("Calendula", 2);

        // Create the recipe object
        Recipe potionOfPrecisionRecipe = new Recipe("Potion of Precision", potionOfPrecisionIngredients);

        System.out.println("Welcome to the Alchemy table!");
        System.out.println();



        
        while (true) {
            menus.mainMenu();
            intAnswer = inputs.intInput();
            switch (intAnswer) {
                case 1:
                    //viewIngredients
                    break;
                    
                case 2:
                    //viewRecipies
                    break;

                case 3:
                    //craftPotion
                    break;

                case 4:
                    //viewCraftedPotions
                    break;
                    
                case 5:
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;
            
                default:
                    break;
            }
        }

        
    }
}
