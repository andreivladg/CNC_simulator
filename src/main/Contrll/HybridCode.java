package main.Contrll;

import main.Model.Hybrid;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class HybridCode {
   private Hybrid hybrid;

    public HybridCode(Hybrid hybrid) {
        this.hybrid=hybrid;
    }

    public void generateCode() throws IOException{
        Path writeFile = Path.of("src/hybridFile");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("G00").append(" ").append("X"+hybrid.getStartX()).append(" ").append("Y"+hybrid.getStartY()).append('\n');
        stringBuilder.append("G01").append(" ").append("X" + hybrid.getStartX()).append(" ").append("Y" + hybrid.getStartY()).append(" F"+200).append('\n');
        stringBuilder.append("G01").append(" ").append("X" + hybrid.getToX1()).append(" ").append("Y" + hybrid.getToY1()).append('\n');
        stringBuilder.append("G02").append(" ").append("X" + hybrid.getToX2()).append(" ").append("Y"+hybrid.getToY2()).append(" ").append("I"+(-hybrid.getRadius())).append(" ").append("J"+(-70)).append("\n");
        stringBuilder.append("G01").append(" ").append("X" + hybrid.getToX3()).append(" ").append("Y" + hybrid.getToY3()).append('\n');
        stringBuilder.append("G01").append(" ").append("X" + hybrid.getToX4()).append(" ").append("Y" + hybrid.getToY4()).append('\n');
        stringBuilder.append("G01").append(" ").append("X" + hybrid.getToX5()).append(" ").append("Y" + hybrid.getToY5()).append('\n');
        stringBuilder.append("G03").append(" ").append("X" + hybrid.getToX6()).append(" ").append("Y"+hybrid.getToY6()).append(" ").append("I"+(-hybrid.getRadius())).append(" ").append("J"+(-70)).append("\n");
        stringBuilder.append("G01").append(" ").append("X" + hybrid.getToX7()).append(" ").append("Y" + hybrid.getToY7()).append('\n');
        stringBuilder.append("G01").append(" ").append("X" + hybrid.getStartX()).append(" ").append("Y" + hybrid.getStartY()).append('\n');
        stringBuilder.append("M00").append(" ").append("X"+01).append(" ").append("Y"+01);
        Files.writeString(writeFile,stringBuilder.toString());
    }
}
