/** 
 * This class contains all the information to create and edit a utility item, liek a Potion of Healing.
 */
package items;

import gameUI.GameUI;
import utils.Menus;

public class Utility extends Item {
    String properties = "";

    public Utility(String name, int value, double weight, String properties) {
        super(name, value, weight);
        this.properties = properties;
    }

    public String getProperties(String properties) {
        return properties;
    } 

    public String setProperties(String properties) {
        this.properties = properties;
        return properties; 
    }

    @Override
    public String toString() {
        return getName() + ":\n" + properties + "\n(Value: " + value + " gp, Weight: " + weight + " lb)";
    }

    @Override
    public void edit(GameUI ui, Menus menu) {
        int answerInt = 0;
        String answerString = "";
        double answerDouble = 0.0;
        System.out.println();
        System.out.println("Enter the number of the attribute you want to change: ");
        menu.viewEditUtility();
        answerInt = ui.intInput();
        switch (answerInt) {
            case 1:
                System.out.println("Enter a new value: ");
                answerInt = ui.intInput();
                setValue(answerInt);
                System.out.println("The new value of " + getName() + " is " + answerInt + " gp.");
                break;
                    
            case 2:
                System.out.println("Enter a new weight: ");
                answerDouble = ui.doubleInput();
                setWeight(answerDouble);
                System.out.println("The new weight of " + getName() + " is " + answerDouble + " lb.");
                break;
        
            case 3:
                System.out.println("Enter the new properties for the item: ");
                answerString = ui.stringInput();
                setProperties(answerString);
                System.out.println(getName() + " has been edited.");
                break;
        
            default:
                break;
        }
    }
}
