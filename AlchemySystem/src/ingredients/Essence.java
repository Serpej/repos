package ingredients;

public class Essence extends Ingredient {
    
    String description = "";

    public Essence(String name, String rarity, String properties, String description) {
        super(name, rarity, properties);
        this.description = description;
    }

    @Override
    public String describe() {
        return description;
    }
}
