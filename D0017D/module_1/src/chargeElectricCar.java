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
public class chargeElectricCar {
    public static final double BATTERY_CAPACITY = 35.8;
    public static final double W_TO_KW = 1000.0;
    public static final double AMPERE_10 = 10.0;
    public static final double AMPERE_16 = 16.0;
    public static final double AMPERE_32 = 32.0;
    public static final double VOLTAGE_230 = 230.0;
    public static final double VOLTAGE_400 = 400.0;
    public static final double ROUND_OFF_DIGITS = 2;
    public static final double BASE_10 = 10;
    public static final double SQUARE_ROOT = 3;

    public static void main(final String[] args) {

        // Charging Power variables
        double chargingPower1 = 0.0;
        double chargingPower2 = 0.0;
        double chargingPower3 = 0.0;
        double chargingPower4 = 0.0;
        double chargingPower5 = 0.0;

        // Charging Time variables
        double chargingTime1 = 0.0;
        double chargingTime2 = 0.0;
        double chargingTime3 = 0.0;
        double chargingTime4 = 0.0;
        double chargingTime5 = 0.0;

        // Variables for rounding
        double noOfDecimals = ROUND_OFF_DIGITS;
        double scale = 0;
        scale = Math.pow(BASE_10, noOfDecimals);

        // Calculate Charging Power
        // Charging power (W) = current (A) x voltage (V) (for single-phase 230V)
        // Charging power (W) = current (A) x voltage (V) x square_root(3) (three-phase 400V)
        // Charging power (KW) = (current (A) x voltage (V)) /1000 (for single-phase 230V)
        // Charging power (KW) = (current (A) x voltage (V)) /1000 x square_root(3) (three-phase 400V)

        chargingPower1 = (AMPERE_10 * VOLTAGE_230) / W_TO_KW;
        chargingPower2 = (AMPERE_16 * VOLTAGE_230) / W_TO_KW;
        chargingPower3 = (AMPERE_10 * VOLTAGE_400) / W_TO_KW * Math.sqrt(SQUARE_ROOT);
        chargingPower4 = (AMPERE_16 * VOLTAGE_400) / W_TO_KW * Math.sqrt(SQUARE_ROOT);
        chargingPower5 = (AMPERE_32 * VOLTAGE_400) / W_TO_KW * Math.sqrt(SQUARE_ROOT);

        // Round Charging Power to two decimal places x 5
        chargingPower1 = Math.round(chargingPower1 * scale) / scale;
        chargingPower2 = Math.round(chargingPower2 * scale) / scale;
        chargingPower3 = Math.round(chargingPower3 * scale) / scale;
        chargingPower4 = Math.round(chargingPower4 * scale) / scale;
        chargingPower5 = Math.round(chargingPower5 * scale) / scale;

        // Calculate Charging Time
        // Charging time = Battery capacity (KWh) / Charging power(kWh)
        
        chargingTime1 = BATTERY_CAPACITY / chargingPower1;
        chargingTime2 = BATTERY_CAPACITY / chargingPower2;
        chargingTime3 = BATTERY_CAPACITY / chargingPower3;
        chargingTime4 = BATTERY_CAPACITY / chargingPower4;
        chargingTime5 = BATTERY_CAPACITY / chargingPower5;

        // Round Charging time to two decimal places x 5
        chargingTime1 = Math.round(chargingTime1 * scale) / scale;
        chargingTime2 = Math.round(chargingTime2 * scale) / scale;
        chargingTime3 = Math.round(chargingTime3 * scale) / scale;
        chargingTime4 = Math.round(chargingTime4 * scale) / scale;
        chargingTime5 = Math.round(chargingTime5 * scale) / scale;

        // Print table, look at "1.9 Printing data using print statements".
        System.out.printf("Battery: %.1f (kwh)%n", BATTERY_CAPACITY);
        System.out.printf("%-15s %-12s %-15s %-15s%n", "Current(A)", "Voltage(V)", "Charging Power(kW)", "Charging Time(h)");
        System.out.printf("%-15s %-15s %-15s %-15s%n", AMPERE_10, VOLTAGE_230, chargingPower1, chargingTime1);
        System.out.printf("%-15s %-15s %-15s %-15s%n", AMPERE_16, VOLTAGE_230, chargingPower2, chargingTime2);
        System.out.printf("%-15s %-15s %-15s %-15s%n", AMPERE_10, VOLTAGE_400, chargingPower3, chargingTime3);
        System.out.printf("%-15s %-15s %-15s %-15s%n", AMPERE_16, VOLTAGE_400, chargingPower4, chargingTime4);
        System.out.printf("%-15s %-15s %-15s %-15s%n", AMPERE_32, VOLTAGE_400, chargingPower5, chargingTime5);
    }
}