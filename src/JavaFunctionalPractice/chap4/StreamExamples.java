package JavaFunctionalPractice.chap4;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples {
    public static void main(String[] args) {
        int[] numbers = {3,6,8,8,4,6,3,3,5,6,9,4,3,6};
        IntStream stream = Arrays.stream(numbers);

        Rectangle[] rectangles = {
                new Rectangle(10, 10, 50, 75),
                new Rectangle(30, 40, 30, 45),
                new Rectangle(110, 70, 70, 15),
                new Rectangle(50, 10, 45, 35)
        };
        Stream<Rectangle> stream2 = Arrays.stream(rectangles);

        Supplier intSupplier = () -> 0;
        Stream.generate(intSupplier)
                .limit(5)
                .forEach(System.out::println);



        int total = stream2
                .map(r -> r.scale(0.25))
                .mapToInt(Rectangle::getArea)
                .reduce(0,(r, s) -> r + s);

    }
}
