package recipes;

import java.util.Map;

public class PotionOfHealing extends Recipe {

    public PotionOfHealing() {
        super("Potion of Healing", Map.of("Water", 1,
                                                     "Essence of earth", 1,
                                                     "Aloe vera", 1,
                                                     "Valeriana",1 ));
    }
}
