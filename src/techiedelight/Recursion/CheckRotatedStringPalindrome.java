package techiedelight.Recursion;

import java.util.ArrayList;
import java.util.List;

public class CheckRotatedStringPalindrome {

   String checkRotatedStringPalindrome(String str){
       List<String> list = allCombinations(str);
       for (String s :
            list) {
           if(checkPalindrome(s))
               return s;
       }
       
       return null;
   }
    //revisit later
    private List<String> allCombinations(String str) {
       char[] ch = str.toCharArray();
       List<String> sl = new ArrayList<>();
       for(int i=0;i<ch.length;i++){
           for(int j=1;j<ch.length;j++){
              sl.add(String.valueOf(ch[i]+ch[j]));
           }
       }
       return sl;
    }

    private boolean checkPalindrome(String s) {
       int length = s.length();
       if(length==1)
           return true;
       else {
          
           if(length ==2)
               return s.substring(0,1).equals(s.substring(1,2));
           else{
               if(!s.substring(0,1).equals(s.substring(length-1,length)))
                   return false;
               return checkPalindrome(s.substring(1,length-1));
           }
       }
           
    }

}
