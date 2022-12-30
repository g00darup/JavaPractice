package main.java.edu.java.lambda.functional;

import java.time.LocalDateTime;
import java.util.function.Supplier;

class SupplierImpl implements Supplier<LocalDateTime>{

    @Override
    public LocalDateTime get() {
        return LocalDateTime.now();
    }
}

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<LocalDateTime> supp = new SupplierImpl();
        System.out.println(supp.get());

        Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
        System.out.println(supplier.get());
    }
}
