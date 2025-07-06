package ingredients;

public class Herb extends Ingredient {

    String description = "";
    
    public Herb(String name, String rarity, String properties) {
        super(name, rarity, properties);
    }

    @Override
    public String describe() {
        return description;
    }
}
