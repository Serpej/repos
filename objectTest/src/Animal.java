public class Animal {
 
   // instance variables
   private String name;
   private int age;
   private String sound;

   //Constructor, initializes values as an object is created.
   Animal() {
      // Age is set to 1 for all animals unless changed.
      age = 1;
      name = "unknown";
      sound = "unknown";
   }
   //Overloading (same method name, different parameters)
   //Use this to avoid shadowing. For example "name = name" would have no effect beacuse the parameter would refer to itself.
   Animal(String name, String sound) {
      this.name = name;
      this.sound = sound;
      age = 2;
   }



   void info() {
      System.out.println("The animal " +  name + " is " + age + " years old. " + name + " goes " + sound + ".");
   }

   //Here is a getter (or formally known as a “accessors”), this getter gives "read only" info, since the instance variables are private.
   public int getAge() {
      System.out.println(name);
      System.out.println(age);
      return age;
   }

   //If we decide that we want the client to be able to modify the varible, we can make a setter (or formally called a mutator).
   public void setAge(int age) {
      this.age = age;
   }

}
