package ingredients;

public abstract class Ingredient {
    protected String name = "";
    protected String type = "";
    protected String rarity = "";
    protected String properties = "";

    public Ingredient(String name, String type, String rarity, String properties) {
        this.name = name;
        this.type = type;
        this.rarity = rarity;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getRarity() {
        return rarity;
    }

    public String getProperties() {
        return properties;
    }

    public String toString() {
        return getName();
    }
}
