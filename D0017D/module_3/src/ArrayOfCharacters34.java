import java.util.Scanner;

public class ArrayOfCharacters34 {
  public static void main(String[] args) {
    // Create a Scanner object to read user input
    Scanner userInput = new Scanner(System.in);

    // Ask the user for a string
    System.out.print("Enter a string: ");
    String myString = userInput.nextLine();

    // Convert the string to a character array
    char[] myArray = myString.toCharArray();

    // Count the number of times each character appears in the string
    int[] charCount = new int[256];
    
    //Enhanced for loop Syntax
    for (char c: myArray) {
        charCount[c]++;
    }

    // Print the result
    for (int i = 0; i < 256; i++) {
        if (charCount[i] > 0) {
            System.out.println("Character '" + (char)i + "' appears " + charCount[i] + " times");
        }
    }
  }
}