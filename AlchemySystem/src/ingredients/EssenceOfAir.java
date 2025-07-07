package ingredients;

public class EssenceOfAir extends Ingredient {
    
    String description = "A transparent crystal containing a clear liquid. When listening closely you can hear the wind blowing inside.";

    public EssenceOfAir(String name, String rarity, String properties, String description) {
        super(name, rarity, properties);
        this.description = description;
    }

    @Override
    public String describe() {
        return description;
    }
}
