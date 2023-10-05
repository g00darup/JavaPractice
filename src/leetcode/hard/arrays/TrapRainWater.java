package leetcode.hard.arrays;

public class TrapRainWater {
    public int trap(int[] in) {
        int l=0,r=0,c=0;
        if(in[0]>0 && in[in.length-1]>0){
            l=Math.min(in[0],in[in.length-1]);
        }
        c=l*(in.length-2);
        for(int i=1;i<in.length-1;i++){
            r=in[i];
            c=c-r;
        }

        return c;
    }
}
