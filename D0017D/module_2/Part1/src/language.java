import java.util.Locale;

public class language {
    public static void main(String[] args) {

        Locale svenska = new Locale.Builder().setLanguage("sv").setRegion("SE").build();
        Locale.setDefault(svenska);
        double test = 10 / 3.8;
        System.out.printf("Swedish decimals: %2.2f%n", test);

        // Locale svenska = new Locale.Builder().setLanguage("sv").setRegion("SE").build();
        // Locale.setDefault(svenska); 
        // double testDecimal = 10 / 3.8;
        // System.out.printf("Test Decimal in Swedish: %2.2f \n", testDecimal);

    }
}
