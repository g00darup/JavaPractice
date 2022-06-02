package JavaFunctionalPractice.chap3;

import java.util.function.Function;

public class ApplySalesCustomer {
    public static void main(String[] args) {
        Customer customer = new Customer("bestcustomer@thebestcustomer.com");
        Salesman salesman = new Salesman(customer);
        System.out.println(salesman.getBestCustomer() .getEmailAddress());

        Function<Customer, String> customerToEmailAddress =
                Customer::getEmailAddress;
        Function<Salesman, Customer> salesmanToBestCustomer =
                Salesman::getBestCustomer;
        Function<Salesman, String> toEmailAddress =
                salesmanToBestCustomer.andThen (customerToEmailAddress);

        System.out.println(toEmailAddress.apply(salesman));


        Function<Manager, String> managerToEmailAddress =
                Manager::getEmailAddress;
        Function<Salesman, Manager> salesmanToManager =
                Salesman::getManager;
        Function<Salesman, String> toManagerEmailAddress =
                salesmanToManager.andThen(managerToEmailAddress);

        Manager manager = new Manager("manager@thecompany.com");
        Salesman salesman2 = new Salesman(manager);
        System.out.println(toManagerEmailAddress.apply(salesman2));
        System.out.println(salesman2.getManager().getEmailAddress());

        processEmailAddress(salesman,toEmailAddress);
        processEmailAddress(salesman2,toManagerEmailAddress);
    }

    public static void processEmailAddress(
            Salesman salesman,
            Function<Salesman, String> toEmailAddress) {
        System.out.println(toEmailAddress.apply(salesman));
    }
}
