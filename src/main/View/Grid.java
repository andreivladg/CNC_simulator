package main.View;

import javafx.scene.layout.Pane;

public class Grid extends Pane {
    private int rows;
    private int cols;
    private double gridWidth;
    private double gridHeight;
    private Cell[][] cells;

    public Grid(int rows, int cols, double gridWidth, double gridHeight) {
        this.rows = rows;
        this.cols = cols;
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.cells = new Cell[rows][cols];
    }

    public void addCell(Cell cell, int row, int col){
        cells[row][col] = cell;
        double w = gridWidth / cols;
        double h = gridHeight / rows;
        double x = w * col;
        double y = h * row;

        cell.setLayoutX(x);
        cell.setLayoutY(y);
        cell.setWidth(w);
        cell.setHeight(h);
        this.getChildren().add(cell);
    }

    public Cell getCell(int column, int row) {
        return cells[row][column];
    }

    public void unColor() {
        for( int row=0; row < rows; row++) {
            for( int col=0; col < cols; col++) {
                cells[row][col].unPaintCell();
            }
        }
    }
}
