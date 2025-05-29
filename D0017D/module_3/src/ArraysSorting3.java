import java.util.Random;
/**
 * This is a program where we make 30 random integers, store them inside an array,
 * and then sort them in numberical order.
 */

public class ArraysSorting3 {
    public static void main(String[] args) {
        Random rand = new Random();
        int randomNumber = 0;
        int[] arrayOfNums = new int[100];
        int temp = 0;

        // Make 100 random integers and store inside the array
        for (int i = 0; i < arrayOfNums.length; i++) {
            randomNumber = rand.nextInt(101);
            arrayOfNums[i] = randomNumber;
        }

        //Sort the numbers in the array
        for (int i = 0; i < arrayOfNums.length; i++) {
            for (int j = 0; j < arrayOfNums.length -1; j++) {
                if (arrayOfNums[j] > arrayOfNums[j+1]) {
                    temp = arrayOfNums[j];
                    arrayOfNums[j] = arrayOfNums[j+1];
                    arrayOfNums[j+1] = temp;
                }
                
            }
        }

        // Print the array
        for (int i = 0; i < arrayOfNums.length; i++) {
            System.out.println(arrayOfNums[i]);
        }
    }
}
