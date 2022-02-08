package main.Contrll;

import main.Model.Square;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SquareCode {
    private Square square;

    public SquareCode(Square square) {
        this.square = square;
    }

    public void generateCode() throws IOException {
        Path writeFile = Path.of("src/squareFile");
        StringBuilder stringBuilder = new StringBuilder();
        int startX = square.getX1();
        int startY = square.getY1();
        stringBuilder.append("G00").append(" ").append("X" + startX).append(" ").append("Y" + startY).append('\n');
        stringBuilder.append("G01").append(" ").append("X" + square.getX2()).append(" ").append("Y"+square.getY2()).append(" ").append("F"+200).append("\n");
        stringBuilder.append("G01").append(" ").append("X" + square.getX3()).append(" ").append("Y"+square.getY3()).append("\n");
        stringBuilder.append("G01").append(" ").append("X" + square.getX4()).append(" ").append("Y"+square.getY4()).append("\n");
        stringBuilder.append("G01").append(" ").append("X" + startX).append(" ").append("Y"+startY).append("\n");
        stringBuilder.append("M00").append(" ").append("X"+01).append(" ").append("Y"+01);
        Files.writeString(writeFile,stringBuilder.toString());
    }
}
