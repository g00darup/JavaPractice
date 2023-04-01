package techiedelight.Recursion;

import java.util.List;

public class CheckStringPalindrome {
    static boolean checkStringPalindrome(String src){
        return palindromeHelper(src,src.length());
    }

    private static boolean palindromeHelper(String src, int len) {
        if(len <=1)
            return true;
        else {
            boolean chk = src.substring(0, 1).equalsIgnoreCase(src.substring(src.length() - 1, src.length()));
            if (len>2 && !chk)
                return false;
            else if (len==2 && chk)
                return true;
            else
                return palindromeHelper(src.substring(1, src.length() - 1),src.substring(1, src.length() - 1).length());
        }
    }

    public static void main(String[] args) {
        List<String> test = List.of("madam","jimmy","monday","barirab","hendrix","kayak",
                "rotator","deed","peep","wow","bob","noon","night","day");
        test.forEach(t-> System.out.println(checkStringPalindrome(t)));
    }
}
