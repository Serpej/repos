import java.util.Arrays;
public class singleDimentional33 {
    public static void main(String[] args) {
        int[] evenNumbers = new int[10];
        evenNumbers[0] = 2;
        int[] copiedArray = new int[10]; 

        for (int i = 1; i < evenNumbers.length; i++) {
            System.out.printf("Assigning %d th index%n", i);
            evenNumbers[i] = evenNumbers[i -1] + 2;
        }
        
        for (int i = 0; i < evenNumbers.length; i++) {
            System.out.printf("The value of %d th index is %d%n", i, evenNumbers[i]);
        }
        System.arraycopy(evenNumbers, 0, copiedArray, 0, 10);

        System.out.println();
        System.out.println("Round two!");
        System.out.println();

        System.out.println("printing copied array!");
        for (int i = 0; i < copiedArray.length; i++) {
            System.out.printf("The value of the copied arrays %d th index is %d%n", i, copiedArray[i]);
        }

        copiedArray[0] = 22;
        for (int i = 1; i < copiedArray.length; i++) {
            System.out.printf("Assigning %d th index%n", i);
            copiedArray[i] = copiedArray[i -1] + 2;
        }

        for (int i = 0; i < copiedArray.length; i++) {
            System.out.printf("The value of %d th index is %d%n", i, copiedArray[i]);
        }
        
    }
}
