package Skienna;

import java.util.List;
import java.util.stream.Collectors;

public class TheTrip {
    public static double minTransferNeeded(List<Double> expenses){
        Double sum = expenses.stream().mapToDouble(Double::doubleValue).sum();
        Double average = expenses.stream().mapToDouble(Double::doubleValue).average().getAsDouble();

        List<Double> diffList = expenses.stream().map(e->average-e).collect(Collectors.toList());
        List<Double> negatives = diffList.stream().filter(e-> e<0).collect(Collectors.toList());

        if(expenses.size()%2==0){
            sum = negatives.stream().mapToDouble(Double::doubleValue).sum();
        }

        if(expenses.size()%2!=0){
            //extract even and odd elemenys of list
            List odds = diffList.stream().filter(e-> e%2!=0).collect(Collectors.toList());
            List evens = diffList.stream().filter(e-> e%2==0).collect(Collectors.toList());
        }

        return sum*-1;

    }

    public static void main(String[] args) {
            List<Double> expenses = List.of(15.00,15.01,3.00,3.01);
            System.out.println(minTransferNeeded(expenses));
    }
}
