package techiedelight.Recursion;

import java.util.List;
import java.util.Stack;

public class StringFunctions {
    String reverse (String str){
        Stack<String> st = new Stack<>();
        char ch[] = str.toCharArray();
        int i =0;
        while (i<str.length()){
            st.push(String.valueOf(ch[i]));
            i++;
        }
        str="";
        while(!st.isEmpty()){
            str+=st.pop();

        }
        return str;
    }

    String reverse2(String st){
        if(st.length()==1){
            return st;
        }else {
            return reverse(st.substring(1,st.length()))+st.substring(0,1);
        }
    }

    String rev3(String s){
        return revHelper(s.toCharArray(),0,s.length()-1);
    }

    String revHelper(char[] ch, int l, int r){
        if(l<r){
            swap(ch,l,r);
            revHelper(ch,l+1,r-1);
        }
        return new String(ch);
    }

    private void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
    /*
    Remove adjacent duplicate characters from a string
    Input:  AABBBCDDD
    Output: ABCD
     */

    private String remAdjDups(String s){
        char [] ch = s.toCharArray();
        List l = List.of(ch);
        l = removeAdjDups(l);
        return l.toString();
    }

    private List removeAdjDups(List l) {
        //l.stream().filter(e->e.equals())
        return null;
    }

    private String rmAdjDup(String s){
        String st = rmAdjDup(s,s.substring(0,1),0);
        return st;
    }

    private String rmAdjDup(String s, String substring, int i) {
        if(s.length()==1){
            return s;
        }else{
            int start = i ;
            if(s.substring(i+1,i+2).equals(substring)){
                return rmAdjDup((s.substring(0,i)+s.substring(i+2,s.length())),s.substring(i+2,i+3),i++);
            }else{
                return rmAdjDup((s.substring(0,i)+s.substring(i+1,s.length())),s.substring(i+1,i+2),i++);
            }
        }
    }

    public static void main(String[] args) {
        String s = "reva";
        StringFunctions sf = new StringFunctions();
        System.out.println(sf.rev3(s));
    }
}
