package ingredients;

public class Coal extends Ingredient {
    
    String description = "A black mineral, created by wood that's been densified by the Earth under a long period of time. Used for fire making.";
    
    public Coal() {
        super("Coal", "Common");

    }

       @Override
    public String toString() {
        return "Coal";
    }
    @Override
    public String describe() {
        return description;
    }

    @Override
    public String getType() {
        return "Mineral";
    }
}
