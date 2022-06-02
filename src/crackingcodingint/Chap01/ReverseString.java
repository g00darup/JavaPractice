package crackingcodingint.Chap01;

public class ReverseString {
    public void run() {
        String expected_1 = "cba";
        String output_1 = reverse("abc");
        check(expected_1, output_1);

        String expected_2 = "aba";
        String output_2 = reverse("aba");
        check(expected_2, output_2);

        String expected_3 = "a";
        String output_3 = reverse("a");
        check(expected_3, output_3);

        String expected_4 = "aaa";
        String output_4 = reverse("aaa");
        check(expected_4, output_4);

        String expected_5 = "";
        String output_5 = reverse("");
        check(expected_5, output_5);
    }

    public static void main(String[] args) {
        new ReverseString().run();
    }
    String reverse (String str){
        if(str==null)
            return str;

        if(str!=null && (str.equals("") || str.length()==1))
            return str;

//        String front=str.substring(0,1);
//        String back=str.substring(1,str.length());
//        return revHelper(front,back,0,str.length());
        char[] c = str.toCharArray();
        reverseHelper(c,0, str.length()-1);
        //return new String(c);
        return reverse3(str);
    }

    public void reverseHelper(char[] c, int l, int h){
        if (l < h){
            swap(c, l, h);
            reverseHelper(c, l + 1, h - 1);
        }
    }

    private void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    String reverse3(String input){
        StringBuilder input1 = new StringBuilder();

        // append a string into StringBuilder input1
        input1.append(input);

        // reverse StringBuilder input1
        return input1.reverse().toString();

    }

    private static String revHelper(String f, String b, int init,int len){
        if (init == len) {
            return b+f;
        }else {

            // b = bc
            // f = a
            b = b + f;
            System.out.println(b);
            f = b.substring(0, 1);
            b = b.substring(1,b.length());
            System.out.println(f);

            System.out.println(b);

            init = init+1;
            return revHelper(f,b,init,len);
        }
    }

    int test_case_number = 1;

    void check(String expected, String output) {
        boolean result = (expected.equals(output));
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
    void printInteger(String n) {
        System.out.print("[" + n + "]");
    }


}
