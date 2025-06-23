package gameUI;

import java.util.Scanner;

public class GameUI {
    Scanner userInput = new Scanner(System.in);

    public int intInput(Scanner userInput) {
        int number = 0;
        while (true) {
            if (userInput.hasNextInt()) {
                String tempS = userInput.nextLine();
                tempS.trim();
                number = Integer.parseInt(tempS);    
                break;
                } else {
                System.out.println("Enter numbers only. Try again.");
            }
                
        }
        return number;
    }

        public double doubleInput(Scanner userInput) {
        double number = 0.0;
        while (true) {

            if (userInput.hasNextInt()) {
                String tempS = userInput.nextLine();
                tempS.trim();
                number = Double.parseDouble(tempS);    
                break;
                } else {
                System.out.println("Enter numbers only. Try again.");
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
            }
        }
        return s;
    }

}


