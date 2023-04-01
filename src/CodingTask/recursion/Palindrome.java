package CodingTask.recursion;

public class Palindrome {
    static boolean palindrome(String s){
        if(s.length() <= 1 ){
            return true;
        }else{
            return s.charAt(0)==s.charAt(s.length()-1) && palindrome(s.substring(1,s.length()-1));
        }
    }
    public static void main(String[] args) {
        System.out.println(palindrome("madam"));
    }
}
