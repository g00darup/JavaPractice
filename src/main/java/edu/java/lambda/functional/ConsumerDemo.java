package main.java.edu.java.lambda.functional;

import java.util.function.Consumer;

class ConsumerImpl implements Consumer<String> {

    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}


public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> cn = new ConsumerImpl();
        cn.accept("Hello World");

        Consumer<String> consumer =   (s) ->  System.out.println(s);

        consumer.accept("Hello World");


    }
}
