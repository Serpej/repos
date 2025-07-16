package recipes;

import java.util.Map;

public class PotionOfPrecision extends Recipe {
    private String potionName;
    private Map<String, Integer> requiredIngredients;

    public PotionOfPrecision() {
        super("Potion of Precision", Map.of("Water", 1, "Arrow Root", 2, "Essence of Air", 1, "Calendula", 2));
    }

    public String getPotionName() {
        return potionName;
    }

    @Override
    public  Map<String, Integer> getRequiredIngredients() {
        return requiredIngredients;
    }
}
