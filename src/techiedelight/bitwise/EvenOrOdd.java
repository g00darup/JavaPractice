package techiedelight.bitwise;

import java.util.HashMap;
import java.util.Map;

public class EvenOrOdd {
    static boolean checkEven(int num){
        return (num&1)==0;
    }
    static boolean checkOdd(int num){
        return (num&1)==1;
    }

    static boolean IsOppositeSigns(int num1,int num2){
        return (num1 ^ num2) < 0;
    }

    static int addOne(int n){
        return -(~n);
    }

    static int whatIsIt(int n){
        return (~n)+1;
    }

    static Map swap(int x, int y){
        Map<Integer,Integer> map = new HashMap<>();
        if (x != y)
        {
            x = x ^ y;
            y = x ^ y;
            x = x ^ y;
        }
        map.put(x,y);
        return map;
    }

    static int turnOffKbits(int n, int k){
        return n & (1<<(k-1));
    }

    static int turnOnKbits(int n, int k){
        return n | (1<<(k-1));
    }

    static boolean isKthBitSet(int n, int k) {
    return (n& (1<<(k-1))) !=0;
    }

    static int toggleKthBit(int n, int k){
        return n ^ (1<< (k-1));
    }

    static int setRightMostBit(int n){
        return n & (n-1);
    }

    static int rightMostSetBit(int n){
        if((n&1)!=0)
            return 1;
        n =  n ^ (n & (n-1));

        int pos = 0 ;
        while (n !=0){
            n = n >> 1;
            pos++;
        }
        return pos;
    }

    public static boolean findParity(int n){
        boolean parity = false;

        while(n!=0){
            if((n&1)!=0){
                parity = !parity;
            }
            //rt shif n by 1 (div by 2)
            n = n >> 1;
        }
        return parity;
    }

    public static int countBits(int n){
        int count = 0;

        while (n!=0){
            n = n & (n-1);
            count++;
        }
        return count;
    }

    public static int findNextPowOf2(int n){
        //if is a pow of 2
        n = n-1;

        while((n & n-1)!=0){
            n = n & n-1;
            System.out.println(n);
        }
        return n << 1;
    }

    static int xorOdPord(int a, int prod){
        return a ^ prod;
    }

    public static void main(String[] args) {
//        System.out.println(checkEven(20));
//        System.out.println(checkOdd(21));
//        System.out.println(IsOppositeSigns(8,4));
//          System.out.println(addOne(9));
//        int x = 9;
//        int y = 10;
//        Map m = swap(9,10);
//        System.out.println(m.get(10));
//        int n = 20;
//        int k = 3;
//        System.out.println(n+"binary repr is"+Integer.toBinaryString(n).toString());
//        n = turnOffKbits(n,k);
//        System.out.println(n+"binary repr is"+Integer.toBinaryString(n).toString());
        //System.out.println(findNextPowOf2(127));
        int a = 4;
        int prod = 140;
        System.out.println(xorOdPord(a,prod));
    }

}
