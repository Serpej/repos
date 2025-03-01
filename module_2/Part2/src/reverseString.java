public class reverseString {

    public static String reverse(String s) {
        String r = "";
        for (int i = s.length() - 1; i >= 0; i--){
            r += s.charAt(i);
        }
        return r;
    }
    public static void main(String[] args) {

        String rev = "";
        String start = "OgaBoga";
        for (int i = start.length() - 1; i >= 0; i--){
            rev += start.charAt(i);
        }
        System.out.println(rev);
    }

}

