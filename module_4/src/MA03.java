import java.util.Scanner;
/**
 * This program continously checks for an input and will use it to calculate mathematical formulas until the user enters -1.
 * 1. Print Header 1.
 *
 * 2. Enter While loop 1:
 *      2a. Is input for radius -1?
 *          Yes - break out of loop.
 *      2b. Is input for height -1?
 *          Yes - break out of loop.
 *      2c. Print area(), Cone area() and Cone volume()
 *          Then go back to 2a.
 *
 * 3. Print Header 2.  
 *
 * 4. Enter While loop 2:
 *      4a. Is input for numerator -1?
 *          Yes - break out of loop.
 *      4b. Is input for denominator -1?
 *          Yes - break out of loop.
 *      4c. Print printFraction(fraction())
 *          Then go back to 4a.
 *
 * @author Jesper Hagerman Borgström (hagjes-5)
 */

// Please don't forget to add pseudocode to your methods and classes.
public class MA03 {
    //Creation of scanner object.
    private static Scanner userInputScanner = new Scanner(System.in);
    
    //Constants
    static final int QUIT = -1;
    static final int BY_TWO = 2;
    static final int VOLUME_DIVISION = 3;
    static final int BASE_10 = 10;
    static final int NO_OF_DECIMALS = 2;

    public static void main(final String[] args) {
        int radius = 0;
        int height = 0;
        int numerator = 0;
        int denominator = 0;
        
        //Print the header of the program for area and volume.
        System.out.println("----------------------------------");
        System.out.println("# Test of area and volume methods");
        System.out.println("----------------------------------");

        // // While loop that runs until user enters "q" for area and volume.

        while (true) {
            radius = input();
            if (radius == QUIT) {
                break;
            }

            height = input();
            if (height == QUIT) {
                break;
            }

            System.out.println("r = " + radius + ", h = " + height);
            System.out.printf("Circle area: %.2f %n", area(radius));
            System.out.printf("Cone area: %.2f %n", area(radius, height));
            System.out.printf("Cone volume: %.2f %n", volume(radius, height));
        }

        //Print the header of the program for area and volume.
        System.out.println("----------------------------------");
        System.out.println("# Test of the fractional methods");
        System.out.println("----------------------------------");


        // // While loop that runs until user enters "q" for the fraction part
        while (true) {

            numerator = input();
            if (numerator == QUIT) {
                break;
            }

            denominator = input();
            if (denominator == QUIT) {
                break;
            } else if (denominator == 0) {
                System.out.println("Error");
                continue;
            }

            System.out.printf("%d/%d = ", numerator, denominator);
            printFraction(fraction(numerator, denominator));
        }
        userInputScanner.close();
    }
/**
* This Method checks what type of input the user has made, and returns a positive integer, alternatively -1 to quit.
* @return positive integer or -1
*/
    public static int input() {
        int number = 0;
        while (true) {
            if (userInputScanner.hasNextInt()) {
                number = userInputScanner.nextInt();
                if (number > 0) {
                    break;
                } else if (number < 0) {
                    number = Math.abs(number);
                    break;
                } else if (number == 0) {
                    break;
                }
            } else if (userInputScanner.hasNext()) {
                String inString = userInputScanner.next();
                if (inString.equalsIgnoreCase("q")) {
                    return QUIT;
                }
            } else {
                break;
            }
        }
        return number;
    }

    /**
     * This method calculates the area of a given radius.
     * @param radius
     * @return area of a circle.
     */
    public static double area(final int radius) {
        double area = Math.PI * Math.pow(radius, BY_TWO);
        return area;
    }

    /**
     * This method calculates the surface of a cone.
     * @param radius
     * @param height
     * @return The surface area of a cone.
     */
    public static double area(final int radius, final int height) {
        double surfaceOfCone = (Math.PI * radius * pythagoras(radius, height));
        return surfaceOfCone;
    }

    /**
     * This Method calculates the hypoteneuse using pythagoras theorem.
     * @param sideA
     * @param sideB
     * @return The hypotenuese of a triangle.
     */
    public static double pythagoras(final int sideA, final int sideB) {
        double hypotenuse = Math.sqrt(Math.pow(sideA, BY_TWO) + Math.pow(sideB, BY_TWO));
        return hypotenuse;
    }
    /**
     * This method caluclates the volume of a cone.
     * @param radius
     * @param height
     * @return The volume of a cone.
     */
    public static double  volume(final int radius, final int height) {
        double volume  = (Math.PI * Math.pow(radius, BY_TWO) * height) / VOLUME_DIVISION;
        return volume;
    }

    /**
     * This method calculates a fractional number according to the pseudocode below and returns an array of integers.
     * @param numerator
     * @param denominator
     * @return An array of integers.
     *
     * if the denominator is 0, return null
     * if the numerator is 0, return {0, 0, 0}

     * array[0] = numerator / denominator; // The quotation gives us the integer
     * array[1] = numerator % denominator; // The remainder gives us the fraction's numerator
     * array[2] = denominator;

     * Reduce array[1] and array[2] Further, for example, when we do 32 / 12, we should get 2 2/3 and not 2 8/12
     * find gcd
     * array[1] = array[1]/gcd;
     * array[2] = array[2]/gcd;
     *  */
    public static int[] fraction(final int numerator, final int denominator) {
        int[] fraction = {0, 0, 0}; 
        if (denominator == 0) {
            return null;
        } else if (numerator == 0) {
            return fraction;
        }
        fraction[0] = numerator / denominator;
        fraction[1] = numerator % denominator;
        fraction[2] = denominator;

        fraction[1] = fraction[1] / gcd(numerator, denominator);
        fraction[2] = fraction[2] / gcd(numerator, denominator);

        return fraction;
    }

    /**
     * This method calculates GCD using Euclide's algorithm as below:
     * 1. Make sure that a > b (change the place if necessary)
     * 2. As long as b is not 0
     * 2.1 c = a % b
     * 2.2 a = b
     * 2.3 b = c
     * 3. Return a
     * @param a first integer a
     * @param b second integer b
     * @return GCD of a and b
     */
    public static int gcd(final int a, final int b) {
        int tempA = a;
        int tempB = b;
        //Make sure that a > b (change the place if necessary).
        if (a <= b) {
            int temp = tempA;
            tempA = tempB;
            tempB = temp;
        }

        //As long as b is not 0.
        while (tempB != 0) {
            int tempC = tempA % tempB;
            tempA = tempB;
            tempB = tempC;
        }
        return tempA;
    }

    /**
     * This method prints an accurate fraction of the array input depending on it's elements
     * @param parts
     */
    public static void printFraction(final int[] parts) {
        if (parts == null) {
            System.out.println("Error");
        } else if (parts[0] == 0 && parts[1] == 0 && parts[2] == 0) {
            System.out.println("0");
        } else if (parts[1] == 0) {
            System.out.printf("%d%n", parts[0]);
        } else if (parts[0] == 0) {
            System.out.printf("%d/%d%n", parts[1], parts[2]);
        } else if (parts[0] != 0 && parts[1] != 0 && parts[2] != 0) {
            System.out.printf("%d %d/%d%n", parts[0], parts[1], parts[2]);
        }
    }

}
