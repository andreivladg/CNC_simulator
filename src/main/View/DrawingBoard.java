package main.View;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.util.Duration;
import main.Contrll.BitmapReader;
import main.Contrll.PathCreator;
import main.Model.Command;

import java.util.ArrayList;
import java.util.Collection;

//main scene for drawing

public class DrawingBoard extends Pane {
    private PathTransition transition;
    private ArrayList<Command> commands = new ArrayList<>();

    private int rows=80;
    private int cols=80;
    private double width=800;
    private double height=600;
    private Rectangle cutter = new Rectangle(width/rows, height/cols);
    private Grid gridScreen = new Grid(rows,cols,width,height);

    public DrawingBoard() {
        this.setPrefSize(570, 660);
        this.cutter.setFill(Paint.valueOf("black"));
        this.cutter.setOpacity(100);
        this.cutter.setSmooth(true);
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                Cell cell = new Cell(i,j,5,5);
                gridScreen.addCell(cell,i,j);
            }
        }
        gridScreen.unColor();

        this.getChildren().addAll(gridScreen,cutter);
    }

    public void draw() throws InterruptedException {
        PathCreator  pathCreator= new PathCreator(commands, BitmapReader.grid);
        Path path = new Path();
        ArcTo arcTo = new ArcTo();
        LineTo lineTo = new LineTo();
        path.setStroke(Color.BLUE);
        path.setStrokeWidth(2.0);
        transition = new PathTransition(Duration.seconds(3), path, cutter);
        for (Command command : commands) {
            if(command.getType()=='G' && command.getCommandNumber()==0){
                path.getElements().add(new MoveTo(command.getxCoord(), command.getyCoord()));
            }
            if(command.getType()=='M' && command.getCommandNumber()==0){
                transition.setCycleCount(1);
            }
            switch(command.getCommandNumber()){
                case 3:
                    Command comm3 = commands.get(commands.indexOf(command) - 1);
                    path.getElements().add(new MoveTo(comm3.getxCoord(), comm3.getyCoord()));
                    arcTo = pathCreator.drawArc(comm3,command);
                    arcTo.setSweepFlag(false);
                    path.getElements().add(arcTo);
                    break;
                case 2:
                    if(command.getRadius()!=0){
                        Command comm2 = commands.get(commands.indexOf(command) - 1);
                        path.getElements().add(new MoveTo(comm2.getxCoord(), comm2.getyCoord()));
                        path.getElements().addAll(pathCreator.Bresenham((int)command.getRadius(),(int)(command.getxCoord()+command.getRadius()),(int)command.getyCoord()).getElements());
                    }else{
                        Command comm2 = commands.get(commands.indexOf(command) - 1);
                        path.getElements().add(new MoveTo(comm2.getxCoord(), comm2.getyCoord()));
                        arcTo = pathCreator.drawArc(comm2,command);
                        path.getElements().add(arcTo);
                    }
                    break;
                case 1:
                    lineTo = pathCreator.drawLine(command);
                    path.getElements().add(lineTo);
                    break;
            }
        }

        this.getChildren().add(path);
        for(Command command:commands){
          if(command.getSpeed()!=0){
              transition.setRate(command.getSpeed()/800);
          }
        }
        transition.setRate(0.5);
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                Cell cell = gridScreen.getCell(i,j);
                if(((Path)Shape.intersect(transition.getPath(),cell)).getElements().size()>0){
                    if(!cell.paint) {
                        cell.paintCell();
                    }
                }
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                Cell cell = gridScreen.getCell(i,j);
                if(cell.paint){
                    Cell cellN = gridScreen.getCell(i,j-1);
                    Cell cellS = gridScreen.getCell(i,j+1);
                    Cell cellW = gridScreen.getCell(i-1,j);
                    Cell cellE = gridScreen.getCell(i+1,j);
                    if(cellN.paint && cellS.paint){
                        cellW.unPaintCell();
                        cellE.unPaintCell();
                    }
                    if(cellW.paint && cellE.paint){
                        cellN.unPaintCell();
                        cellS.unPaintCell();
                    }
                    if(cellW.paint && cellS.paint){
                        cellN.unPaintCell();
                        cellE.unPaintCell();
                    }
                    if(cellW.paint && cellN.paint){
                        cellE.unPaintCell();
                        cellS.unPaintCell();
                    }
                    if(cellE.paint && cellS.paint){
                        cellN.unPaintCell();
                        cellW.unPaintCell();
                    }
                    if(cellE.paint && cellN.paint){
                        cellW.unPaintCell();
                        cellS.unPaintCell();
                    }
                }
            }
        }
        transition.play();
    }

    public Shape getCutter() {
        return cutter;
    }

    public PathTransition getTransition() {
        return transition;
    }


    public void setCommands(ArrayList<Command> commands) {
        this.commands = commands;
    }

    public ArrayList<Command> getCommands() {
        return commands;
    }
}
