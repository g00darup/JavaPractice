package goodrichtomassia.chap03;

public class GameEntry {
    protected String name;
    protected int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public GameEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }


    @Override
    public String toString() {
        return "GameEntry{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

}
