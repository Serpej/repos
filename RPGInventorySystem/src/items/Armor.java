package items;

public class Armor extends Item {
   private int armorClass = 0;
    private String stealth = "";
    private int requiredStrength = 0;

    public Armor(String name, int value, double weight, int armorClass, String stealth, int requiredStrength) {
        super(name, value, weight); //Call the contstructor in Item!
        this.armorClass = armorClass;
        this.stealth = stealth;
        this.requiredStrength = requiredStrength;
    }

    @Override
    public String toString() {
        return getName() + ":\nAC: " + armorClass + "\nStealth: " + stealth + "\nRequired Strength: " + requiredStrength + "\n(Value: " + value + " gp, Weight: " + weight + " lb)";
    }
}
