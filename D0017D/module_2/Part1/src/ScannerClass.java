import java.util.Scanner;

public class ScannerClass {
    public static void main(String[] args) throws Exception {
        Scanner userInput = new Scanner(System.in);
        userInput.useDelimiter("[-/\\s]+");
        
        String day = "";
        String month = "";
        String year = "";

        System.out.println("Enter date: dd/mm-yyyy");

        day = userInput.next();
        month = userInput.next();
        year = userInput.next();

        System.out.printf("The date you have typed is %s/%s-%s%n", day, month, year);
    }
}
