package main.Contrll;

import main.Model.Circle;
import main.Model.Command;
import main.Model.PointToDraw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class CircleCode {
    private Circle circle;

    public CircleCode(Circle circle) {
        this.circle = circle;
    }

    public void generateCode() throws IOException {
        Path writeFile = Path.of("src/circleFile");
        StringBuilder stringBuilder = new StringBuilder();
        int startX = circle.getCenterX() - circle.getRadius();
        int startY = circle.getCenterY();
        stringBuilder.append("G00").append(" ").append("X" + startX).append(" ").append("Y" + startY).append('\n');
        stringBuilder.append("G01").append(" ").append("X" + startX).append(" ").append("Y" + startY).append(" F"+200).append('\n');
        stringBuilder.append("G02").append(" ").append("X" + startX).append(" ").append("Y"+startY).append(" ").append("R"+circle.getRadius()).append("\n");
        stringBuilder.append("M00").append(" ").append("X"+01).append(" ").append("Y"+01);
        Files.writeString(writeFile,stringBuilder.toString());
    }
}
