package JavaFunctionalPractice.chap3;

public class BoatApply {
    public static void main(String[] args) {
        Boat b = new Boat();
        b.setName("Albatross")
                .setCountry("Panama")
                .setTonnage(12000)
                .setDraft(25);
    }
}
