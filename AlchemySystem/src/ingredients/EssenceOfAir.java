package ingredients;

public class EssenceOfAir extends Ingredient {
    
    String description = "A transparent crystal containing a clear liquid. When listening closely you can hear the wind blowing inside.";

    public EssenceOfAir() {
        super("Essence of Air", "Rare", "Inate magic source");
    }


    @Override
    public String toString() {
        return "Essence of Air";
    }
    @Override
    public String describe() {
        return description;
    }

    @Override
    public String getType() {
        return "Essence";
    }
}
