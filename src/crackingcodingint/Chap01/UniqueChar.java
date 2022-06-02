package crackingcodingint.Chap01;

import javax.sound.midi.Soundbank;

public class UniqueChar {
    boolean isUnique(String str){
        if(str.length()>256) return false;

        boolean[] char_set = new boolean[256];
        for(int i=0;i<str.length();i++){
            int val = str.charAt(i);
            if(char_set[val])
                return false;
            char_set[val] = true;
        }
        return true;
    }

    boolean isUnique2(String str){
        int checker = 0;
        for (char ch: str.toCharArray()){
            int val = ch -'a';
            if((checker & (1 << val))>0){
                return false;
            }
            checker |= (1<<val);
        }

        return true;
    }
    public static void main(String[] args) {
        int bitmask = 0x000F;
        int val = 0x2222;
        // prints "2"
        //System.out.println(val & bitmask);
        int val2 = 'b' -'a';
        System.out.println(Integer.toBinaryString((1 << val)));

        System.out.println(Integer.toBinaryString((0 & (1 << val))));

        UniqueChar uc = new UniqueChar();

        System.out.println(uc.isUnique2("bollo"));

    }
}
