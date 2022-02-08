package main;

import javafx.animation.Animation;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.View.*;
import main.Contrll.*;
import main.Model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;

public class Main extends Application {
    static int counter = 0;
    @Override
    public void start(Stage primaryStage) throws Exception {

        MainScreen mainScreen = new MainScreen();
        SquareSet squareScreen = new SquareSet();
        CircleSet circleScreen = new CircleSet();
        HybridSet hybridScreen = new HybridSet();
        Scene squareScene = new Scene(squareScreen,200,200);
        Scene circleScene = new Scene(circleScreen,200,200);
        Scene hybridScene = new Scene(hybridScreen,200,400);
        CutScene cutScreen = new CutScene();
        Scene mainScene = new Scene(mainScreen, 360, 420);
        Scene cutScene = new Scene(cutScreen, 800, 600);
        ArrayList<Command> commands = new ArrayList<>();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                counter++;
                cutScreen.getTime().setText("Time:"+counter);
            }
        };
        Timer timer = new Timer("Sim Timer");
        timer.scheduleAtFixedRate(timerTask,10,1000);


        File folder = new File("src");
        for(File file: Objects.requireNonNull(folder.listFiles())){
            mainScreen.getGcodeFiles().getItems().add(file.getPath());
        }

        String regex = "([^\\s]+(\\.(?i)(bmp))$)";
        Pattern p = Pattern.compile(regex);

        for(File file: Objects.requireNonNull(folder.listFiles())){
            if(p.matcher(file.getPath()).matches()){
                mainScreen.getImages().getItems().add(file.getPath());
            }
        }

        mainScreen.getConvert().setOnAction(actionEvent -> {
            BitmapReader bitmapReader = null;
            try {
                bitmapReader = new BitmapReader(new FileInputStream((mainScreen.getImages().getValue())));
                bitmapReader.readBmpFile();
                bitmapReader.filterPoints2();
                bitmapReader.commandBuilder();
                mainScreen.getGcodeFiles().getItems().add("src/commandFile");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        circleScreen.getReady().setOnAction(actionEvent -> {
            int radius = Integer.parseInt(circleScreen.getRadius().getText());
            int centerX = Integer.parseInt(circleScreen.getCenterX().getText());
            int centerY = Integer.parseInt(circleScreen.getCenterY().getText());
            circleScreen.setCircle(new Circle(radius,centerX,centerY));
            try {
                (new CircleCode(circleScreen.getCircle())).generateCode();
                mainScreen.getGcodeFiles().getItems().add("src/circleFile");
            } catch (IOException e) {
                e.printStackTrace();
            }
            primaryStage.setScene(mainScene);

        });

        squareScreen.getReady().setOnAction(actionEvent -> {
            int x1 = Integer.parseInt(squareScreen.getX1().getText());
            int y1 = Integer.parseInt(squareScreen.getY1().getText());
            int x2 = Integer.parseInt(squareScreen.getX2().getText());
            int y2 = Integer.parseInt(squareScreen.getY2().getText());
            int x3 = Integer.parseInt(squareScreen.getX3().getText());
            int y3 = Integer.parseInt(squareScreen.getY3().getText());
            int x4 = Integer.parseInt(squareScreen.getX4().getText());
            int y4 = Integer.parseInt(squareScreen.getY4().getText());
            squareScreen.setSquare(new Square(x1,y1,x2,y2,x3,y3,x4,y4));
            try {
                (new SquareCode(squareScreen.getSquare())).generateCode();
                mainScreen.getGcodeFiles().getItems().add("src/squareFile");
            } catch (IOException e) {
                e.printStackTrace();
            }
            primaryStage.setScene(mainScene);


        });

        hybridScreen.getReady().setOnAction(actionEvent -> {
            int startX = Integer.parseInt(hybridScreen.getStartX().getText());
            int startY = Integer.parseInt(hybridScreen.getStartY().getText());
            int toX1 = Integer.parseInt(hybridScreen.getToX1().getText());
            int toY1 = Integer.parseInt(hybridScreen.getToY1().getText());
            int toX2 = Integer.parseInt(hybridScreen.getToX2().getText());
            int toY2 = Integer.parseInt(hybridScreen.getToY2().getText());
            int toX3 = Integer.parseInt(hybridScreen.getToX3().getText());
            int toY3 = Integer.parseInt(hybridScreen.getToY3().getText());
            int toX4 = Integer.parseInt(hybridScreen.getToX4().getText());
            int toY4 = Integer.parseInt(hybridScreen.getToY4().getText());
            int toX5 = Integer.parseInt(hybridScreen.getToX5().getText());
            int toY5 = Integer.parseInt(hybridScreen.getToY5().getText());
            int toX6 = Integer.parseInt(hybridScreen.getToX6().getText());
            int toY6 = Integer.parseInt(hybridScreen.getToY6().getText());
            int toX7 = Integer.parseInt(hybridScreen.getToX7().getText());
            int toY7 = Integer.parseInt(hybridScreen.getToY7().getText());
            int radius = Integer.parseInt(hybridScreen.getRadius().getText());
            hybridScreen.setHybrid(new Hybrid(startX,startY,toX1,toY1,toX2,toY2,toX3,toY3,toX4,toY4,toX5,toY5,toX6,toY6,toX7,toY7,radius));
            try {
                (new HybridCode(hybridScreen.getHybrid())).generateCode();
                mainScreen.getGcodeFiles().getItems().add("src/hybridFile");
            } catch (IOException e) {
                e.printStackTrace();
            }
            primaryStage.setScene(mainScene);

        });

        mainScreen.getGenerate().setOnAction(actionEvent -> {
            String value = mainScreen.getShapes().getValue().toString();
            switch(value){
                case "Circle":
                    primaryStage.setScene(circleScene);
                    break;
                case "Square":
                    primaryStage.setScene(squareScene);
                    break;
                case "Hybrid":
                    primaryStage.setScene(hybridScene);
                    break;
            }
        });

        mainScreen.getStartCut().setOnAction(actionEvent -> {
            primaryStage.setScene(cutScene);
            try {
                GCodeInterpreter interpreter = new GCodeInterpreter(new FileInputStream(mainScreen.getGcodeFiles().getValue()));
                interpreter.readFromInputStream(new FileInputStream(mainScreen.getGcodeFiles().getValue()));
                for (String comm : interpreter.getCommands()) {
                    cutScreen.getCommands().appendText(comm + "\n");
                }
                for(String commandString : interpreter.getCommands()) {
                    Command command = interpreter.commandParser(commandString);
                    commands.add(command);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            cutScreen.setComms(commands);
            try {
                cutScreen.draw();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
