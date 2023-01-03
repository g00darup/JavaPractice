package main.java.edu.java.stream;

import java.util.HashMap;
import java.util.Map;

public class MapForEachExample {
    public static void main(String[] args) {
        Map<Integer, Person> map = new HashMap<Integer,Person> ();

        map.put(1, new Person("Ramsay", 29));
        map.put(2, new Person("Tony", 50));
        map.put(3, new Person("John",55));

        for(Map.Entry<Integer, Person> entry: map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue().getName());
        }

        map.forEach((k,v)->{
            System.out.println(k+"--"+v);
        });
    }
}
