package Homework.Chapter8.Ninth;

public class ninth {
    public static void main(String[] args) {
        LabeledPoint black = new LabeledPoint(1929, 230.07, "Black");
        black.showInf();
    }
}

class Point{
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    public void showInf(){
        System.out.println(x + "\t" + y);
    }
}
class LabeledPoint extends Point{
    private String mark;

    public LabeledPoint(double x, double y, String mark) {
        super(x, y);
        this.mark = mark;
    }
    @Override
    public void showInf(){
        System.out.print(mark + "\t");
        super.showInf();
    }
}
