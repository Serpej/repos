
package ingredients;

public class ArrowRoot extends Ingredient {

    String description = "A thick white starchy powder without any special smell of taste. Enhances precision";

    public ArrowRoot() {
        super("Arrow Root", "Common");
    }

    @Override
    public String toString() {
        return "Arrow Root";
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

