package leetcode.hard.arrays;

public class MaxPoints {
    public int maxPoints(int[][] points) {
        return 0;
    }

    public static void main(String[] args) {
        int row=2;
        int col=3;
        int [][] points = new int[row][col];

        points[0][0] = 1;
        points[0][1] = 2;
        points[0][2] = 3;

        points[1][0] = 1;
        points[1][1] = 2;
        points[1][2] = 3;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print("("+points[i][j]+ ","+points[j][i]+")");
            }
            System.out.println();
        }

       // [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//        int row=2;
//        int col=3;
    }
}
