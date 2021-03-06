package JavaFunctionalPractice.chap4;

public class Rectangle {
    private int x;
    private int y;
    private int height;
    private int width;

    public Rectangle(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public Rectangle scale(double percent) {
        height = (int) (height * (1.0 + percent));
        width = (int) (width * (1.0 + percent));
        return this;
    }

    public int getArea() {
        return height*width;
    }

    public String toString() {
        return "X: " + x + " Y: " + y
                + " Height: " + height + " Width: " + width;
    }
}