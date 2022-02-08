package main.View;

import javafx.animation.Animation;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import main.Contrll.PathCreator;
import main.Model.Command;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public class CutScene extends Pane {

    private TextArea commands = new TextArea();
    private TextField speed = new TextField();
    private TextField time = new TextField();
    private DrawingBoard drawingBoard =new DrawingBoard();
    private ArrayList<Command> comms = new ArrayList<>();
    SubScene drawingScene;
    static int counter=0;
    public CutScene(){

        this.commands.setEditable(true);
        this.commands.setLayoutY(0);
        this.commands.setLayoutX(0);
        this.commands.setPrefSize(140,600);
        this.speed.setLayoutX(150);
        this.speed.setLayoutY(0);
        this.speed.setPrefSize(80,10);
        this.speed.setText("Rate:");
        this.time.setLayoutX(240);
        this.time.setLayoutY(0);
        this.time.setPrefSize(80,10);
    }

    public TextField getSpeed() {
        return speed;
    }

    public void draw() throws InterruptedException {
        drawingScene = new SubScene(drawingBoard,800,600);
        drawingScene.getRoot().setLayoutX(140);
        drawingScene.getRoot().setLayoutY(40);
        this.getChildren().add(drawingScene);
        drawingScene.setVisible(true);
        drawingBoard.setCommands(comms);
        drawingBoard.draw();
        double rate = drawingBoard.getTransition().getRate();
        speed.appendText(" "+rate + " ");
        this.getChildren().addAll(commands,speed,time);

    }
    public DrawingBoard getDrawingBoard() {
        return drawingBoard;
    }

    public void setDrawingBoard(DrawingBoard drawingBoard) {
        this.drawingBoard = drawingBoard;
    }

    public TextArea getCommands() {
        return commands;
    }

    public void setComms(ArrayList<Command> comms) {
        this.comms = comms;
    }

    public TextField getTime() {
        return time;
    }
}
