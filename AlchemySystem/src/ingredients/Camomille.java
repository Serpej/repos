package ingredients;

public class Camomille extends Ingredient {

    String description = "A herb with a flower of white petals and yellow middle. Smells lovely.";

    public Camomille() {
        super("Camomille", "Cncommon", "Causes sleepyness");
    }

    @Override
    public String toString() {
        return "Camomille";
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
