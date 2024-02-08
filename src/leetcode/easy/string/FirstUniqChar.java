package leetcode.easy.string;

import java.util.HashMap;
import java.util.Iterator;

public class FirstUniqChar {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> chMap = new HashMap<>();
        StringBuilder sb =new StringBuilder(s);
        int i =0;
        while(i<s.length()){
            if(!chMap.containsKey(s.charAt(i)))
                chMap.put(s.charAt(i),1);
            else
                chMap.put(s.charAt(i),chMap.get(s.charAt(i))+1);

            i++;
        }
        i=0;

        if(chMap!=null){
            chMap.values().stream().map(e->(e>1));
        }
        return 0;
    }

    public int strStr(String haystack, String needle) {
            int nLen  = needle.length();
            StringBuilder sb = new StringBuilder();

            if(!haystack.contains(needle)){
                return -1;
            }else {
//                int i =0;
//                while(i<nLen){
//                    sb.append(9);
//                    i++;
//                }
//                //haystack.
//                haystack.replace("love", "9");
//                return haystack.indexOf("9");
                return haystack.indexOf(needle);
            }
    }

    public static void main(String[] args) {
        String haystack = "leetcode";
        String needle = "leeto";

        FirstUniqChar fu = new FirstUniqChar();
        System.out.println(fu.strStr(haystack,needle));
    }
}
