import java.util.Scanner;

public class SocialSecurityNumber {
    public static int DOUBLED = 2;
    public static long divider = 1000000000;
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        userInput.useDelimiter("[-|\\s+]");
        
        long socSecNum = 0;
        int sum = 0;
        int controlNr = 0;
        int nextDigit = 0;
        

        // Ask user for a Social Security Number, and listen for answer.
        System.out.println("Please enter your Social Security Number (yymmddxxxx): ");
        
        socSecNum = userInput.nextLong();

        // Loop through the first nine digits
        for (int i = 1; i < 10; i++) {
            
            // Get current digit
            nextDigit = (int) (socSecNum / divider);
            
            // multiply every other digit by two, starting with the first.
            if (i % 2 != 0) {
                nextDigit = nextDigit * DOUBLED;

                // subtract 10 if the number if above 9
                if (nextDigit > 9) {
                    nextDigit = nextDigit - 10;
                    nextDigit = nextDigit + 1;
                }
            }

            // Add number to sum
            sum += nextDigit;

            // Delete the current number in the loop
            socSecNum = socSecNum % divider;

            // Shorten the divider to match the number of digits left in the SocSecNum
            divider /= 10;
        }
        // Get the last digit of the sum
        controlNr = 10 - (sum % 10);

        // Control to see if it's correct and print message
        if (socSecNum == controlNr) {
            System.out.println("The Social Security Number is correct!");

        } else {
            System.out.println("The Social Security Number is incorrect!");
        } 


        



        userInput.close();
    }
}
