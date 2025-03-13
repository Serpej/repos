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
public class ChargingPowerArrays33 {
    public static final double BATTERY_CAPACITY = 35.8;
    public static final double W_TO_KW = 1000.0;
    public static final double VOLTAGE_230 = 230.0;
    public static final double ROUND_OFF_DIGITS = 2;
    public static final double BASE_10 = 10;
    public static final double SQUARE_ROOT = 3;
    public static final double[] CURRENT = {10.0, 16.0, 10.0, 16.0, 32.0};
    public static final double[] VOLTAGE = {230.0, 230.0, 400.0, 400.0, 400.0};
    public static final int ROWS = 5;

    public static void main(final String[] args) {

        // An array that stores Charging Power
        double[] chargingPower = new double[ROWS];

        // An array that stores Charging Time
        double[] chargingTime = new double[ROWS];

        // Variables for rounding
        double noOfDecimals = ROUND_OFF_DIGITS;
        double scale = 0;
        scale = Math.pow(BASE_10, noOfDecimals);

        // Calculate Charging Power
        for (int i = 0; i < ROWS; i++) {
            if (VOLTAGE[i] == VOLTAGE_230) {
                chargingPower[i] = (CURRENT[i] * VOLTAGE[i]) / W_TO_KW;
            } else  {
                chargingPower[i] = (CURRENT[i] * VOLTAGE[i]) / W_TO_KW * Math.sqrt(SQUARE_ROOT);
            }
            chargingPower[i] = Math.round(chargingPower[i] * scale) / scale; // Round Charging Power to two decimal places.
            chargingTime[i] = BATTERY_CAPACITY / chargingPower[i]; // Calculate Charging Time.
            chargingTime[i] = Math.round(chargingTime[i] * scale) / scale; // Round Charging time to two decimal places.
        }

        // Print heading of table.
        System.out.printf("Battery: %.1f (kwh)%n", BATTERY_CAPACITY);
        System.out.printf("%-15s %-12s %-15s %-15s%n", "Current(A)", "Voltage(V)", "Charging Power(kW)", "Charging Time(h)");

        // Print table, look at "1.9 Printing data using print statements".
        for (int i = 0; i < ROWS; i++) {
            System.out.printf("%-15s %-15s %-15s %-15s%n", CURRENT[i], VOLTAGE[i], chargingPower[i], chargingTime[i]);
        }
    }
}
