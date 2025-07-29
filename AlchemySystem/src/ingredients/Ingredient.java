package ingredients;

public abstract class Ingredient {
    private String name = "";
    private String rarity = "";

    public Ingredient(String name, String rarity) {
        this.name = name;
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public String getRarity() {
        return rarity;
    }



    public String toString() {
        return getName() + "\n" + getRarity() + "\n" + describe();
    }

    public abstract String describe();

    public abstract String getType();
}
