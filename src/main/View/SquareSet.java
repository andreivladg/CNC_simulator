package main.View;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import main.Model.Square;

public class SquareSet extends Pane {
    private TextField x1 = new TextField();
    private TextField y1 = new TextField();
    private TextField x2 = new TextField();
    private TextField y2 = new TextField();
    private TextField x3 = new TextField();
    private TextField y3 = new TextField();
    private TextField x4 = new TextField();
    private TextField y4 = new TextField();
    private Button ready = new Button();
    private Square square;
    public SquareSet(){
        this.x1.setPrefSize(40,18);
        this.y1.setPrefSize(40,18);
        this.x2.setPrefSize(40,18);
        this.y2.setPrefSize(40,18);
        this.x3.setPrefSize(40,18);
        this.y3.setPrefSize(40,18);
        this.x4.setPrefSize(40,18);
        this.y4.setPrefSize(40,18);

        this.x1.setLayoutY(20);
        this.x1.setLayoutX(20);
        this.y1.setLayoutY(20);
        this.y1.setLayoutX(80);
        this.x1.setPromptText("x1:");
        this.y1.setPromptText("y1:");

        this.x2.setLayoutY(50);
        this.x2.setLayoutX(20);
        this.y2.setLayoutY(50);
        this.y2.setLayoutX(80);
        this.x2.setPromptText("x2:");
        this.y2.setPromptText("y2:");

        this.x3.setLayoutY(80);
        this.x3.setLayoutX(20);
        this.y3.setLayoutY(80);
        this.y3.setLayoutX(80);
        this.x3.setPromptText("x3:");
        this.y3.setPromptText("y3:");

        this.x4.setLayoutY(110);
        this.x4.setLayoutX(20);
        this.y4.setLayoutY(110);
        this.y4.setLayoutX(80);
        this.x4.setPromptText("x4:");
        this.y4.setPromptText("y4:");

        this.ready.setText("Ready");
        this.ready.setFont(Font.font("Times New Roman",14));
        this.ready.setStyle("-fx-base: cyan;");
        this.ready.setLayoutX(70);
        this.ready.setLayoutY(140);

        this.getChildren().addAll(x1,y1,x2,y2,x3,y3,x4,y4,ready);
    }

    public TextField getX1() {
        return x1;
    }

    public TextField getY1() {
        return y1;
    }

    public TextField getX2() {
        return x2;
    }

    public TextField getY2() {
        return y2;
    }

    public TextField getX3() {
        return x3;
    }

    public TextField getY3() {
        return y3;
    }

    public TextField getX4() {
        return x4;
    }

    public TextField getY4() {
        return y4;
    }

    public Button getReady() {
        return ready;
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }
}
