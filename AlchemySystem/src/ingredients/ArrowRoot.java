
package ingredients;

public class ArrowRoot extends Ingredient {

    String description = "A thick white starchy powder without any special smell of taste.";

    public ArrowRoot() {
        super("Arrow Root", "Common", "Enhances precision");
    }

    @Override
    public String toString() {
        return "Arrow Root";
    }

    @Override
    public String describe() {
        return description;
    }
}

