package ingredients;

public class BetaVulgaris extends Ingredient {
    
    String description = "A plant that gives many seeds. The root can be processed into sugar! Gives a temporary speed boost";

    public BetaVulgaris() {
        super("Beta Vulgaris", "Common");
    }

    @Override
    public String toString() {
        return "Beta Vulgaris";
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
