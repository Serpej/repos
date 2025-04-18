/**
 * A Practice exercise on how to write a simple program.
 * Prints a message in the console.
 */
public class ExerciseroundOffDigits 
{
    public static void main(String[] args) {
        /**
         * An algorithm that rounds down PI into 3 decimals.
         * step 1: convert  value (3.141592653589793) to 3141.592653589793.
         *       : multiply by 1000 (scale).
         * step 2: Use Math.round to make 3141.592653589793 into 3142.
         * step 3: Divide 3142 with value scale to get newValue (3.142)
         * step 4: print newValue.
         */
        double value = Math.PI;
        int noOfDecimals = 2;
        double scale = 0;
        double newValue = 0;

        scale = Math.pow (10, noOfDecimals);

        newValue = Math.round (value * scale) / scale;
        

        System.out.println(value);
        System.out.println(newValue);


        


        // 3.1415 * 1000 = 3141.5 math.pow(3)
        // math.round(31415) = 3142
        // 3142/1000 =3.142
        
    }
}

