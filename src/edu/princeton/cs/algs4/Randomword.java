package edu.princeton.cs.algs4;

public class Randomword {
    public static void main(String[] args) throws InterruptedException {
        String champ = StdIn.readString();
        String cahllenger = "";
        int count = 1;
        while(!StdIn.isEmpty()) {
            count++;
            cahllenger = StdIn.readString();
            if(StdRandom.bernoulli(1/count)) {
                champ = cahllenger;
                System.out.println(champ);
                break;
            }
            //Thread.sleep(1_000);
//            if(StdIn.isEmpty()) {
//                System.out.println(out);
//                break;
//            }
        }

    }
}
