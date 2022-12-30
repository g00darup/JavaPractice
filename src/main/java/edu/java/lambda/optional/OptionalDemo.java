package main.java.edu.java.lambda.optional;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

        String email = null;
        //Optional<String> emailOptional = Optional.of(email);
        //System.out.println(emailOptional);

        Optional<String> stringOptional = Optional.ofNullable(email);
       // System.out.println(stringOptional.get());

        if(stringOptional.isPresent())
            System.out.println(stringOptional.get());
        else
            System.out.println("No value presentssssss");

        String defaultOptional = stringOptional.orElseGet(()->"default@gmail.com");
        System.out.println(defaultOptional);

//        String optObj = stringOptional.orElseThrow(()->  new IllegalArgumentException("Email does not exist"));
//        System.out.println(optObj);

        Optional<String> gender = Optional.of("MALE");
        Optional<String> emptOpt = Optional.empty();

        gender.ifPresent((s)-> System.out.println("Gender is: {} "+s));
        emptOpt.ifPresent((s -> System.out.println("no value present")));

        String result = "abc";
        if(result!=null && result.contains(("abc"))){
            System.out.println(result);
        }

        Optional<String> optString = Optional.of(result);
        optString.filter(res->res.contains("abc"))
                .map(String::trim)
                .ifPresent((res)-> System.out.println(res));
    }
}
