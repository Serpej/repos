public class BottlesOfBeer {
    public static void bottles(int i) {
        if (i > 0) {
            int onTheWall = i - 1;
            System.out.println(i + " bottles of beer on the wall,");
            System.out.println(i + " bottles of beer,");
            System.out.println("ya’ take one down, ya’ pass it around,");
            System.out.println(onTheWall + " bottles of beer on the wall.");
            System.out.println();
            bottles(onTheWall);
        } else {
            System.out.println("No bottles of beer on the wall,");
            System.out.println("no bottles of beer,");
            System.out.println("ya’ can’t take one down, ya’ can’t pass it around,");
            System.out.println("’cause there are no more bottles of beer on the wall!");
        }
    }
    public static void main(String[] args) {
        bottles(99);
    }
}
