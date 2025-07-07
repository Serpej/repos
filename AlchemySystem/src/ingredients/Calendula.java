package ingredients;

public class Calendula extends Ingredient {

    String description = "A sticky herb with yellow flowers, great for healing eye problems.";

    public Calendula(String name, String rarity, String properties, String description) {
        super(name, rarity, properties);
        this.description = description;
    }

    @Override
    public String toString() {
        return "Calendula";
    }

    @Override
    public String describe() {
        return description;
    }
}
