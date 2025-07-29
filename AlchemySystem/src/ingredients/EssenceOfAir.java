package ingredients;

public class EssenceOfAir extends Ingredient {
    
    String description = "A transparent crystal containing a clear liquid. When listening closely you can hear the wind blowing inside. Inate magic source.";

    public EssenceOfAir() {
        super("Essence of air", "Rare");
    }


    @Override
    public String toString() {
        return "Essence of air";
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
