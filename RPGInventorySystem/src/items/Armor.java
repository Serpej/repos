/** 
 * This class contains all the information to create and edit an armor.
 */
package items;

import gameUI.GameUI;
import utils.Menus;

public class Armor extends Item {
   private int armorClass = 0;
    private String stealth = "";
    private int requiredStrength = 0;

    public Armor(String name, int value, double weight, int armorClass, String stealth, int requiredStrength) {
        super(name, value, weight);
        this.armorClass = armorClass;
        this.stealth = stealth;
        this.requiredStrength = requiredStrength;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public String getStealth() {
        return stealth;
    }

    public void setStealth(String stealth) {
        this.stealth = stealth;
    }

    public int getRequiredStrength() {
        return requiredStrength;
    }

    public void setRequiredStrength(int requiredStrength) {
        this.requiredStrength = requiredStrength;
    }


    @Override
    public String toString() {
        return getName() + ":\nAC: " + armorClass + "\nStealth: " + stealth + "\nRequired Strength: " + requiredStrength + "\n(Value: " + value + " gp, Weight: " + weight + " lb)";
    }

     @Override
    public void edit(GameUI ui, Menus menu) {
        int answerInt = 0;
        String answerString = "";
        double answerDouble = 0.0;
        System.out.println();
        System.out.println("Enter the number of the attribute you want to change: ");
        menu.viewEditArmor();
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
                System.out.println("Enter the new armor class for the armor: ");
                answerInt = ui.intInput();
                setArmorClass(answerInt);
                System.out.println(getName() + " has been edited.");
                break;
            
            case 4:
                System.out.println("Enter if the armor gives disadvantage on stealth (either 'disadvantage' or leave empty): ");
                answerString = ui.stringInput();
                setStealth(answerString);
                System.out.println(getName() + " has been edited.");
                break;

            case 5:
                System.out.println("Enter the new required strength for the armor: ");
                answerInt = ui.intInput();
                setRequiredStrength(answerInt);
                System.out.println(getName() + " has been edited.");
                break;
            default:
                break;
        }
    }
}
