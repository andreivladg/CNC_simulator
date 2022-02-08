package main.View;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import main.Model.Hybrid;

public class HybridSet extends Pane {

    private TextField startX = new TextField();
    private TextField startY = new TextField();
    private TextField toX1 = new TextField();
    private TextField toY1 = new TextField();
    private TextField toX2 = new TextField();
    private TextField toY2 = new TextField();
    private TextField toX3 = new TextField();
    private TextField toY3 = new TextField();
    private TextField toX4 = new TextField();
    private TextField toY4 = new TextField();
    private TextField toX5 = new TextField();
    private TextField toY5 = new TextField();
    private TextField toX6 = new TextField();
    private TextField toY6 = new TextField();
    private TextField toX7 = new TextField();
    private TextField toY7 = new TextField();
    private TextField radius = new TextField();
    private Button ready = new Button("Ready");
    private Hybrid hybrid;

    public HybridSet() {
        this.startX.setPrefSize(50,18);
        this.startY.setPrefSize(50,18);
        this.toX1.setPrefSize(40,18);
        this.toY1.setPrefSize(40,18);
        this.toX2.setPrefSize(40,18);
        this.toY2.setPrefSize(40,18);
        this.toX3.setPrefSize(40,18);
        this.toY3.setPrefSize(40,18);
        this.toX4.setPrefSize(40,18);
        this.toY4.setPrefSize(40,18);
        this.toX5.setPrefSize(40,18);
        this.toY5.setPrefSize(40,18);
        this.toX6.setPrefSize(40,18);
        this.toY6.setPrefSize(40,18);
        this.toX7.setPrefSize(40,18);
        this.toY7.setPrefSize(40,18);

        this.startX.setPromptText("startX:");
        this.startY.setPromptText("startY:");

        this.toX1.setPromptText("to x1:");
        this.toY1.setPromptText("to y1:");

        this.toX2.setPromptText("to x2:");
        this.toY2.setPromptText("to y2:");

        this.toX3.setPromptText("to x3:");
        this.toY3.setPromptText("to y3:");

        this.toX4.setPromptText("to x4:");
        this.toY4.setPromptText("to y4:");

        this.toX5.setPromptText("to x5:");
        this.toY5.setPromptText("to y5:");

        this.toX6.setPromptText("to x6:");
        this.toY6.setPromptText("to y6:");

        this.toX7.setPromptText("to x7:");
        this.toY7.setPromptText("to y7:");

        this.ready.setLayoutX(70);
        this.ready.setLayoutY(350);
        this.ready.setText("Ready");
        this.ready.setFont(Font.font("Times New Roman",14));
        this.ready.setStyle("-fx-base: cyan;");

        this.startX.setLayoutX(20);
        this.startX.setLayoutY(20);
        this.startY.setLayoutX(70);
        this.startY.setLayoutY(20);

        this.toX1.setLayoutX(20);
        this.toX1.setLayoutY(50);
        this.toY1.setLayoutX(70);
        this.toY1.setLayoutY(50);

        this.toX2.setLayoutX(20);
        this.toX2.setLayoutY(80);
        this.toY2.setLayoutX(70);
        this.toY2.setLayoutY(80);

        this.toX3.setLayoutX(20);
        this.toX3.setLayoutY(110);
        this.toY3.setLayoutX(70);
        this.toY3.setLayoutY(110);

        this.toX4.setLayoutX(20);
        this.toX4.setLayoutY(140);
        this.toY4.setLayoutX(70);
        this.toY4.setLayoutY(140);

        this.toX5.setLayoutX(20);
        this.toX5.setLayoutY(170);
        this.toY5.setLayoutX(70);
        this.toY5.setLayoutY(170);

        this.toX6.setLayoutX(20);
        this.toX6.setLayoutY(200);
        this.toY6.setLayoutX(70);
        this.toY6.setLayoutY(200);

        this.toX7.setLayoutX(20);
        this.toX7.setLayoutY(230);
        this.toY7.setLayoutX(70);
        this.toY7.setLayoutY(230);

        this.radius.setPrefSize(60,18);
        this.radius.setPromptText("radius:");
        this.radius.setLayoutX(70);
        this.radius.setLayoutY(280);

        this.getChildren().addAll(ready,startX,startY,toX1,toY1,toX2,toY2,toX3,toY3,toX4,toY4,toX5,toY5,toX6,toY6,toX7,toY7,radius);
    }

    public TextField getStartX() {
        return startX;
    }

    public TextField getStartY() {
        return startY;
    }

    public TextField getToX1() {
        return toX1;
    }

    public TextField getToY1() {
        return toY1;
    }

    public TextField getToX2() {
        return toX2;
    }

    public TextField getToY2() {
        return toY2;
    }

    public TextField getToX3() {
        return toX3;
    }

    public TextField getToY3() {
        return toY3;
    }

    public TextField getToX4() {
        return toX4;
    }

    public TextField getToY4() {
        return toY4;
    }

    public TextField getToX5() {
        return toX5;
    }

    public TextField getToY5() {
        return toY5;
    }

    public TextField getToX6() {
        return toX6;
    }

    public TextField getToY6() {
        return toY6;
    }

    public TextField getToX7() {
        return toX7;
    }

    public TextField getToY7() {
        return toY7;
    }

    public Button getReady() {
        return ready;
    }

    public TextField getRadius() {
        return radius;
    }

    public Hybrid getHybrid() {
        return hybrid;
    }

    public void setHybrid(Hybrid hybrid) {
        this.hybrid = hybrid;
    }
}
