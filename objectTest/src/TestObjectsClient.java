public class TestObjectsClient {
    public static void main(String[] args) throws Exception {
        
        // Classname var = new Classname();
        // Java works right to left. First it assigns new memory and then it ties it to the variable.
        Animal animal1 = new Animal();

        //initialize variables animal1 object


        // animal1.name  = "Cow";
        // animal1.age = 16;
        // animal1.sound = "Moo";

        Animal animal2 = new Animal("Sheep", "Beeeeh");

        // animal2.name = "Sheep";
        // animal2.age = 14;
        // animal2.sound = "Beeeeeh";

        //Run the method creates in Animal to get the specific animals info.
        animal1.info();
        animal2.info();

        // After creating a constructor in Animal, you can call the method here when making a new object to set its values.
        Animal animal3 = new Animal("Pig", "Oink");
        animal3.info();

        animal3.getAge();
        animal3.setAge(55);
        animal3.getAge();

    }
}
