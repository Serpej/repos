
package ingredients;

public class ArrowRoot extends Ingredient {

    String description = "A thick white starchy powder, ingesting it enhances precision.";

    public ArrowRoot(String name, String rarity, String properties, String description) {
        super(name, rarity, properties);
        this.description = description;
    }

    @Override
    public String toString() {
        return "Arrow Root";
    }

    @Override
    public String describe() {
        return description;
    }
}

