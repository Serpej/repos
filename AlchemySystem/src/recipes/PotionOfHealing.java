package recipes;

import java.util.Map;

public class PotionOfHealing extends Recipe {

    public PotionOfHealing() {
        super("Potion of Healing", Map.of("Water", 1,
                                                     "Essence of Earth", 1,
                                                     "Aloe Vera", 1,
                                                     "Valeriana",1 ));
    }
}
