package recipes;

import java.util.Map;

public class PotionOfSpeed extends Recipe {
    private String potionName;
    private Map<String, Integer> requiredIngredients;

    public PotionOfSpeed() {
        super("Potion of Speed", Map.of("Water", 1, "Essence of Air", 1, "Beta vulgaris", 1, "Swift Root", 2 ));
    }

    public String getPotionName() {
        return potionName;
    }

    @Override
    public  Map<String, Integer> getRequiredIngredients() {
        return requiredIngredients;
    }
}
