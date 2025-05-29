public class removeX {
    public static String noX(String s) {
        if (s.length() == 0) {
            return "";
        }
        char first = s.charAt(0);
        String rest = s.substring(1);
        String recurse = noX(rest);
        if (first == 'x') {
            return recurse;
        } else {
            System.out.println(first + recurse);
            return first + recurse;
        }

        
    }
    public static void main(String[] args) {
        noX("Saxophone");
    }
}
