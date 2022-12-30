package main.java.edu.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMap {
    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        users.add((new User(1,"AronBlack","blackaron","aronblack@gmail.com")));
        users.add((new User(2,"BobbyBrown","brownbobby","bobbybrown@gmail.com")));
        users.add((new User(3,"EllaFlower","flowerella","ellaflower@gmail.com")));
        users.add((new User(4,"MaryLamb","lambmary","marylamb@gmail.com")));

        List<UserDTO> userDTOS = new ArrayList<>();
        for(User user:users){
            userDTOS.add(new UserDTO(user.getId(),user.getUserName(),user.getEmail()));
        }

        userDTOS = users.stream().map((User user) -> new UserDTO(user.getId(), user.getUserName(),
                        user.getEmail())).collect(Collectors.toList());

        userDTOS.stream().forEach(System.out::println);
    }
}
