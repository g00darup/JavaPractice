package main.java.edu.java.stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListForEachExample {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("Jack",29));
        list.add(new Person("Tony",53));
        list.add(new Person("Tom",33));
        list.add(new Person("John",45));

        list.forEach(person -> {System.out.println(person.getName());
            System.out.println(person.getAge());}
        );

        list.stream().forEach(person ->
                {
                    System.out.println(person.getName());
                System.out.println(person.getAge());
                }
        );

        Set<Person> set = new HashSet<>();
        set.add(new Person("Ramsay",29));
        set.add(new Person("Tony",50));
        set.add(new Person("Tom",45));
        set.add(new Person("John",55));

//        for(Person person : set){
//            System.out.println(person.getName());
//            System.out.println(person.getAge());
//        }

        set.stream().forEach((person -> {
            System.out.println(person.getName()+"--"+person.getAge());
        }));

    }
}
