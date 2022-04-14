import java.util.Random;

public class Participant {
    final static int START = 10000;
    final static int INTERVAL = 5625;
    private int ID;
    private int number;
    private String name;
    private int currentCode;
    public Participant(int ID, int number, String name){
        this.ID = ID;
        this.number = number;
        this.name = name;
    }
    public Participant(String index, int number, String name){
        this(0, number, name);
        this.ID = rollID(Integer.parseInt(index));
    }
    private int rollID(int index){
        int id = 0;
        Random random = new Random();
        id = random.nextInt(INTERVAL) + INTERVAL * index + START;
        return id;
    }
    public int getID(){
        return this.ID;
    }
    public void setCurrentCode(int code){
        this.currentCode = code;
    }
    public int getCurrentCode(){
        return this.currentCode;
    }
    public String getName(){
        return name;
    }
    public int getNumber(){
        return number;
    }
}
