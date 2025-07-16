package recipes;

import java.util.Map;

public class PotionOfFirebreathing extends Recipe {
    private String potionName;
    private Map<String, Integer> requiredIngredients;

    public PotionOfFirebreathing() {
        super("Potion of Fire Breathing", Map.of("Water", 1, "Essence of Fire", 1, "Coal", 1, "Capsicum", 1));
    }

    public String getPotionName() {
        return potionName;
    }

    @Override
    public  Map<String, Integer> getRequiredIngredients() {
        return requiredIngredients;
    }
}
