package main.java.edu.java.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamListSorting {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<String>();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Orange");

        List<String> sortedList = fruits.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        //System.out.println(sortedList);

        List<String> sortedList2 = fruits.stream().sorted((o1,o2)->o1.compareTo(o2)).collect(Collectors.toList());
        //System.out.println(sortedList2);

        List<String> sortedListDesc = fruits.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        //System.out.println(sortedListDesc);

        List<String> sortedListDesc2 = fruits.stream().sorted((o1,o2)->o2.compareTo(o1)).collect(Collectors.toList());
        //System.out.println(sortedListDesc2);

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(10,"Ramsay", 30, 200000));
        employees.add(new Employee(20,"Gordon", 32, 300000));
        employees.add(new Employee(30,"Haris", 33, 400000));
        employees.add(new Employee(40,"Pipo", 38, 500000));

        List<Employee> employeesSortedList = employees.stream().sorted(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.getSalary() - o2.getSalary());
            }
        }).collect(Collectors.toList());

        List<Employee> employeesSortedList2 = employees.stream().sorted(
                ( o1,  o2)-> (int) (o1.getSalary() - o2.getSalary())).collect(Collectors.toList());

        List<Employee> employeesSortedList3 = employees.stream().sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());

        List<Employee> employeesSortedList4 = employees.stream().sorted(Comparator.comparing(Employee::getAge))
                .collect(Collectors.toList());

        List<Employee> employeesSortedList5 = employees.stream().sorted(Comparator.
                        comparing(Employee::getName).reversed())
                .collect(Collectors.toList());
        System.out.println(employeesSortedList5);

    }
}
