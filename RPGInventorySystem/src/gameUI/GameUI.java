package gameUI;

import java.util.Scanner;

public class GameUI {
    
    private Scanner userInput;

    public GameUI() {
    userInput = new Scanner(System.in);
    userInput.useDelimiter("[\\s.,]+");
    }

    public int intInput() {
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

        public double doubleInput() {
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

    public String stringInput() {
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


