package ingredients;

public class Valeriana extends Ingredient {

    String description = "A sticky herb with yellow flowers, great for healing eye problems. Causes drowsyness and relaxation";

    public Valeriana() {
        super("Valeriana", "Uncommon");
    }

    @Override
    public String toString() {
        return "Valeriana";
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
