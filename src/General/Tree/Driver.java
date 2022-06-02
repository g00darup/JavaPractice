package General.Tree;

import java.util.function.Function;

public class Driver {

    public static void main(String[] args) {
        TenX x=new TenX();
        //Integer y=0;

//        (y) =  y-> y*2;
//
//        Function mul = x -> {
//            return x * 10;
//        };
        System.out.println(x.apply(20));
    }

    static class TenX implements IntUnaryFunction{

        @Override
        public int apply(int x) {
            return 20*x;
        }
    }
}
