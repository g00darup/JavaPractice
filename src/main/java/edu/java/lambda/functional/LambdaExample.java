package main.java.edu.java.lambda.functional;

interface Shape{
    void draw();
}

class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Rectangle class: draw method");
    }
}

class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Square class: draw method");
    }
}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Circle class: draw method");
    }
}

public class LambdaExample {
    public static void main(String[] args) {

        String stre = "hello";

        Shape rectangle =  () -> System.out.println("Square class: draw method");
        rectangle.draw();

    }
}
