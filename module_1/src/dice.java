public class dice {
    public static void main(String[] args) {
        int n = 0;
        int randomNumber1 = 0;
        int randomNumber2 = 0;
        int randomNumber3 = 0;
        int sum = 0;

        // Random max number
        n = 10;

        //Random throws, separated in three variables
        randomNumber1 = (int) (Math.random() * n) + 1;
        randomNumber2 = (int) (Math.random() * n) + 1;
        randomNumber3 = (int) (Math.random() * n) + 1;
        
        //The sum of all throws
        sum = randomNumber1 + randomNumber2 + randomNumber3;

        System.out.printf("First was %d, second was %d and third was %d. The total sum is %d%n", randomNumber1, randomNumber2, randomNumber3, sum);
    }
}
