package utils;

import java.util.List;

import recipes.*;

public class Menus {
    RecipeBook recipeBook = new RecipeBook();


    public void mainMenu() {
        System.out.println();
        System.out.println("==== Main Menu ====");
        System.out.println("1. View ingredients");
        System.out.println("2. View recipies");
        System.out.println("3. Craft Potion");
        System.out.println("4. View all crafted potions");
        System.out.println("5. Exit program");
        System.out.println();
    }

    public void displayIngredients() {
        System.out.println();
        System.out.println("==== List of Ingredients ====");
        System.out.println();
        for (int i = 0; i < recipeBook.getAllIngredientsSorted().size(); i++) {
            int bullet = i + 1;
            System.out.println( bullet + ". "+ recipeBook.getAllIngredientsSorted().get(i).getName());
            System.out.println("  " + "'" + recipeBook.getAllIngredientsSorted().get(i).describe() + "'");
            System.out.println("-------------------------------------------------------");
            System.out.println();
        }
    }

    public void displayRecipes() {
        System.out.println();
        System.out.println("==== List of known Recipes ====");
        System.out.println();
        List<Recipe> recipes = recipeBook.getAllRecipes();
        for (int i = 0; i < recipes.size(); i++) {
            int bulletCounter = 1 + i;
            System.out.println(bulletCounter+ ". " + recipes.get(i).getPotionName());
        }
        System.out.println();
    }
}
