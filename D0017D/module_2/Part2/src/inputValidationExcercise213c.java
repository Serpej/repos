import java.util.Scanner;

public class inputValidationExcercise213c {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        userInput.useDelimiter("[\\s+]");
        String inputRead = "";
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Enter command \"start\", \"pause\", \"end\" or \"stop\":");
            if (userInput.hasNext()) {
                inputRead = userInput.next();
                if (inputRead.equalsIgnoreCase("start")) {
                    System.out.println("Playing music");
                } 
                else if (inputRead.equalsIgnoreCase("pause")) {
                    System.out.println("Music paused");
                }
                else if (inputRead.equalsIgnoreCase("end")) {
                    System.out.println("Command not supported!");
                }
                else if (inputRead.equalsIgnoreCase("stop")) {
                    System.out.println("Stop playing music, program terminated.");
                    validInput = true;
                    userInput.close();
                }
            }
            else {
                System.out.println("Invalid input!");
            }
        }
    }
}
