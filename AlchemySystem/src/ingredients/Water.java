package ingredients;

public class Water extends Ingredient {
    
    String description = "Clear water, simple but essential for life on Earth. Basic ingredient for life on Earth";
    
    public Water() {
        super("Water", "Common");

    }

       @Override
    public String toString() {
        return "Water";
    }
    @Override
    public String describe() {
        return description;
    }

    @Override
    public String getType() {
        return "Liquid";
    }
}
