package items;

public class Weapon extends Item{
    private String damage = "";
    private String properties = "";

    public Weapon(String name, int value, double weight, String damage, String properties) {
        super(name, value, weight);
        this.damage = damage;
        this.properties = properties;
    }


    @Override
    public String toString() {
        return getName() + ":\nDamage: " + damage + "\nProperties: " + properties + "\n(Value: " + value + " gp, Weight: " + weight + " lb)";
    }
}
