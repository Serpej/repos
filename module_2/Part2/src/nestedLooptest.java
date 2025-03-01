public class nestedLooptest {
    public static int HOUR_MAX = 24;
    public static int MINUTE_MAX = 59;
    public static void main(String[] args) {
        
    //     for (int x = 0; x < 11; x++) {
    //         for(int y = 0; y < 11; y++) {
    //             System.out.printf("%4d", x * y);
    //         }
    //     }
        

    for (int hour = 0; hour < HOUR_MAX; hour++) {
        
        for (int minute = 0; minute <= MINUTE_MAX; minute++) {
            System.out.printf("%d:%d%n", hour, minute);
        }
    }

    }
}
