public class searcharrayMethod {
    public static void main(String[] args) {
        int[] testArray = {1, 2, 3};
        searchArray(testArray, 15);
    }
    public static int searchArray(int[] array,int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                System.out.println(i);
                return i;
            }
        }
        System.out.println("-1");
        return -1;
    }
}
