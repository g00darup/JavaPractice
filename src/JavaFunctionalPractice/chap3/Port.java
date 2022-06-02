package JavaFunctionalPractice.chap3;

import java.util.ArrayList;
import java.util.List;

public class Port {
    private List<Boat2> boats = new ArrayList<>();

    public Boat2 add(String name) {
        Boat2 boat = new Boat2().named(name);
        boats.add(boat);
        return boat;
    }

    public Boat2 add(Boat2 boat) {
        boats.add(boat);
        return boat;
    }
}