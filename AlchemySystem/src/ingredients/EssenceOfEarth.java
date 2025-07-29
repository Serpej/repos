package ingredients;

public class EssenceOfEarth extends Ingredient {
    
    String description = "A healthy earth brown colored crystal, shining brigthly green. When holding this crystal, you sense mother nature calling you back home. Inate magic source.";

    public EssenceOfEarth() {
        super("Essence of Earth", "Rare");
    }


    @Override
    public String toString() {
        return "Essence of Earth";
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
