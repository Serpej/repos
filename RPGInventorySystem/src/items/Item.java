package items;

public class Item {
    protected String name;
    protected int value;
    protected double weight;

    public Item(String name, int value, double weight) {
        this.name = name;
        this.value = value;
        this.weight =  weight;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public double getWeight() {
        return weight;
    }

    public String getDescription() {
        return name + " (value: " + value + " weight: " + weight + ")."; 
    }

    public void use() {
        System.out.println("You use the " + name + ".");
    }



    public String toString() {
        return getName() + " (Value: " + value + " gp, Weight: " + weight + " lb).";
    }
}
