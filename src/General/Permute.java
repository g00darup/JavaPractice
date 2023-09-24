package General;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute {
    public static void main(String[] args) {
        List li = permute("ABCD","","");
        li.stream().forEach(System.out::println);
    }

    private static List permute(String str,String left, String right) {
        left = str.substring(0,str.length()/2);
        right = str.substring(str.length()/2,str.length());
        return permute(str,left,right);
    }

//    private static List per(String str,String left, String right) {
//    }

}
