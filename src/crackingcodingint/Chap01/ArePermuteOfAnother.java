package crackingcodingint.Chap01;

import java.util.Arrays;
import java.util.HashMap;



public class ArePermuteOfAnother {

    public static void main(String[] args) {
        new ArePermuteOfAnother().run();
    }

    public void run() {
        boolean expected_1 = false;
        boolean output_1 = perms("goat","boat");
        check(expected_1, output_1);

        boolean expected_2 = true;
        boolean output_2 = perms("god","dog");
        check(expected_2, output_2);

        boolean expected_3 = true;
        boolean output_3 = perms("a","a");
        check(expected_3, output_3);

        boolean expected_4 = true;
        boolean output_4 = perms("aaa","aaa");
        check(expected_4, output_4);

        boolean expected_5 = true;
        boolean output_5 = perms("","");
        check(expected_5, output_5);
    }

    HashMap<Character,Integer> buildMap(String str){
        HashMap<Character,Integer> map = new  HashMap<Character,Integer>();
        for(Character ch:str.toCharArray()){
            if(!map.containsKey(ch)){
                map.put(ch,1);
            }else{
                map.put(ch,(1+map.get(ch)));
            }
        }
        return map;
    }

    boolean findPermutations(String s1, String s2){
        HashMap<Character,Integer> m1 = buildMap(s1);
        HashMap<Character,Integer> m2 = buildMap(s2);

        if(m1.size()!=m2.size())
            return false;

        if(m1.keySet().containsAll(m2.keySet()))
            return false;

        int count=0;

        return m1.entrySet().stream().
                allMatch(e->e.getValue().equals(m2.get(e.getKey())));

        }
    String sort(String str){
        char [] ch = str.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }

    boolean perms (String s, String t){
        if(s.length()!=t.length())
            return false;
        return sort(s).equals(sort(t));
    }

    int test_case_number = 1;

    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printInteger(boolean n) {
        System.out.print("[" + n + "]");
    }
}

