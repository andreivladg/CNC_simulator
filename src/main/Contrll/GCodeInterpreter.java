package main.Contrll;
import main.Model.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GCodeInterpreter {

    private ArrayList<Command> commands = new ArrayList<>();
    private Float coordX, coordY;
    private InputStream file;

    public GCodeInterpreter(InputStream file) {
        this.file = file;
    }
    public GCodeInterpreter(){};

    public ArrayList<Command> readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                Command command = new Command();
                command.setCommand(line);
                commands.add(command);
            }
        }
        return commands;
    }

    public ArrayList<String> getCommands() {
        ArrayList<String> commandLines = new ArrayList<>();
        for (Command comm:commands){
            commandLines.add(comm.getCommand());
        }
        return commandLines;
    }

    public Command commandParser(String line){
        Command com = new Command();
        String[] comms = line.split(" ");
        double xCoord=0;
        double yCoord=0;
        double xCircleOffset = 0;
        double yCircleOffset = 0;
        double speed = 0;
        boolean oneSpeed = true;
        int commandNumber=0;
        double radius =0;
        char type ='\0';
        for(int i=0;i<comms.length;i++){
            String command = comms[i];
            char letter=command.charAt(0);
            String number = command.substring(1);
            switch(letter){
                case 'G': commandNumber = Integer.parseInt(number);
                          type = 'G';
                    break;
                case 'M': commandNumber = Integer.parseInt(number);
                          type = 'M';
                    break;
                case 'I': xCircleOffset = Double.parseDouble(number);
                    break;
                case 'J': yCircleOffset = Double.parseDouble(number);
                    break;
                case 'X': xCoord=Double.parseDouble(number);
                    break;
                case 'Y': yCoord=Double.parseDouble(number);
                    break;
                case 'F': speed = Double.parseDouble(number);
                    break;
                case 'R': radius = Double.parseDouble(number);
                    break;
            }
        }
        if (xCircleOffset != 0 || yCircleOffset !=0)
        {
            com = new Command(type,line,commandNumber,xCoord,yCoord,0,xCircleOffset,yCircleOffset);
        }else if(radius !=0){
            com = new Command(type,line,commandNumber,xCoord,yCoord,0,radius);
        }else{
            com = new Command(type,line,commandNumber,xCoord,yCoord,speed);
        }
        return com;
    }
}