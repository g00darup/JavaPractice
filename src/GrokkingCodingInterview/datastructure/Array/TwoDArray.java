package GrokkingCodingInterview.datastructure.Array;

class TwoDArray {
    public static void main( String args[] ) {

        int rows =0;
        int columns =0;

        int [][] my2DArray;
        my2DArray = new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};

        System.out.println("You have successfully created a 2DArray");

        rows = my2DArray.length;
        columns = my2DArray[rows-1].length;

        System.out.println(rows);
        System.out.println(columns);

        for(int i =0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.print(my2DArray[i][j]+",");
            }
            System.out.println(" ");
        }

        boolean[] markedForDel = new boolean[5];

        for (boolean b : markedForDel) {
            System.out.println(b);

        }

    }
}