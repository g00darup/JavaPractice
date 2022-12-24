package CarranoDS.Chap01.Projects;

public enum Rank {
    ACE("ACE",true), TWO("TWO",false), THREE("THREE",false),
    FOUR("FOUR",false), FIVE("FIVE",false), SIX("SIX",false),
    SEVEN("SEVEN",false), EIGHT("EIGHT",false), NINE("NINE",false),
    TEN("TEN",false),JACK("JACK",true),
    QUEEN("QUEEN",true), KING("KING",true);

    private boolean data;

    Rank(String card, boolean value){
        this.data=value;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "data=" + data +
                '}';
    }
}
