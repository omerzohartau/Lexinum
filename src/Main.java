import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    final static String FILENAME = "gamefile.txt";

    public static void main(String[] args) throws IOException {
        gameLoop();
    }
    private static void gameLoop() throws IOException {
        List<Participant> participants = new ArrayList<Participant>();
        String input = "";
        Riddle riddle = loadGame(FILENAME, participants);
        Scanner sc = new Scanner(System.in);
        //now start interacting with user
        while(input != "exit"){
            System.out.print("Enter your input:");
            input = sc.nextLine();
            if(input.equals("exit"))
                break;
            else if(input.equals("new")){
                System.out.print("Which list will it be?");
                input = sc.nextLine();
                switch(input){
                    case "1": riddle = new Riddle1();break;
                    case "2": riddle = new Riddle2();break;
                    case "3": riddle = new Riddle3();break;
                    default:break;
                }
                getCodes(sc, participants);
            }
            else if(input.equals("save")){
                saveGame(FILENAME, participants, riddle);
            }
            else if(input.equals("load")){
                riddle = loadGame(FILENAME, participants);
            }
            else if(input.equals("add")){
                addPlayer(sc, participants);
            }
            else if(input.equals("kick")){
                kickPlayer(sc, participants);
            }
            else if(input.equals("show")){
                for(Participant p: participants){
                    show(p);
                }
            }
            else if(input.equals("showsol")){
                for(Participant p: participants){
                    showSolution(riddle, p);
                }
            }
            else if(input.equals("showp")){
                playersList(participants);
            }
            else{
                System.out.println("Bad input. try again.");
            }
        }
        sc.close();
    }
    static void playersList(List<Participant> participantList){
        for (Participant p: participantList){
            System.out.println("ID: " + p.getID());
            System.out.println("Name: " + p.getName() + System.lineSeparator());
        }
    }
    static void kickPlayer(Scanner sc, List<Participant> participantList){
        System.out.print("Enter player name:");
        String name = sc.nextLine();
        Participant toRemove;
        for(Participant p: participantList){
            if(p.getName().equals(name)){
                toRemove = p;
                participantList.remove(toRemove);
                return;
            }
        }
        System.out.println("No such name exists.");
    }
    static void show(Participant participant){
        int ID = participant.getID();
        int code = participant.getCurrentCode();
        String name = participant.getName();
        System.out.println("Player ID: " + ID);
        System.out.println("Player name: " + name);
        System.out.println("Player code: " +code);
    }
    static void showSolution(Riddle riddle, Participant participant){
        int ID = participant.getID();
        int code = participant.getCurrentCode();
        String name = participant.getName();
        System.out.println("Player ID: " + ID);
        System.out.println("Player name: " + name);
        System.out.println("Player code: " +code);
        System.out.println("Solution: " + riddle.translateNumToSentence(code));
    }
    static Riddle loadGame(String filename, List<Participant> participants) throws IOException {
        participants.clear();
        Riddle riddle;
        File file = new File(filename);
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String line;
        String[] lineAfterSeparation;
        line = reader.readLine();
        switch (line){
            case "1": riddle = new Riddle1();break;
            case "2": riddle = new Riddle2();break;
            case "3": riddle = new Riddle3();break;
            default: riddle = null;break;
        }
        while((line = reader.readLine()) != null){
            lineAfterSeparation = line.split(",");
            Participant p = new Participant(Integer.parseInt(lineAfterSeparation[0]), Integer.parseInt(lineAfterSeparation[2]), lineAfterSeparation[1]);
            p.setCurrentCode(Integer.parseInt(lineAfterSeparation[3]));
            participants.add(p);
        }
        return riddle;
    }
    static void addPlayer(Scanner sc, List<Participant> participantsList){
        String name;
        int number;
        System.out.print("Enter name:");
        name = sc.nextLine();
        System.out.print("Enter number:");
        number = sc.nextInt();
        String index = participantsList.size() + "";
        participantsList.add(new Participant(index, number, name));
    }
    static void saveGame(String filename, List<Participant> participantList, Riddle riddle) throws IOException {
        File file = new File(filename);
        FileWriter fw = new FileWriter(file);
        String toWrite = "";
        if (riddle instanceof Riddle1) {
            toWrite += "1" + System.lineSeparator();
        }
        else if(riddle instanceof Riddle2){
            toWrite += "2" + System.lineSeparator();
        }
        else if(riddle instanceof Riddle3){
            toWrite += "3" + System.lineSeparator();
        }
        for(Participant p : participantList){
            toWrite += p.getID() + "," + p.getName() + "," + p.getNumber() + "," + p.getCurrentCode() + System.lineSeparator();
        }
        fw.write(toWrite);
        fw.close();
    }
    static void getCodes(Scanner scanner, List<Participant> participants){
        int r1, r2;
        int[] codes;
        Participant current;
        System.out.print("Enter lowest code possible:");
        r1 = scanner.nextInt();
        System.out.print("Enter highest code possible:");
        r2 = scanner.nextInt();
        codes = Riddle.getNumbers(r1, r2, participants.size());
        for(int i = 0; i < codes.length; i++){
            current = participants.get(i);
            current.setCurrentCode(codes[i]);
            System.out.println("Participant " + current.getName() + " with number " + current.getNumber() + " got the code: " + codes[i]);
        }
    }
}
