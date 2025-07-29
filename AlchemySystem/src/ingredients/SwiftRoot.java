package ingredients;

public class SwiftRoot extends Ingredient {

    String description = "A slick grass with a hary stem. easy to harvest but hard to get rid of. Boosts your walking speed";

    public SwiftRoot() {
        super("Swift root", "Uncommon");
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
