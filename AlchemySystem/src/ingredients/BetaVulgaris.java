package ingredients;

public class BetaVulgaris extends Ingredient {
    
    String description = "A plant that gives many seeds. The root can be processed into sugar! Gives a temporary speed boost";

    public BetaVulgaris() {
        super("Beta vulgaris", "Common");
    }

    @Override
    public String toString() {
        return "Beta vulgaris";
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
