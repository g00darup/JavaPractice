public class Climb {
    public int climbStairs(int n) {
        int [] ways = new int[n+1];
            ways[0] = 1;
            ways[1] =1;        
            for(int c=2;c<=n;c++){
                ways[c] = ways[c-2]+ways[c-1];
            }
        return ways[n];
    }
}
