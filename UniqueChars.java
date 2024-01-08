public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    public static String uniqueChars(String s) {
        String s1 = "";
        s1 += s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar == ' ' || s1.indexOf(curChar) == -1) {
                s1 += curChar;
            }
        }  
        return s1;
    }
}
