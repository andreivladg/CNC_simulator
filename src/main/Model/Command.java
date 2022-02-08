package main.Model;

public class Command {
    private String command;
    private char type;
    private int commandNumber;
    private double xCoord;
    private double yCoord;
    private double zCoord=1.000;
    private double speed;
    private double xOffset;
    private double yOffset;
    private double radius;

    public Command(char type,String command, int commandNumber, double xCoord, double yCoord, double speed) {
        this.type=type;
        this.command = command;
        this.commandNumber = commandNumber;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.speed = speed;
    }

    public Command(char type,String command, int commandNumber, double xCoord, double yCoord, double zCoord, double xOffset, double yOffset) {
        this.type=type;
        this.command = command;
        this.commandNumber = commandNumber;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.zCoord = zCoord;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public Command(char type,String command, int commandNumber, double xCoord, double yCoord, double zCoord,double radius) {
        this.type=type;
        this.command = command;
        this.commandNumber = commandNumber;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.zCoord = zCoord;
        this.radius = radius;
    }

    public Command(){
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public Command(int commandNumber) {
        this.commandNumber = commandNumber;
    }

    public int getCommandNumber() {
        return commandNumber;
    }

    public void setCommandNumber(int commandNumber) {
        this.commandNumber = commandNumber;
    }

    public double getxCoord() {
        return xCoord;
    }

    public void setxCoord(double xCoord) {
        this.xCoord = xCoord;
    }

    public double getyCoord() {
        return yCoord;
    }

    public void setyCoord(double yCoord) {
        this.yCoord = yCoord;
    }

    public double getzCoord() {
        return zCoord;
    }

    public void setzCoord(double zCoord) {
        this.zCoord = zCoord;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getxOffset() {
        return xOffset;
    }

    public void setxOffset(double xOffset) {
        this.xOffset = xOffset;
    }

    public double getyOffset() {
        return yOffset;
    }

    public void setyOffset(double yOffset) {
        this.yOffset = yOffset;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
