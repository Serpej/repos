package gameUI;

import java.util.Scanner;

public class GameUI {
    
    public GameUI() {
    Scanner userInput = new Scanner(System.in);
    userInput.useDelimiter("[\\s.,]+");
    }

    public int intInput(Scanner userInput) {
        int number = 0;
        while (true) {
            if (userInput.hasNextInt()) {
                number = userInput.nextInt();
                userInput.nextLine(); 
                break;
                } else {
                System.out.println("Enter numbers only. Try again.");
                userInput.next();
            }
                
        }
        return number;
    }

        public double doubleInput(Scanner userInput) {
        double number = 0.0;
        while (true) {

            if (userInput.hasNextDouble()) {
                number = userInput.nextDouble();
                userInput.nextLine();   
                break;
                } else {
                System.out.println("Enter numbers only. Try again.");
                userInput.next();
            }
                
        }
        return number;
    }

    public String stringInput(Scanner userInput) {
        String s = "";
        while (true) {
            
            if (userInput.hasNext()) {
                s = userInput.nextLine();
                break;
            } else {
                System.out.println("Invalid input. Try again.");
                userInput.next();
            }
        }
        return s;
    }

}


