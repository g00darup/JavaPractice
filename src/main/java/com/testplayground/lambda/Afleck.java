package main.java.com.testplayground.lambda;

import com.example.testplayground.MoreAnimals.Animal;

import java.util.*;
import java.util.function.Predicate;

public class Afleck {
    <T> T method1(List<? extends T> list) {
        return list.get(0);
    }

//    <B extends A> B method3(List<B> list) {
//        return new B();   // DOES NOT COMPILE
//    }

    void method4(List<? super A> list) {
    }

    public static void main(String[] args) {
        
//        Animal animal1 = new Animal.AnimalBuilder(java.util.UUID.randomUUID())
//                .setAge(11).setSpecies("Bull").build();

        String[] array = {"gerbil", "mouse"};      // [gerbil, mouse]
        List<String> list = Arrays.asList(array);   // returns fixed size list
        list.set(1, "test");                         // [gerbil, test]
        list.remove(1);
        array[0] = "new";                            // [new, test]
        String[] array2 = (String[]) list.toArray(); // [new, test]
        list.remove(1);
        List<String> keywords = new ArrayList<>();
        keywords.add("java");

    List<?> list1 = new ArrayList<>();
    List<? extends A> list2 = new ArrayList<>();
    List<? super A> list3 = new ArrayList<A>();
    //List<? extends B> list4 = new ArrayList<A>();   // DOES NOT COMPILE
   List<? super B> list5 = new ArrayList<A>();
   //List<?> list6 = new ArrayList<? extends Object>();
      //  Comparator<Duck> byWeight = (Duck d1, Duck d2) -> d1.getWeight()—d2.getWeight();
String str = "abc";
        //Predicate<String> method1=strstartsWith;
    }
}

class A {}
class B extends A { }
class C extends B { }

 class Duck implements Comparable<Duck> {
    private String name;
    private int weight;
    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    public String getName() {  return name; }
    public int getWeight() {  return weight; }
    public String toString() { return name; }
    public int compareTo(Duck d) {
        return name.compareTo(d.name);
    }
}

class SortRabbits {
    static class Rabbit{ int id; }
    public static void main(String[] args) {
        List<Rabbit> rabbits = new ArrayList<>();
        rabbits.add(new Rabbit());
        Comparator<Rabbit> c = (r1, r2) -> r1.id - r2.id;
        Collections.sort(rabbits, c);
    } }
    
    
        interface Gorilla { String move(); }
    class GorillaFamily {
       String walk = "walk";
       void everyonePlay(boolean baby) {
          String approach = "amble";
         //approach = "run";

         play(() -> walk);
         play(() -> baby ? "hitch a ride" : "run");
        play(() -> approach);
     }
     void play(Gorilla g) {
        System.out.println(g.move());
     }
   }