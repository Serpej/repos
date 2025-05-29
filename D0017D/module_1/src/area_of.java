public class area_of {

    public static void main(String[]args) {
        final float PI = 3.1415f;
        float r = 0f;
        int n = 0;
        float rDoubled = 0f;
        float A = 0; 
       
        
        //Calculates a random decimal number between 1 and 10.
        n = 9;
        r = (float) (Math.random() * n) + 1;

        //Calculates the radius elevated by 2.
        rDoubled = (float) Math.pow(r, 2);

        //Calculates the area of the circle.
        A = PI * rDoubled;

        System.out.printf("The radius for the circle is %fmm,%nand that makes the area %fmm2.%n", r, A); 
    }
}