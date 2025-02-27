import java.util.Scanner;
public class formattedPrint {
    public static int GET_AVERAGE = 2;

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        float num1 = 0.0f;
        float num2 = 0.0f;
        float sum = 0.0f;
        float difference = 0.0f;
        float product = 0.0f;
        float absoluteDifference = 0.0f;
        float average = 0.0f;
        float max = 0.0f;
        float min = 0.0f;


        //Ask for two numbers and listen for input
        System.out.println("Give me two numbers please: ");
        num1 = userInput.nextInt();
        num2 = userInput.nextInt();

        //Calculate the numbers.
        sum = num1 + num2;
        difference = num1 - num2;
        product = num1 * num2;
        absoluteDifference = Math.abs(num1 - num2);
        average = (num1 + num2) / GET_AVERAGE;
        max = Math.max(num1, num2);
        min = Math.min(num1, num2);
    
        //Print the results
        System.out.printf("Total: %.0f%nDifference: %.0f%nProduct: %.0f%nAbsolute Value of the difference: %.0f%nMean / Average value: %.1f%nMaximum value: %.0f%nMinimum value: %.0f%n", sum, difference, product, absoluteDifference, average, max, min);

    }
}
