package ingredients;

public class EssenceOfNight extends Ingredient {
    
    String description = "A pitch black opaque crystal. When staring at it you get a feeling that something stares back at you...";

    public EssenceOfNight() {
        super("Essence of Night", "Rare", "Inate magic source");
    }


    @Override
    public String toString() {
        return "Essence of Night";
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
