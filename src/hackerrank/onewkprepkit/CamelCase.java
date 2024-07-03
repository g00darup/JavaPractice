package hackerrank.onewkprepkit;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CamelCase {


        public static void main(String[] args) throws IOException {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
           // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            //int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<String> lines = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .collect(Collectors.toList());


//            bufferedWriter.write(
//                    result.stream()
//                            .map(Object::toString)
//                            .collect(joining(" "))
//                            + "\n"
//            );

            for(String l : lines){
                System.out.println(l);
            }

            bufferedReader.close();
//            bufferedWriter.close();
        }

}
