package General.Tree;

import java.util.Arrays;

public class User {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    int id;
    String name;
    String email;

    public static void main(String[] args) {
        User[] users = {
                new User(2, "Christine", ""),
                new User(4, "Kevin", ""),
                new User(5, "Alex", ""),
                new User(1, "Lauren", ""),
                new User(1, "Catherine", "")
        };
//        Arrays.sort(users);
//        for (User user : users) {
//            System.out.println(user);
//        }

        Arrays.sort(users, (o1, o2) -> (Integer.compare(o1.id, o2.id)));
        //System.out.println(Arrays.toString(users)); // [3, 2, 1]
        Arrays.asList(users).forEach(o-> System.out.println(o.name));
    }
}
