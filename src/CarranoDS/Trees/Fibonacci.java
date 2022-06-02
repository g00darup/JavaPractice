package CarranoDS.Trees;

import java.util.HashMap;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Fibonacci {

    public Fibonacci(HashMap<Integer, Integer> fibCache) {
        this.fibCache = fibCache;
    }

    public HashMap<Integer, Integer> getFibCache() {
        return fibCache;
    }

    public void setFibCache(HashMap<Integer, Integer> fibCache) {
        this.fibCache = fibCache;
    }

    public HashMap<Integer,Integer> fibCache;

    public FibInterface<Number> normalFint = (n)->{
        if(n==1 || n==0){
            return n;
        }
        else {
            return (n-1)+(n-2);
        }
    };

    public FibInterface<Number> cachedFib = (n)->{
        if(fibCache.containsKey(n)){
            return fibCache.get(n).intValue();
        }else{
            FibInterface<Number> normalFint1 = normalFint;
            return normalFint1.fib(n);
        }
    };

    long timing(FibInterface<Number> methodToTime, int n){
        long startTime = System.nanoTime();
        int k = methodToTime.fib(n);
        System.out.println("Fibonacci of "+n+" is:"+k);
        long endTime = System.nanoTime();
        return endTime-startTime;
    }

//    UnaryOperator<Integer> fact; {
//        fact = i -> i == 0? 1 : fact.apply(i-1);
//    }

    public static void main(String[] args) {
        Function<Integer,Integer> fac = i -> 2*i;
        Fibonacci f = new Fibonacci(new HashMap<>());
        //System.out.println("time spent in fib"+f.timing(f.normalFint,3));
        System.out.println(fac.apply(2));
    }
}


interface FibInterface<I extends Number> {
    int fib(int param1);
}
