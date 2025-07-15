package ingredients;

public class EssenceOfEarth extends Ingredient {
    
    String description = "A healthy earth brown colored crystal, shining brigthly green. When holding this crystal, you sense mother nature calling you back home.";

    public EssenceOfEarth() {
        super("Essence of Earth", "Rare", "Inate magic source");
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
