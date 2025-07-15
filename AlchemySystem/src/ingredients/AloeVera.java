
package ingredients;

public class AloeVera extends Ingredient {

    String description = "Pointy succulent leaves that form an upwardspiraling rose.";

    public AloeVera() {
        super("Aloe vera", "Uncommon", "Soothes burned skin");
    }

    @Override
    public String toString() {
        return "Aloe vera";
    }

    @Override
    public String describe() {
        return description;
    }

    @Override
    public String getType() {
        return "Herb";
    }
}

