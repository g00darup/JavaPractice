package leetcode.easy.Stack;

import java.util.ArrayDeque;

class RevString {
    public void reverseString(char[] s) {
        ArrayDeque st = new ArrayDeque(s.length);
        for(int i=0;i<s.length;i++){
            st.push(s[i]);

        }

        for(int i=0;i<s.length;i++){
            s[i] = (Character) st.peek();
            st.pop();
        }
    }

    public static void main(String[] args) {
        char[] s = new char[5];
        s[0] = 'j';
        s[1] = 'a';
        s[2] = 'k';
        s[3] = 'a';
        s[4] = 'l';

        RevString st = new RevString();
        st.reverseString(s);

        for(int i=0;i<s.length;i++){
            System.out.println(s[i]);
        }
    }
}