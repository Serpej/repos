package ingredients;

public class Coal extends Ingredient {
    
    String description = "A black mineral, created by wood that's been densified by the Earth under a long period of time.";
    
    public Coal() {
        super("Coal", "Common", "Used for fire making.");

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
