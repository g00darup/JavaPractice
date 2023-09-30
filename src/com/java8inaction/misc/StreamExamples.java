package com.java8inaction.misc;

import java.util.List;
import java.util.stream.Collectors;

public class StreamExamples {
    public static void main(String[] args) {
        List<User> usrs = List.of(
                new User(1,"Xas","Pas","xas@as.com"),
                new User(2,"Bas","Pas","bas@as.com"),
                new User(3,"Mas","Pas","mas@as.com"));

        List<UserDTO> userDTOS = usrs.
                stream().
                map(user-> new UserDTO(user.getId(),
                        user.getUsrName(),user.getEmail())).
                collect(Collectors.toList());

        userDTOS.forEach(System.out::println);
    }
}
