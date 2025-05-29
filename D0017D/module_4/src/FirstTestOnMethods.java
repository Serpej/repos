public class FirstTestOnMethods {

    // public static int factorial(int n) {
    //     if (n == 0) {
    //         return 1;
    //     }
    //     int recursive =  factorial(n - 1);
    //     int result = n * recursive;
    //     return result;
    // } 

    // public static int fibonacci(int n) {
    //     if (n == 1 || n == 2) {
    //     return 1;
    //     }
    //     int result = fibonacci(n - 1) + fibonacci(n - 2);
    //     System.out.println(result);
    //     return result;
    //     }

    //Display a number in binary
    public static void binary(int i) {
        if(i > 0) {
            int divided = i / 2;
            binary(divided);
            System.out.println(i % 2);        
        }
    }

    public static void main(String[] args) throws Exception {

        binary(23);
    }
}
