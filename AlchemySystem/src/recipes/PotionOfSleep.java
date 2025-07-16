package recipes;

import java.util.Map;

public class PotionOfSleep extends Recipe {
    private String potionName;
    private Map<String, Integer> requiredIngredients;

    public PotionOfSleep() {
        super("Potion of Sleep", Map.of("Water", 1, "Essence of Night", 1, "Camomille", 2, "Valeriana", 1 ));
    }

    public String getPotionName() {
        return potionName;
    }

    @Override
    public  Map<String, Integer> getRequiredIngredients() {
        return requiredIngredients;
    }
}
