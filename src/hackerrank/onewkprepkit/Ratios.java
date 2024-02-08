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
class Ratios2 {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        final DecimalFormat df = new DecimalFormat("#.######");
        int tot=0,zCount=0,pCount=0,nCount=0;
        double pR = 0.0,nR=0.0,zR=0.0;

        if(arr!=null){
            tot = arr.size();
        }

        if(tot>0){
            for(int c=0;c<tot;c++){
                if(arr.get(c).intValue()>0)
                    pCount++;
                else if(arr.get(c).intValue()<0)
                    nCount++;
                else if(arr.get(c).intValue()==0)
                    zCount++;
            }
            pR = (pCount*1.0/tot);
            nR = (nCount*1.0/tot);
            zR = (zCount*1.0/tot);

            System.out.println(df.format(pR));
            System.out.println(df.format(nR));
            System.out.println(df.format(zR));
        }
    }

}

public class Ratios {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Ratios2.plusMinus(arr);

        bufferedReader.close();
    }
}

