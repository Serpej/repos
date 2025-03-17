public class sortingArrayExample {
    public static void main(String[] args) {
        int[] myArray = {30, 57, 90, 5, 1, 4, 2, 3};
        int temp = 0;

        // Sort every integer based on all other integer
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray.length-1; j++) {// Notice the -1 int the nested for loop, this is because we are comapring adjacent elements.
                                                        // Without it the myArray[j+1] would cause an "Out of bounce" error.
                if (myArray[j] > myArray[j+1]) {
                    temp = myArray[j];
                    myArray[j] = myArray[j+1];
                    myArray[j+1] = temp;
                }
            }
        }
        // Print array
        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }

    }
}
