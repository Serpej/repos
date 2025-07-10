package ingredients;

public class Calendula extends Ingredient {

    String description = "A sticky herb with yellow flowers, great for healing eye problems.";

    public Calendula() {
        super("Calendula", "Uncommon", "Enhances eyesight");
    }

    @Override
    public String toString() {
        return "Calendula";
    }

    @Override
    public String describe() {
        return description;
    }

    @Override
    public String getType() {
        return "Herb";
    }
}
