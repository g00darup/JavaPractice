package main.java.edu.java.lambda.functional;
interface Addable{
    int addition(int a, int b);
}

//class AddableImpl implements Addable{
//
//    @Override
//    public int addition(int a, int b) {
//        return a+b;
//    }
//}

public class LamdaParameters {
        public static void main(String[] args) {
        Addable addable = (int a, int b) ->  a+b;
        int res = addable.addition(10,20);
        System.out.println(res);

        Addable abc = (int a, int b) ->{
            int c = a+b;
            return c*2;
        };

            res = abc.addition(10,20);
            System.out.println(res);
    }
}
