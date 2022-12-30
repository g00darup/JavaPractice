package goodrichtomassia.chap01;
/*
Suppose that we create an array A of GameEntry objects, which has an integer scores field,
and we clone A and store the result in an array B. If we then immediately set A [4].score equal to 550,
what is the score value of the GameEntry object referenced by B[4]?
 */

public class R1dot1 {
    public static void main(String args[]){

        GameEntry [] A =new GameEntry[5];
        GameEntry [] B = A.clone();
        A[4] = new GameEntry("new",550);

     //   System.out.println(B[4].getScore());

        System.out.println(isMultiple(21,5));
        System.out.println(isOdd(3));

        String s1="8d6492397d8271db6db4e60e18b2aa90a51c68e138569ecfbaa4a13cc024338d";
        String s2="8d6492397d8271db6db4e60e18b2aa90a51c68e138569ecfbaa4a13cc024338d";

        if(s1.equals(s2))
            System.out.println("Strings are same");

    }

    static boolean isOdd(int i){
        int i1 = i & 1;
        //boolean b = !i1;
        return !(i1==0);
    }

    static boolean isMultiple(long n, long m){
        double j = n/m;
        int i = (int) j;

        return n==m*i;
    }

}


class GameEntry{
    public GameEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }


    public int getScore() {
        return score;
    }


    protected String name;
    protected int score;


}