// import java.util.Scanner;

public class Calculator {
    
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int choice = 0;
    //     double num1, num2, result;
        
    //     while (true) {
    //         System.out.println("Calculator Menu");
    //         System.out.println("----------------");
    //         System.out.println("1. Addition");
    //         System.out.println("2. Subtraction");
    //         System.out.println("3. Multiplication");
    //         System.out.println("4. Division");
    //         System.out.println("5. Exit");
    //         System.out.print("Enter your choice (1-5): ");
    //         choice = sc.nextInt();
            
    //         if (choice == 5) {
    //             System.out.println("Goodbye!");
    //             break;
    //         }
            
    //         System.out.print("Enter first number: ");
    //         num1 = sc.nextDouble();
    //         System.out.print("Enter second number: ");
    //         num2 = sc.nextDouble();
            
    //         switch (choice) {
    //             case 1:
    //                 result = add(num1, num2);
    //                 System.out.println("Result: " + result);
    //                 break;
    //             case 2:
    //                 result = subtract(num1, num2);
    //                 System.out.println("Result: " + result);
    //                 break;
    //             case 3:
    //                 result = multiply(num1, num2);
    //                 System.out.println("Result: " + result);
    //                 break;
    //             case 4:
    //                 result = divide(num1, num2);
    //                 System.out.println("Result: " + result);
    //                 break;
    //             default:
    //                 System.out.println("Invalid choice!");
    //                 break;
    //         }
            
    //         System.out.println();
    //     }
        
    //     sc.close();
    // }
    

    // Eftersom metoden add är static måste man skriva "Calculator.", andra alternativet är att ska objektet
    // Calculator calc = new Calculator(); och sedan skriva calc.add. Det skapar en egen instance av metoden i minnet
    // vilket man oftare använder i objektorienterad programmering.
    public static double add(double num1, double num2) {
        return num1 + num2;
    }
    
    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }
    
    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }
    
    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Error: Cannot divide by zero!");
            return 0;
        }
        return num1 / num2;
    }
}
