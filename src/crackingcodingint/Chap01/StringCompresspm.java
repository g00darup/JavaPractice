package crackingcodingint.Chap01;

import java.util.HashMap;
import java.util.Iterator;

public class StringCompresspm {
    public int compress(char[] chars) {
        HashMap<Character, Integer> cmap = new HashMap<>();
        for (char ch: chars){
            if(!cmap.containsKey(ch)){
                cmap.put(ch,1);
            }else{
                cmap.put(ch, cmap.get(ch)+1);
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = cmap.entrySet().iterator();
        for (Character k : cmap.keySet()) {
            sb.append(k).append(cmap.get(k));
        }

        chars = sb.toString().toCharArray();

        return chars.length;
    }
}
