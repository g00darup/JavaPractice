package GrokkingCodingInterview.datastructure.Stack;

class FindBinChallenge {
    public static String[] findBin(int number) {
        String[] result = new String[number];
        // Write -- Your -- Code
        for(int i=1;i<number;i++){
            result[i-1]  = Integer.toBinaryString(i);
        }

        return result; //For number = 3 , result = {"1","10","11"};
    }
}
