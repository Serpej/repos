public class Exercise2 {
    public static void main(String[] args) {
        double a = 1.7; 
        double b = 1.9; 
        double c = a + 0.1; 
        double d = b - 0.1;
        double scale = 0;
        int noOfDecimals = 1;
        double newD = 0;

        scale = Math.pow (10, noOfDecimals);

        newD = Math.round (d * scale) / scale;

        System.out.println (c); 
        System.out.println (newD);
    }
}
