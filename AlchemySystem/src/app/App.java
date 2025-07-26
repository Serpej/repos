package app;

import java.util.HashMap;
import java.util.Map;

import craftingLogic.AlchemyStation;
import utils.Menus;
import ui.Ui;
import potions.*;

import recipes.*;

public class App {
    public static void main(String[] args) throws Exception {
        Ui inputs = new Ui();
        int intAnswer = 0;

        RecipeBook recipeBook = new RecipeBook();
        Menus menus = new Menus(recipeBook);
        AlchemyStation alchemyStation = new AlchemyStation(recipeBook, menus);
        

        

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
                    menus.displayRecipes(); //Kanske att man borde kunna välja att se ett recept på en potion här med.
                    break;

                case 3:
                    boolean backToMain = alchemyStation.choosePotion();
                    if (backToMain) {
                        
                    }
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
