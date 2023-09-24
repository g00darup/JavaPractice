package com.cs.inheritance.input;

import java.io.IOException;
import java.util.Scanner;

public class InputExample {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter height in cms: __");
        float ht = scanner.nextFloat();

        System.out.println("Enter weight in kgs: __");
        float wt = scanner.nextFloat();

        float bmi = wt / (ht*ht) * 10000;

        System.out.println("bmi is "+bmi);
    }
}
