package General.algo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BinarySearch {
    static int search(List<Integer> list, int key){
        int left = 0;
        int right = list.size() -1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(list.get(mid)==key){
                return mid;
            }else if(list.get(mid)<key){
                left = mid+1;
            }else if(list.get(mid)>key){
                right = mid-1;
            }
        }
        return -1;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
//        int target = Integer.parseInt(scanner.nextLine());
//        scanner.close();
        List<Integer> arr = List
                .of(1,2,3,4,5,6,7,8);
        int res = search(arr, 6);
        System.out.println(res);
    }
}
