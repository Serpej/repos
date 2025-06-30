// Här försöker jag hålla på med indepencence, "extends" men har inte helt fattat än. Lycka till!

public class Vehicle {
    String brand;
    Vehicle() {
        brand = "unkown";
    }
    public void setVehicle(String brand) {
        this.brand = brand;
    }
    public void honk() {
        System.out.println("Vehicle honks.");
    }
}

