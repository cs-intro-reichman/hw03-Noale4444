
public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

   
    public static String uniqueChars(String s) {
       String s1 = "";
       char curChar = s.charAt(0); 
       for ( int i = 1; i < s.length(); i++ ) {
        if ( s.charAt(i) == ' ' || s1.indexOf(s.charAt(i)) == -1) {
           curChar = s.charAt(i);
           s1 += curChar;
        }
       }  
        return s1;
    }
}
