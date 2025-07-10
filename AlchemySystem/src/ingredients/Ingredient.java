package ingredients;

public abstract class Ingredient {
    private String name = "";
    private String rarity = "";
    private String properties = "";

    public Ingredient(String name, String rarity, String properties) {
        this.name = name;
        this.rarity = rarity;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public String getRarity() {
        return rarity;
    }

    public String getProperties() {
        return properties;
    }

    public String toString() {
        return getName() + "\n" + getRarity() + "\n" + getProperties();
    }

    public abstract String describe();

    public abstract String getType();
}
