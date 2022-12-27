package goodrichtomassia.chap01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CarbonC14 {
    List<String> possibleStrings(String[] c){
        //step1
        List<String> str = Stream.of(c).toList();
        List<String> out = combine(str);
        //System.out.println();
        return out;

    }

    List<String> combine(List<String> in){
        List<String> out = new ArrayList<>();
        for (int row =0;row<in.size()-1;row++){
            for(int col=1;col<in.size();col++){
                if(row!=col)
                    out.add(in.get(row)+in.get(col));
            }
        }
        return out;
    }

    public void run() {
        List<String> out = possibleStrings( new String[]{"c","a","r","b","o","n"});
        System.out.println(out);
    }

    public static void main(String[] args) {
        new CarbonC14().run();
    }
}
