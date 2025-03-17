public class EnhancedforLoop {
    public static void main(String[] args) {
        // int[] items = {1,2,3,4,5};

        // for (int item : items) {
        //     System.out.println(item);
        // }
        

        char[] alphabet = new char[26];

        for (char i = 'a'; i <= 'z'; i++) {
            alphabet[i - 'a'] = i;
        }
        
        for (char c : alphabet) {
            System.out.println(c);
        }
    }
}
