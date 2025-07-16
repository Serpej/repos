package recipes;

import java.util.Map;

public class PotionOfHealing extends Recipe {
    private String potionName;
    private Map<String, Integer> requiredIngredients;

    public PotionOfHealing() {
        super("Potion of Healing", Map.of("Water", 1, "Essence of Earth", 1, "Aloe Vera", 1, "Valeriana",1 ));
    }

    public String getPotionName() {
        return potionName;
    }

    @Override
    public  Map<String, Integer> getRequiredIngredients() {
        return requiredIngredients;
    }
}
