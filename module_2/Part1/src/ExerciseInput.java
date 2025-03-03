import java.util.Scanner;

public class ExerciseInput {
    public static void main(String[] args) {
        
        
        
        Scanner inputString = new Scanner(System.in);
        String input = inputString.nextLine();
        inputString.close();

        Scanner userInput = new Scanner(input);
        userInput.useDelimiter("[:/\\s]+");
        
        while (userInput.hasNext()) {
            System.out.println(userInput.next());

        }
        userInput.close();
        System.exit(0);
     }
}