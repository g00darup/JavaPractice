package com.testplayground.lambda;

import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();

        strings.add("This pad is running Java " + Runtime.version().feature());

        for (String string : strings) {
            System.out.println(string);
        }
        int in[] = {2,0,2};
        int in2[] = {3,0,2,0,4};

        System.out.println(calcLen(in));
        System.out.println(calcLen(in2));

    }

    static int calcLen(int[] in){
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