package main.View;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Cell extends Rectangle {
    private int row;
    private int col;
    private int width;
    private int height;
    boolean paint = false;
    public Cell(int x, int y,int width, int height){
        setWidth(width);
        setHeight(height);
        relocate(x,y);
        setStroke(Paint.valueOf("black"));
    }

    public void paintCell(){
        setFill(Color.rgb(250,67,161));
        paint = true;
    }

    public void unPaintCell(){
        setFill(Color.rgb(250,250,250));
        paint = false;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
