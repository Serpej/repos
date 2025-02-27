import java.util.Scanner;

public class ExerciseInput {
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);
        userInput.useDelimiter("[:/\\s]+");

        System.out.println("Enter a path: ");

        System.out.println(userInput.next());
        System.out.println(userInput.next());
        System.out.println(userInput.next());
        
        System.exit(0);
     }
}