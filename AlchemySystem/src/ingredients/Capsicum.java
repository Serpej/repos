package ingredients;

public class Capsicum extends Ingredient {

    String description = "Red fruits containing small white seeds. The fruit produces a peppery and hot liquid used in cooking as hot spice.";

    public Capsicum() {
        super("Capsicum", "Uncommon", "Hot spice");
    }

    @Override
    public String toString() {
        return "Capsicum";
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
