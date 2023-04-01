package Skienna;

public class Minesweeper {
    public static int [][]  countStars(int[][] arr,char[][] lookUp,int xpos,int ypos,int xLen,int yLen){
        System.out.println("hello");
      //count along same axis
        if(xpos-1 >=0 && lookUp[xpos-1][ypos]=='*') {
                arr[xpos][ypos]+=1;
        }if(xpos+1 <= xLen && lookUp[xpos+1][ypos]=='*') {
                arr[xpos][ypos]+=1;
        }
        //count 1-row above
        if(xpos-1 >=0 && lookUp[xpos-1][ypos]=='*') {
            arr[xpos][ypos]+=1;
        }if(xpos-1 >= 0 && ypos-1 >=0 &&  lookUp[xpos-1][ypos-1]=='*') {
            arr[xpos][ypos]+=1;
        }if(xpos-1 >= 0 && ypos+1 <=yLen &&  lookUp[xpos-1][ypos+1]=='*') {
            arr[xpos][ypos]+=1;
        }
        //count 1-row below
        if(xpos+1 >=0 && lookUp[xpos+1][ypos]=='*') {
            arr[xpos][ypos]+=1;
        }if(xpos+1 <= xLen && ypos-1 >=0 &&  lookUp[xpos+1][ypos-1]=='*') {
            arr[xpos][ypos]+=1;
        }if(xpos+1 <= xLen && ypos+1 <=yLen &&  lookUp[xpos+1][ypos+1]=='*') {
            arr[xpos][ypos]+=1;
        }

        return arr;
    }

    public static void main(String[] args) {
        int rows =4;
        int cols=4;
        char[][]  lookUp= new char[rows][cols];
        lookUp[0][0] = '*';
        lookUp[0][1] = '.';
        lookUp[0][2] = '.';
        lookUp[0][3] = '.';

        lookUp[1][0] = '.';
        lookUp[1][1] = '.';
        lookUp[1][2] = '.';
        lookUp[1][3] = '.';

        lookUp[2][0] = '.';
        lookUp[2][1] = '*';
        lookUp[2][2] = '.';
        lookUp[2][3] = '.';

        lookUp[3][0] = '.';
        lookUp[3][1] = '.';
        lookUp[3][2] = '.';
        lookUp[3][3] = '.';

        int[][] result = new int[4][4];

        result = countStarsFulll(result,lookUp,rows,cols);

        for(int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                System.out.println(result[i][j]);
            }
        }
    }

    private static int[][] countStarsFulll(int[][] result, char[][] lookUp, int rows, int cols) {
        for(int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if(lookUp[i][j]=='*') {
                    result[i][j] = -99;
                }else {
                    countStars(result, lookUp, i, j, rows, cols);
                }
            }
        }
        System.out.println("hello");
        return result;
    }
}
