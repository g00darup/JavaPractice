package JavaFunctionalPractice;

import java.util.Arrays;
import java.util.function.BiFunction;

public class Employee {
    enum EmployeeType {Hourly, Salary, Sales};

    public static float calculatePay(int hourssWorked,
                              float payRate, EmployeeType type) {
        switch (type) {
            case Hourly:
                return hourssWorked * payRate;
            case Salary:
                return 40 * payRate;
            case Sales:
                return 500.0f + 0.15f * payRate;
            default:
                return 0.0f;
        }
    }
    public static BiFunction<Integer, Float, Float> calculatePayFunction(
            EmployeeType type) {
        switch (type) {
            case Hourly:
                return (hours, payRate) -> hours * payRate;
            case Salary:
                return (hours, payRate) -> 40 * payRate;
            case Sales:
                return (hours, payRate) -> 500f + 0.15f * payRate;
            default:
                return null;
        }
    }
    static int  totalHoursWorked(int hoursWorked[]) {
        return Arrays.stream(hoursWorked).sum();
    }

    public static void main(String[] args) {
        int hoursWorked[] = {8, 12, 8, 6, 6, 5, 6, 0};
        int totalHoursWorked = totalHoursWorked(hoursWorked);
//        System.out.println(
//                calculatePay(totalHoursWorked, 15.75f, EmployeeType.Hourly));
        BiFunction<Integer, Float, Float> calculateFunction;
        calculateFunction = calculatePayFunction(EmployeeType.Hourly);

        System.out.println(calculateFunction.apply(
                totalHoursWorked,15.75f));
    }
}
