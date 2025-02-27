import java.util.Scanner;

public class spendMoney {
    public static int BY_TWENTY = 20;
    public static int BY_TEN = 10;
    public static int BY_FIVE = 5;
    public static int BY_ONE = 1;
    public static void main(String[] args) {
                Scanner userInput = new Scanner(System.in);
        //declare variables
        int amount = 0;
        String amountString ="";
        int twenties = 0;
        int tens = 0;
        int fives = 0;
        int ones = 0;
        int remainder = 0;

        //Ask for amount
        System.out.println("How much money?");
        amountString = userInput.nextLine();
        amount = Integer.parseInt(amountString);

        //Calculate 
        twenties = amount / BY_TWENTY;
        remainder = amount % BY_TWENTY;
        tens = remainder / BY_TEN;
        remainder = remainder % BY_TEN;
        fives = remainder / BY_FIVE;
        remainder = remainder % BY_FIVE;
        ones = remainder / BY_ONE;

        //Print in table
        System.out.printf("|%-10s |%-10s |%-10s |%-10s |%-10s%n", "Exchange", "20 kronor", "10 kronor", "5 kronor", "1 kronor");
        System.out.printf("|%-10s |%-10s |%-10s |%-10s |%-10s%n", amount, twenties, tens, fives, ones);
        
        
    }
}
