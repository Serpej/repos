package app;
import utils.Menus;
import ui.Ui;
public class App {
    public static void main(String[] args) throws Exception {
        Menus menus = new Menus();
        Ui inputs = new Ui();
        int intAnswer = 0;

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
