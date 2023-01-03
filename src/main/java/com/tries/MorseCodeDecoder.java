package main.java.com.tries;

import java.util.Arrays;

public class MorseCodeDecoder {
    public static String decode(String morseCode) {
        // your brilliant code here, remember that you can access the preloaded Morse code table through MorseCode.get(code)
        String [] codeArr = morseCode.split("");
        StringBuffer buf = new StringBuffer();
        Arrays.stream(codeArr).forEach(s->buf.append(s));
        return buf.toString();
    }

    public static <T> long count(T[] elems) {
        long count = Arrays.stream(elems).distinct().count();
        long base = 2;
        long result = 1;

        while (count != 0) {
            result = result * base;
            count--;
        }
        return result-1;
    }

    public static void main(String[] args) {
        System.out.println(decode(".__.__"));
    }
}