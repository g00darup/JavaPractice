package com.testplayground.lambda;

/* Online Java Compiler and Editor */
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HelloWorld{

    public static void main(String []args){
        int[] n1 = new int[] { 1, 2, 3 ,3,2,1};
        int[] n2 = new int[] { 1, 2, 3 };
        System.out.println(compareArrays(n1,n2));
    }

    public static boolean compareArrays(int[] arr1, int[] arr2 ){
        return Arrays.stream(arr1).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).keySet().equals(
               Arrays.stream(arr2).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).keySet());
    }
}