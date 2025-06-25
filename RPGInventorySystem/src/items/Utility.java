package items;

/**
 * "Utility is a subclass of Item — it inherits all fields and methods from the Item class."
 */

public class Utility extends Item {
    String properties = "";

    public Utility(String name, int value, double weight, String properties) {
        super(name, value, weight);
        this.properties = properties;
    }

    @Override
    public String toString() {
        return getName() + ":\n" + properties + "\n(Value: " + value + " gp, Weight: " + weight + " lb)";
    }
}
