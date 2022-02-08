package main.View;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainScreen extends Parent {
    private Text title = new Text("CNC Application");
    private ComboBox<String> GcodeFiles = new ComboBox<>();
    private ComboBox<String> images = new ComboBox<>();
    private ComboBox<String> shapes = new ComboBox<>();
    private Button convert = new Button();
    private Button startCut = new Button();
    private Button exitApp = new Button();
    private Button generate = new Button();


    public MainScreen(){

        this.title.setFont((Font.font("Times New Roman",22)));
        this.title.setLayoutX(100);
        this.title.setLayoutY(40);

        this.GcodeFiles.setPromptText("Select File");
        this.GcodeFiles.setPrefSize(150,18);
        this.GcodeFiles.setLayoutY(90);
        this.GcodeFiles.setLayoutX(100);

        this.images.setPromptText("Select Image");
        this.images.setPrefSize(150,18);
        this.images.setLayoutY(140);
        this.images.setLayoutX(100);

        this.shapes.setPromptText("Choose Shape");
        this.shapes.setPrefSize(150,18);
        this.shapes.setLayoutY(190);
        this.shapes.setLayoutX(100);
        this.shapes.getItems().addAll("Circle","Square","Hybrid");

        this.startCut.setLayoutX(150);
        this.startCut.setLayoutY(240);
        this.startCut.setText("Start");
        this.startCut.setFont(Font.font("Times New Roman",14));
        this.startCut.setStyle("-fx-base: cyan;");

        this.convert.setLayoutX(140);
        this.convert.setLayoutY(290);
        this.convert.setText("Convert");
        this.convert.setFont(Font.font("Times New Roman",14));
        this.convert.setStyle("-fx-base: forestgreen;");

        this.generate.setLayoutY(340);
        this.generate.setLayoutX(140);
        this.generate.setText("Generate");
        this.generate.setFont(Font.font("Times New Roman",14));
        this.generate.setStyle("-fx-base: cyan;");

        this.exitApp.setLayoutX(150);
        this.exitApp.setLayoutY(390);
        this.exitApp.setText("Exit");


        this.exitApp.setFont(Font.font("Times New Roman",14));
        this.exitApp.setStyle("-fx-background-color: MediumSeaGreen");


        this.getChildren().addAll(title,GcodeFiles,startCut,exitApp,images,convert,shapes,generate);

    }

    public Button getExitApp() {
        return exitApp;
    }

    public Button getStartCut() {
        return startCut;
    }

    public ComboBox<String> getGcodeFiles() {
        return GcodeFiles;
    }

    public ComboBox<String> getImages() {
        return images;
    }

    public Button getConvert() {
        return convert;
    }

    public ComboBox<String> getShapes() {
        return shapes;
    }

    public Button getGenerate() {
        return generate;
    }
}
