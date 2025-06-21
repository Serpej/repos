import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class TestHashMap {

    public static class Fruit {
        String name;
        Fruit(String name) {
            this.name = name;
        }
        
        @Override
        public String toString() {
            return name;
        }

    }
    public static void main(String[] args) throws Exception {

        // An array of usernames
        String[] userNames = {"fruit 1", " 2", "fruit 3"};

        // An ArrayList of objects
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit("apple"));
        fruits.add(new Fruit("orange"));
        fruits.add(new Fruit("banana"));


        // Create a Hash Map (key: String, value: Object)
        HashMap<String, Fruit> map = new HashMap<>();
        for (int i = 0; i < fruits.size(); i++) {
            map.put(userNames[i], fruits.get(i)); // Map username to the fruit.
        }

        for (int i = 0; i < fruits.size(); i++) {
            Fruit userNameToFruit = map.get(userNames[i]);
            System.out.println(userNameToFruit);
        }

    }
}
