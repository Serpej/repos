package ingredients;

public class SwiftRoot extends Ingredient {

    String description = "A slick grass with a hary stem. easy to harvest but hard to get rid of.";

    public SwiftRoot() {
        super("Swift root", "Uncommon", "Boosts your walking speed");
    }

    @Override
    public String toString() {
        return "Swift root";
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
