package recipes;

import java.util.Map;

public class PotionOfSpeed extends Recipe {

    public PotionOfSpeed() {
        super("Potion of Speed", Map.of("Water", 1, 
                                                   "Essence of Air", 1, 
                                                   "Beta Vulgaris", 1, 
                                                   "Swift Root", 2 ));
    }
}
