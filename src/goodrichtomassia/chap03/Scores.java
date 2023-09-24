package goodrichtomassia.chap03;

import java.util.Arrays;

public class Scores {
    public static final int maxEntries = 5;
    protected int numEntries;
    protected GameEntry[] entries;

    public Scores() {
        entries = new GameEntry[maxEntries];
        numEntries = 0;
    }

    @Override
    public String toString() {
        return "Scores{" +
                "numEntries=" + numEntries +
                ", entries=" + Arrays.toString(entries) +
                '}';
    }

    void addGameEntry(GameEntry e) throws Exception {
        int newSc = e.getScore();

        if(numEntries == maxEntries){
            if(newSc <= entries[numEntries-1].getScore())
                return;
        }else
            numEntries++;
        int i = numEntries-1;
        for (;(i>=1) && (newSc > entries[i-1].getScore());i--)
            entries[i] = entries[i-1];
        entries[i] = e;

    }

    public static void main(String[] args) throws Exception {
        Scores sc = new Scores();
//        sc.numEntries = maxEntries;
//        sc.entries = new
        sc.addGameEntry(new GameEntry("A",700));
        sc.addGameEntry(new GameEntry("B",600));
        sc.addGameEntry(new GameEntry("C",200));
        sc.addGameEntry(new GameEntry("D",400));
        sc.addGameEntry(new GameEntry("E",500));
        sc.addGameEntry(new GameEntry("F",300));
        sc.addGameEntry(new GameEntry("F",900));

        Arrays.stream(sc.entries).forEach(i-> System.out.println(i));
    }
}
