package ingredients;

public class BetaVulgaris extends Ingredient {
    
    String description = "A plant that gives many seeds. The root can be processed into sugar!";

    public BetaVulgaris() {
        super("Sugar Beet", "Cncommon", "Gives a temporary speed boost");
    }

    @Override
    public String toString() {
        return "Sugar Beet";
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
