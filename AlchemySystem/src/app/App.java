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

        RecipeBook bookOfRecipes = new RecipeBook();

        

        System.out.println("Welcome to the Alchemy table!");
        System.out.println();



        
        while (true) {
            menus.mainMenu();
            intAnswer = inputs.intInput();
            switch (intAnswer) {
                case 1:
                    menus.displayIngredients();
                    break;
                    
                case 2:
                    menus.displayRecipes();
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
