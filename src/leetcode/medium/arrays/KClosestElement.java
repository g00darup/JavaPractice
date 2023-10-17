package leetcode.medium.arrays;

import java.util.*;
import java.util.stream.Collectors;

class KClosestElement {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int possIndx = find(arr,x);
           HashMap<Integer,Integer> diffMap = new HashMap<>();
//            if (possIndx>0 ){
//                int[] possArr = new int[2*possIndx];
//                possArr = new int[2*possIndx];
//                System.arraycopy(arr,Math.abs(possIndx-k),possArr,possIndx,(possIndx+1));
//                System.arraycopy(arr,possIndx,possArr,possIndx+k,(possIndx+1));
//                diffMap = createDifMap(possArr,x);
//            }else{
                diffMap = createDifMap(arr,x);
                int pos = find(arr,x);
//        }

           List<Integer> res = new ArrayList<>();
           int count = 0;
           int diff = 0;
           Object [] o1 = diffMap.keySet().toArray();
           int [] keys = Arrays.stream(o1).mapToInt(o -> (int)o).toArray();

           Object[] o2 = diffMap.values().toArray();
           int[] vals = Arrays.stream(o2).mapToInt(o -> (int)o).toArray();
           for(int m=0;m<vals.length;m++){
               if(vals[m]==diff && count<k){
                   res.add(keys[m]);
                   diff++;
                   count++;
                }

            }

//            for (Map.Entry<Integer, Integer> entry: diffMap.entrySet()){
//                if(entry.getValue()==diff && count<k){
//                    count++;
//                    res.add(entry.getKey());
//                    diff++;
//                }
//            }
            //diffMap.values().stream().collect(Collectors.toList());
            return res;

    }

    int find(int[] arr, int x){
        int l = 0;
        int r = arr.length-1;
        int val = binSearch(arr,l,r,x);
        return val;

    }

    private int binSearch(int[] arr, int l, int r, int x) {
        int mid = (l+r)/2;
        if(arr[mid] == x){
            return mid;
        }else if (x < arr[mid]){
            r = mid;
            return binSearch(arr,l,r,x);
        }else if (x > arr[mid]){
            l = mid;
            return binSearch(arr,l,r,x);
        }else{
            return -1;
        }
    }

    HashMap<Integer, Integer> createDifMap(int[] arr,int x){
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i<arr.length;i++){
            map.put(arr[i],Math.abs(arr[i]-x));
        }

        return map;
    }

    public static void main(String[] args) {
        //Input: arr = [1,2,3,4,5], k = 4, x = 3
        int [] arr = {1,2,3,4,5};
        KClosestElement k = new KClosestElement();
        List res = k.findClosestElements(arr,4,3);
        res.forEach(System.out::println);
    }
}