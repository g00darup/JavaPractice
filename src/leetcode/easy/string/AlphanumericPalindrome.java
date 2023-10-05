package leetcode.easy.string;

public class AlphanumericPalindrome {
    public boolean isPalindrome(String s) {
        s = getS(s,"[^a-zA-Z0-9]");
        s = getS(s,"\\s");
        s = s.toLowerCase();
        char [] ch = s.toCharArray();
        int count=0;
        int length = ch.length;
        while(count < length/2){
            if(ch[count]!=ch[(length-1)-count]){
                return false;
            }

            count++;
        }
        return true;
    }

    private String getS(String s,String regex) {
        return s.replaceAll(regex, "");
    }

    public static void main(String[] args) {
        AlphanumericPalindrome palindrome = new AlphanumericPalindrome();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(palindrome.isPalindrome(s));
        String s1 = "1860734";
        String s2 = "1,782,489";
        s1= palindrome.getS(s1,"[^a-zA-Z0-9]");
        s2= palindrome.getS(s2,"[^a-zA-Z0-9]");
        int res = Integer.parseInt(s1)-Integer.parseInt(s2);
        System.out.println(res);
    }
}
