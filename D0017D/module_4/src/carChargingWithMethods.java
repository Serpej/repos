 /**
 * This program calculates how long it takes to charge an electric car, and shows it through table of data.
 *
 * FACTS:
 *     Charging power (W) = current (A) x voltage (V) (for single-phase 230V)
 *     Charging power (W) = current (A) x voltage (V) x square_root(3) (three-phase 400V)
 *     Charging power (KW) = (current (A) x voltage (V)) /1000 (for single-phase 230V)
 *     Charging power (KW) = (current (A) x voltage (V)) /1000 x square_root(3) (three-phase 400V)
 *     Charging time = Battery capacity (KWh) / Charging power(kWh)
 *
 * Input: Current and Voltage.
 * Output: The printed table.
 *
 * PSEUDOCODE: 
 * Declare constants
 * Declare variables
 *     5 Charging power variables
 *     5 Charging Time variables
 *     Variables used for rounding
 * Calculate Charging Power x 5
 * Round Charging Power to two decimal places x 5
 * Calculate Charging Time x 5
 * Round Charging time to two decimal places x 5
 * Print table
 * @author Your Name (hagjes-5)
 */
public class carChargingWithMethods {
    public static final double BATTERY_CAPACITY = 35.8;
    public static final double W_TO_KW = 1000.0;
    public static final double ROUND_OFF_DIGITS = 2;
    public static final double BASE_10 = 10;
    public static final double SQUARE_ROOT = 3;

    public static void main(final String[] args) {

        // Charging Power array
        double[] chargingPower = new double[5];

        // Charging Time array
        double[] chargingTime  = new double[5];

        // Ampere input
        double[] amperes = {10.0, 16.0, 10.0, 16.0, 32.0};

        // Voltage inputs
        double[] voltages = {230.0, 230.0, 400.0, 400.0, 400.0};

        // Variables for rounding
        double noOfDecimals = ROUND_OFF_DIGITS;
        double scale = 0;
        scale = Math.pow(BASE_10, noOfDecimals);

        // Calculate Charging Power
        // Charging power (KW) = (current (A) x voltage (V)) /1000 (for single-phase 230V)
        // Charging power (KW) = (current (A) x voltage (V)) /1000 x square_root(3) (three-phase 400V)
        for (int i = 0; i < 5; i++) {
            if (voltages[i] == 230.0) {
                chargingPower[i] = (amperes[i] * voltages[i]) / W_TO_KW;
            } else {
                chargingPower[i] = (amperes[i] * voltages[i]) / W_TO_KW * Math.sqrt(SQUARE_ROOT);
            }
        }

        // Round Charging Power to two decimal places
        for (int i = 0; i < 5; i++) {
            chargingPower[i] = getChargingPower(chargingPower[i], scale);
        }

        // Calculate Charging Time
        // Charging time = Battery capacity (KWh) / Charging power(kWh)
        
        for (int i = 0; i < 5; i++) {
            chargingTime[i] = BATTERY_CAPACITY / chargingPower[i];
        }

        // Round Charging time to two decimal places
        for (int i = 0; i < 5; i++) {
            // getCharginTime(chargingTime[i], scale);
            chargingTime[i] = getCharginTime(chargingTime[i], scale);
        }

        // Print table, look at "1.9 Printing data using print statements".
        System.out.printf("Battery: %.1f (kwh)%n", BATTERY_CAPACITY);
        System.out.printf("%-15s %-12s %-15s %-15s%n", "Current(A)", "Voltage(V)", "Charging Power(kW)", "Charging Time(h)");
        for (int i = 0; i < 5; i++) {
            printTable(amperes[i], voltages[i], chargingPower[i], chargingTime[i]);
        }

    }
    public static double getChargingPower(double chargingPower, double scale) {
        return Math.round(chargingPower * scale) / scale;
    }
    public static double getCharginTime(double chargingTime, double scale) {
        return Math.round(chargingTime * scale) / scale;
    }
    public static void printTable(double value1, double value2, double value3, double value4) {
        System.out.printf("%-15s %-15s %-15s %-15s%n", value1, value2, value3, value4);
    }
}
