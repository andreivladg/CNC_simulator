package main.Model;

public class Hybrid {
    private int startX,startY;
    private int toX1,toY1;
    private int toX2,toY2;
    private int toX3,toY3;
    private int toX4,toY4;
    private int toX5,toY5;
    private int toX6,toY6;
    private int toX7,toY7;
    private int radius;

    public Hybrid(int startX, int startY, int toX1, int toY1, int toX2, int toY2, int toX3, int toY3, int toX4, int toY4, int toX5, int toY5, int toX6, int toY6, int toX7, int toY7,int radius) {
        this.startX = startX;
        this.startY = startY;
        this.toX1 = toX1;
        this.toY1 = toY1;
        this.toX2 = toX2;
        this.toY2 = toY2;
        this.toX3 = toX3;
        this.toY3 = toY3;
        this.toX4 = toX4;
        this.toY4 = toY4;
        this.toX5 = toX5;
        this.toY5 = toY5;
        this.toX6 = toX6;
        this.toY6 = toY6;
        this.toX7 = toX7;
        this.toY7 = toY7;
        this.radius = radius;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getToX1() {
        return toX1;
    }

    public int getToY1() {
        return toY1;
    }

    public int getToX2() {
        return toX2;
    }

    public int getToY2() {
        return toY2;
    }

    public int getToX3() {
        return toX3;
    }

    public int getToY3() {
        return toY3;
    }

    public int getToX4() {
        return toX4;
    }

    public int getToY4() {
        return toY4;
    }

    public int getToX5() {
        return toX5;
    }

    public int getToY5() {
        return toY5;
    }

    public int getToX6() {
        return toX6;
    }

    public int getToY6() {
        return toY6;
    }

    public int getToX7() {
        return toX7;
    }

    public int getToY7() {
        return toY7;
    }

    public int getRadius() {
        return radius;
    }
}
