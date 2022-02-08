package main.Contrll;

import javafx.scene.shape.*;
import javafx.util.Pair;
import main.Model.Command;
import main.Model.PointToDraw;
import main.View.Cell;

import java.awt.*;
import java.awt.geom.PathIterator;
import java.util.ArrayList;

public class PathCreator {
    private ArrayList<Command> commands = new ArrayList<>();
    private int[][] grid;
    private boolean keep_drawing;
    private double angle;
    public PathCreator(ArrayList<Command> commands,int[][] grid) {
        this.commands = commands;
        this.grid = grid;
        this.keep_drawing=true;
        this.angle=0;
    }

    public ArcTo drawArc(Command commPrev,Command commCurr){
        ArcTo arcto = new ArcTo();
        arcto.setX(commCurr.getxCoord());
        arcto.setY(commCurr.getyCoord());
        arcto.setRadiusX(commCurr.getxCoord()-commPrev.getxCoord());
        arcto.setRadiusY(commCurr.getyCoord()-commPrev.getyCoord());
        arcto.setSweepFlag(true);
        arcto.setLargeArcFlag(false);
        return arcto;
    }

    public LineTo drawLine(Command command){
        LineTo lineTo = new LineTo();
        lineTo.setX(command.getxCoord());
        lineTo.setY(command.getyCoord());

        return lineTo;
    }
    public double computeRadius(double x1,double y1, double x2,double y2){
        double radius = 0;
        double distance = Math.sqrt(Math.pow(x1-x2,2)+(Math.pow(y1-y2,2)));
        radius = distance/Math.sqrt(2);
        return radius;
    }

    public double computeDistance(double x1,double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x1-x2,2)+(Math.pow(y1-y2,2)));
    }

    public double compute_angle(int radius, double x1, double y1, double x2, double y2){
        double angle = 2* Math.asin(0.5*computeDistance(x1,y1,x2,y2)/radius);
        return angle;
    }

    public Path Bresenham(int radius, int centerX, int centerY){
        Path path = new Path();
        int y = radius;
        int x = 0;
        double d=3-2*radius;
        //this.angle = compute_angle(radius,xStart,yStart,xEnd,yEnd);
        //System.out.println(angle);
        path.getElements().addAll(drawCircle(centerX,centerY,x,y).getElements());
        while(y >= x){
            if(d<0){
                d= d + 4*x + 6;
            }else{
                y--;
                d= d + 4*(x-y) +10;
            }
            x++;
            path.getElements().addAll(drawCircle(centerX,centerY,x,y).getElements());
        }
        return path;
    }

    public Path drawCircle(int centerX,int centerY, int x, int y){
        Path path = new Path();

            MoveTo move1 = new MoveTo(centerX + x, centerY + y);
            LineTo line1 = new LineTo(centerX + x, centerY + y);
            path.getElements().addAll(move1, line1);


            MoveTo move2 = new MoveTo(centerX - x, centerY + y);
            LineTo line2 = new LineTo(centerX - x, centerY + y);
            path.getElements().addAll(move2, line2);


            MoveTo move3 = new MoveTo(centerX + x, centerY - y);
            LineTo line3 = new LineTo(centerX + x, centerY - y);
            path.getElements().addAll(move3, line3);


            MoveTo move4 = new MoveTo(centerX - x, centerY - y);
            LineTo line4 = new LineTo(centerX - x, centerY - y);
            path.getElements().addAll(move4, line4);


            MoveTo move5 = new MoveTo(centerX + y, centerY + x);
            LineTo line5 = new LineTo(centerX + y, centerY + x);
            path.getElements().addAll(move5, line5);


            MoveTo move6 = new MoveTo(centerX - y, centerY + x);
            LineTo line6 = new LineTo(centerX - y, centerY + x);
            path.getElements().addAll(move6, line6);


            MoveTo move7 = new MoveTo(centerX + y, centerY - x);
            LineTo line7 = new LineTo(centerX + y, centerY - x);
            path.getElements().addAll(move7, line7);


            MoveTo move8 = new MoveTo(centerX - y, centerY - x);
            LineTo line8 = new LineTo(centerX - y, centerY - x);
            path.getElements().addAll(move8, line8);


        return path;
    }
}
