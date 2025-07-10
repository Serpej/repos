package ingredients;

public class EssenceOfFire extends Ingredient {
    
    String description = "A glowing red crystal, warm to the touch. The longer you hold it in your hands, the hotter it gets.";

    public EssenceOfFire() {
        super("Essence of Fire", "Rare", "Inate magic source");
    }


    @Override
    public String toString() {
        return "Essence of Fire";
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
