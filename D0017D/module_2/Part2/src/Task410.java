public class Task410 {
    static final int Zed = 122;
    static final int A = 97;
    static final int E = 101;
    static final int I = 105;
    static final int O = 111;
    static final int U = 117;
    public static void main(String[] args) {

        for (int i = 97; i <= Zed; i++) {
            System.out.println((char) i);
            if (i == A || i == E || i == I || i == O || i == U) {
                System.out.println("VOWEL!");
            } else {
                System.out.println("consonant");
            }
        }
    }
}
