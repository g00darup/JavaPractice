package GrokkingCodingInterview.dynamicprogpatrn.DnC;

public class PascalTriangle {

    public static int[] pascalTriangleRecursive(int lineNumber) {

        int currentLineSize = lineNumber;
        int previousLineSize = currentLineSize - 1;
        int[] currentLine = new int[currentLineSize]; // Create container for current line values.

        if (lineNumber == 1) {

            currentLine[0] = 1;
            System.out.println(1);
            return currentLine;
        }
        else {


            int[] previousLine = pascalTriangleRecursive(lineNumber - 1); // We'll calculate current line based on previous one.

            // Let's go through all elements of current line except the first and last one (since they were and will be filled with 1's) and calculate current coefficient based on previous line.
            for (int numIndex = 0; numIndex < currentLineSize; numIndex++) {

                int leftCoefficient = (numIndex - 1) >= 0 ? previousLine[numIndex - 1] : 0;
                int rightCoefficient = numIndex < previousLineSize ? previousLine[numIndex] : 0;
                currentLine[numIndex] = leftCoefficient + rightCoefficient;
                System.out.print(leftCoefficient + rightCoefficient + " ");
            }
            System.out.println();
            return currentLine;
        }
    }
    public static void main(String args[]) {

        int n = 5; // play around with this number to see how the triangle grows
        pascalTriangleRecursive(n);
    }
}
