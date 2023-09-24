package com.cs.inheritance;

public class Pair <K,V>{
    K key;
    V value;

    public void set(K k,V v) {
        key =k;
        value =v;
    }
    public K getKey() {return key;}

    public V getValue() {return value;}

    public String toString() {
        return "[" + getKey() + "," + getValue() + "]";
    }

    public static void main (String[] args){
        Pair<String, Integer> pair1 = new Pair<String,Integer>();
        pair1.set(new String("height"), 36);
        System.out.println(pair1);

        Pair<Student, Double> stdPaoir = new Pair<>();
        stdPaoir.set(new Student(new Name("N95","Mask"),"123"),19.0);
        System.out.println(stdPaoir);
    }
}
