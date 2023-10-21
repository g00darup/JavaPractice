package crackingcodingint.Chap01;

import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.Map;

public class OneDot1UniqChar {
    boolean isUnique(String s){
        if(s.length()>26)
            return false;
        else{
            String[] st = s.split("");
            Map<String, Integer> m = new HashMap();
            for(int i=0;i<st.length;i++){
                if(!m.containsKey(st[i]))
                    m.put(st[i],1);
                else
                    m.put(st[i],m.get(st[i])+1);

            }
            for(Integer i:m.values()){
                if(i>1){
                    return false;
                }
            }
            return true;

        }
    }

    public static void main(String[] args) {
        String s ="regrey";
        OneDot1UniqChar o = new OneDot1UniqChar();
        System.out.println(o.isUnique(s));
    }
}
