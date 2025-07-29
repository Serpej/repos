package recipes;

import java.util.Map;

public class PotionOfSleep extends Recipe {

    public PotionOfSleep() {
        super("Potion of Sleep", Map.of("Water", 1, 
                                                   "Essence of night", 1,
                                                   "Camomille", 2,
                                                   "Valeriana", 1 ));
    }

}
