package main.Contrll;

import main.Model.PointToDraw;
import org.w3c.dom.css.RGBColor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class BitmapReader {

    private FileInputStream bmpFilePath;
    private ArrayList<PointToDraw> points = new ArrayList<>();
    private BufferedImage image = null;
    private boolean filter = false;
    private int width = 0;
    private int height = 0;
    private int dRow[] = {-1,-1,-1,0,0,1,1,1};
    private int dCol[] = {-1,0,1,-1,1,-1,0,1};
    public static int[][] grid;
    public BitmapReader(FileInputStream bmpFilePath) {
        this.bmpFilePath = bmpFilePath;
    }
    public void readBmpFile() throws IOException {
        image = ImageIO.read(bmpFilePath);
        width = image.getWidth();
        height = image.getHeight();
        boolean[][] visited = new boolean[width][height];
        grid = new int[width][height];
        for(int i=0;i<image.getWidth();i++){
            for(int j=0;j<image.getHeight();j++){
                int color = image.getRGB(i,j);
                if(color == Color.BLACK.getRGB()){
                    grid[i][j]=1;
                }else{
                    grid[i][j]=0;
                }
            }
        }
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    points.add(new PointToDraw(i,j,1));
                    DFS(grid,i,j,visited);
                }
            }
        }
    }

    private Boolean isValid(int grid[][], boolean visited[][],int row, int col){
        return (row >= 0) && (row < width) && (col >= 0) && (col < height) && (grid[row][col] == 1 && !visited[row][col]);
    }

    private void DFS(int grid[][], int row,int col, boolean visited[][]){
        visited[row][col] = true;
        for(int i=0;i<8;i++){
            if(isValid(grid,visited,row+dRow[i],col+dCol[i])){
                points.add(new PointToDraw(row+dRow[i],col+dCol[i],1));
                System.out.println((row+dRow[i])+" "+(col+dCol[i]));
                DFS(grid,row+dRow[i],col+dCol[i],visited);
            }
        }
    }

    public void filterPoints2(){
        PointToDraw pointOrigin = points.get(0);
        PointToDraw point2 = points.get(1);
        ArrayList<ArrayList<PointToDraw>> lines = new ArrayList<ArrayList<PointToDraw>>();
        Iterator<PointToDraw> pointToDrawIterator = points.subList(2,points.size()-1).iterator();
        ArrayList<PointToDraw> line = new ArrayList<>();
        while(pointToDrawIterator.hasNext()){
            PointToDraw point3 = pointToDrawIterator.next();
            if(pointOrigin.getRow()-point2.getRow() == point2.getRow() - point3.getRow() && pointOrigin.getCol()-point2.getCol() == point2.getCol() - point3.getCol()){
                line.add(pointOrigin);
                line.add(point2);
                line.add(point3);
                pointOrigin = point2;
                point2 = point3;
            }else{
                lines.add(line);
                line = new ArrayList<PointToDraw>();
                pointOrigin = point2;
                point2 = point3;
            }
        }

        ArrayList<PointToDraw> finalPoints = new ArrayList<>();
        for(ArrayList<PointToDraw> pointLine:lines) {
            if (!pointLine.isEmpty()) {
                finalPoints.add(pointLine.get(0));
                finalPoints.add(pointLine.get(pointLine.size() - 1));
            }
        }
        points.clear();
        points.addAll(finalPoints);
    }

    public void commandBuilder() throws IOException {
        Path writeFile = Path.of("src/commandFile");
        StringBuilder stringBuilder = new StringBuilder();
        boolean first = true;
        boolean speed = true;
        for(PointToDraw point:points) {
            if (first) {
                stringBuilder.append("G00").append(" ").append("X" + point.getRow()).append(" ").append("Y" + point.getCol()).append('\n');
                first = false;
            } else {
                if(speed){
                    stringBuilder.append("G01").append(" ").append("X" + point.getRow()).append(" ").append("Y" + point.getCol()).append(" F"+200).append('\n');
                    speed=false;
                }
                else {
                    stringBuilder.append("G01").append(" ").append("X" + point.getRow()).append(" ").append("Y" + point.getCol()).append('\n');
                }
            }
        }
        stringBuilder.append("G01").append(" ").append("X" + points.get(0).getRow()).append(" ").append("Y" + points.get(0).getCol()).append('\n');
        Files.writeString(writeFile,stringBuilder.toString());
    }
}
