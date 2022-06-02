package leetcode.hard;


class FrogJump {
    public int getCurrIndex() {
        return currIndex;
    }

    public void setCurrIndex(int currIndex) {
        this.currIndex = currIndex;
    }

    volatile int currIndex;
    volatile int size;
//    boolean proceed = true;

    public boolean canCross(int[] stones) {
        //int currIndex=0;
        boolean proceed = false;
        if(getCurrIndex()>stones.length-1)
            return false;

        while (getCurrIndex()>stones.length-1) {
            incrementK();
            proceed = canJumpHelper(stones, getCurrIndex(),getSize())>0;
        }

        return proceed;
    }

    int canJumpHelper(int[] stones,int currIndex,int k){
        int  l =currIndex;
        int  r = stones.length-1;
        int key = stones[currIndex];

        int indx1 = find(stones,l,r,key+k);
        int indx2 = find(stones,l,r,key+k+1);
        int indx9 = find(stones,l,r,key+k-1);

        if(indx2 >0)
            incrementK();

        if(indx2>0)
            setCurrIndex(indx2);
        else if(indx1>0)
            setCurrIndex(indx1);
        else if(indx9>0)
            setCurrIndex(indx9);

        return currIndex;
    }

    void incrementK(){
        size = size+1;
    }

    int getSize(){
        return size;
    }

    boolean search(int[] stones,int currIndex, int k){
        int  l =currIndex;
        int r = stones.length-1;
        int search = find(stones, l, r, stones[currIndex] + k);
        if(search >=0)
            return true;
        else {
            return false;
        }
    }

    int find(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x)
                return mid;

            if (arr[mid] > x)
                return find(arr, l, mid - 1, x);

            return find(arr, mid + 1, r, x);
        }
        return -1;
    }
    int test_case_number = 1;
    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }

    public void run() {
        FrogJump f = new FrogJump();
        int[] array_a_1 = {0,1,3,5,6,8,12,17};
        boolean expected_1 = true;
        boolean output_1 = f.canCross(array_a_1);
        check(expected_1, output_1);

        int[] array_a_2 = {0,1,2,3,4,8,9,11};
        boolean expected_2 = false;
        boolean output_2 = f.canCross(array_a_2);
        check(expected_2, output_2);
        // Add your own test cases here

    }

    public static void main(String[] args) {
        new FrogJump().run();
    }
}
