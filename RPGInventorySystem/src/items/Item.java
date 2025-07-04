package items;
import gameUI.GameUI;
import utils.Menus;
import java.time.LocalDateTime;

public abstract class Item {
    protected String name;
    protected int value;
    protected double weight;
    protected LocalDateTime createdAt;

    public Item(String name, int value, double weight) {
        this.name = name;
        this.value = value;
        this.weight =  weight;
        this.createdAt = LocalDateTime.now();
    }

    public String toString() {
        return getName() + " (Value: " + value + " gp, Weight: " + weight + " lb).";
    }

    public abstract void edit(GameUI ui, Menus menu);

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public int getValue() {
        return value;
    }

    public int setValue(int value) {
        this.value = value;
        return value;
    }

    public double getWeight() {
        return weight;
    }

    public double setWeight(double weight) {
        this.weight = weight;
        return weight;
    }

    public String getDescription() {
        return name + " (value: " + value + " weight: " + weight + ")."; 
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
