package JavaFunctionalPractice.chap3;

public class Boat {
    private String name;
    private String country;
    private int tonnage;
    private int draft;

    public String getName() {
        return name;
    }


    public String getCountry() {
        return country;
    }


    public int getTonnage() {
        return tonnage;
    }


    public int getDraft() {
        return draft;
    }

    public Boat setName(String name) {
        this.name = name;
        return this;
    }

    public Boat setCountry(String country) {
        this.country = country;
        return this;
    }

    public Boat setTonnage(int tonnage) {
        this.tonnage = tonnage;
        return this;
    }

    public Boat setDraft(int draft) {
        this.draft = draft;
        return this;
    }

    public String toString() {
        return "Name: " + this.name + " Country: " + this.country
                + " Tonnage: " + this.tonnage + " Draft: " + this.draft;
    }

}
