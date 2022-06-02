package CodingTask;

public class AddTwoDigits {
    int addTwoDigits(int n) {
        return (n%10+n/10);
    }

    public static void main(String[] args) {
        AddTwoDigits addTwoDigits = new AddTwoDigits();

        System.out.println(addTwoDigits.addTwoDigits(11));
        System.out.println(addTwoDigits.addTwoDigits(20));

        System.out.println(addTwoDigits.addTwoDigits(93));
        System.out.println(addTwoDigits.addTwoDigits(99));
    }
}
