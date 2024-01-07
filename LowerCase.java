
public class LowerCase {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(lowerCase(str));
    }

  
    public static String lowerCase(String s) {
       String s1 = ""; 
       for( int i = 0; i < s.length(); i++) {
        if( s.charAt(i) > 'A' && s.charAt(i) < 'Z' ) {
            s1 += (char) (s.charAt(i) + 32);
     }  else {
            s1 += (char) (s.charAt(i)); 
     }
    }
        return s1;
    }
}
