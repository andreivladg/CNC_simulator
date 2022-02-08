package main.View;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import main.Model.Circle;
import main.Model.Square;

public class CircleSet extends Pane {
    private TextField radius = new TextField();
    private TextField centerX = new TextField();
    private TextField centerY = new TextField();
    private Button ready = new Button();
    private Circle circle;

    public CircleSet(){
        this.radius.setPrefSize(100,18);
        this.centerX.setPrefSize(100,18);
        this.centerY.setPrefSize(100,18);

        this.radius.setLayoutY(20);
        this.radius.setLayoutX(20);
        this.radius.setPromptText("Radius:");

        this.centerX.setLayoutY(50);
        this.centerX.setLayoutX(20);
        this.centerX.setPromptText("CenterX:");

        this.centerY.setLayoutY(80);
        this.centerY.setLayoutX(20);
        this.centerY.setPromptText("CenterY:");

        this.ready.setLayoutX(70);
        this.ready.setLayoutY(150);
        this.ready.setText("Ready");
        this.ready.setFont(Font.font("Times New Roman",14));
        this.ready.setStyle("-fx-base: cyan;");

        this.getChildren().addAll(radius,centerX,centerY,ready);

    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public TextField getRadius() {
        return radius;
    }

    public TextField getCenterX() {
        return centerX;
    }

    public TextField getCenterY() {
        return centerY;
    }

    public Button getReady() {
        return ready;
    }
}
