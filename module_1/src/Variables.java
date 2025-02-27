public class Variables {
    public static void main(String[] args) throws Exception {
         int num1 = 0;
         int num2 = 0;
         int sum = 0;
         float pi = 3.142f;
         double dPi = 3.142;

         num1 = 10;
         num2 = 30;
         sum = num1 + num2;
         System.out.printf("The sum of %d and %d is %d%n", num1, num2, sum);
         //System.out.printf("the float is %.4f and the double float is %f.%n", pi, dPi);
        System.out.printf("the float is %.3f and the double float is %f", pi, dPi);
    }
}
