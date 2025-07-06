package ingredients;

public class Mineral extends Ingredient {
    
    String description = "";

    public Mineral(String name, String rarity, String properties, String description) {
        super(name, rarity, properties);
        this.description = description;
    }

    @Override
    public String describe() {
        return description;
    }
}
