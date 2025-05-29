import java.util.Scanner;

public class forFun {
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);

        String dnd = "";
        
        System.out.println("Enter when do you want to play DnD: ");
        dnd = userInput.next();
        userInput.hasNextLine();
        while (true) {
            if (userInput.hasNextLine()) {
                System.out.println("System Error: Date too far away.");
                System.out.println("WARING");
                System.out.println("CRASHING...");
            }
        }
    }
}
