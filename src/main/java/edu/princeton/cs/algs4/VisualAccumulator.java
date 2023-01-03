package main.java.edu.princeton.cs.algs4;

/******************************************************************************
 *  Compilation:  javac VisualAccumulator.java
 *  Execution:  none
 *  Dependencies: StdDraw.java
 *
 *  Visual accumulator mutable data type.
 *
 ******************************************************************************/


public class VisualAccumulator {
    private double total;
    private int n;

    public VisualAccumulator(int trials, double max) {
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(0.005);
    }

    public void addDataValue(double value) {
        n++;
        total += value;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(n, value);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(n, mean());
    }

    public double mean() {
        return total / n;
    }


    public String toString() {
        return "n = " + n + ", mean = " + mean();
    }

    public static void main(String[] args) {
        VisualAccumulator v = new VisualAccumulator(3,0.5);
        v.addDataValue(0.1);
    }
}
