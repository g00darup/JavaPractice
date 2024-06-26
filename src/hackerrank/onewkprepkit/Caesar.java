package hackerrank.onewkprepkit;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result2 {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        // Write your code here
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] shifted = new char[alphabet.length];
        shifted = shiftAlphabet(alphabet, k);
        Map m = new HashMap<>();
        Map<Character, Character> shiftedMap = createShiftedMap(alphabet, k);

        // Print the map
        for (Map.Entry<Character, Character> entry : shiftedMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        char[] input = null;
        input = s.toCharArray();
        for (int i = 0; i < input.length; i++) {
            input[i] = shiftedMap.get(input[i]);
        }
        return input == null ? null : new String(input);
    }

    public static char[] shiftAlphabet(char[] alphabet, int k) {
        char[] shifted = new char[alphabet.length];
        int length = alphabet.length;

        for (int i = 0; i < length; i++) {
            shifted[i] = (char) ((alphabet[i] - 'a' + k) % 26 + 'a');
        }

        return shifted;
    }

    public static Map<Character, Character> createShiftedMap(char[] alphabet, int k) {
        Map<Character, Character> shiftedMap = new HashMap<>();
        int length = alphabet.length;

        for (int i = 0; i < length; i++) {
            char shiftedChar = (char) ((alphabet[i] - 'a' + k) % 26 + 'a');
            shiftedMap.put(alphabet[i], shiftedChar);
        }

        return shiftedMap;
    }
}

public class Caesar {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result2.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
