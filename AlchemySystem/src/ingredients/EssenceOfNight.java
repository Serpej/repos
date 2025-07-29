package ingredients;

public class EssenceOfNight extends Ingredient {
    
    String description = "A pitch black opaque crystal. When staring at it you get a feeling that something stares back at you. Inate magic source.";

    public EssenceOfNight() {
        super("Essence of night", "Rare");
    }


    @Override
    public String toString() {
        return "Essence of night";
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
