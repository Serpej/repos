import java.util.Scanner;
public class ifElse {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int num = 0;
        
        while (true) {
            System.out.println("Enter a number: ");
            
            if (userInput.hasNextInt()) {

                num = userInput.nextInt();
    
                if (num % 2 == 0) {
                    System.out.println("The number is even");
                } else {
                    System.out.println("The number is odd");
                }
            } else {
                System.out.println("Sorry, I read only integer, please try again");
                System.exit(0);
            }
        }


    }
    
}

/*
 * IF userInput % 2 == 0 THEN
 *      Print num is even
 * OTHERWISE 
 *      Print num is odd
 */
