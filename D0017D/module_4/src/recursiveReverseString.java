import java.util.Scanner;
/**
 * This is a "program" that takes a String an reverses it through a recursive method.
 * It can easily be used in other files in the same "src" directory by calling recursiveReverseString.reverseString().
 */

public class recursiveReverseString {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        userInput.useDelimiter("[\\s]+");
        String message = "";
        String reveresedMessage = "";
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.println("Enter a message to reverse: ");
            if (userInput.hasNextLine()) {
                message = userInput.nextLine();
                reveresedMessage = reverseString(message);
                System.out.println(reveresedMessage);
                userInput.close();
                isValidInput = true;
            } else {
                System.out.println("You need to enter a message. try again.");
            }
        }
        
    }
    public static String reverseString(String s) {
        if (s.equals("")) {
            return s;
        }
        char first = s.charAt(0);
        String rest = s.substring(1);
        String result = reverseString(rest);
        result += first;
        return result;
    }
}
