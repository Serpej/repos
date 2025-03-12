import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class createRandomNumbers {
    public static void main(String[] args) {
        int randomNumbers = 0;
        Random rand = new Random();
        int randomNum = rand.nextInt(7) + 1;
        
        for (int i = 0; i < 50; i++) {
            randomNum = rand.nextInt(6) + 1;
            System.out.println(randomNum);
            }


        // for (int i = 0; i < 50; i++) {
        // randomNumbers = (int) (Math.random() * 6 ) + 1;
        // System.out.println(randomNumbers);
        // }


        // for (int i = 1; i <= 6; i++) {
        //     randomNumbers = (int) (Math.random() * 100);
        //     System.out.println("Random number " + i + " is " + randomNumbers);
        // }

        // Random rand = new Random();
        // double randomNumber  = rand.nextDouble();
        // System.out.println(randomNumber);

        // ThreadLocalRandom rand =ThreadLocalRandom.current();
        // int randomNumber = rand.nextInt(100);
        // System.out.println(randomNumber);

        // SecureRandom rand = new SecureRandom();
        // int randomNumber = rand.nextInt(100);
        // System.out.println(randomNumber);
    }
    
}
