import java.util.Scanner;

public class mixedInput {
    public static void main(String[] args) {
        int age;
        String name;
        String ageString;
      
        Scanner userInput = new Scanner(System.in);
        // userInput.useDelimiter("[\\s\n]+");
           
        System.out.print("How old are you?: ");
        ageString = userInput.nextLine();
        age = Integer.parseInt(ageString);
           
        System.out.print("What is your name?: ");
        name = userInput.nextLine();
                 
        System.out.println("Your name is " + name + " and you are " + age + " years old");  
    }
}
