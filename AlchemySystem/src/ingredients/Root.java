
package ingredients;

public class Root extends Ingredient {

    String description = "";

    public Root(String name, String rarity, String properties, String description) {
        super(name, rarity, properties);
        this.description = description;
    }

    @Override
    public String describe() {
        return description;
    }
}

