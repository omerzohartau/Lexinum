import java.util.List;
import java.util.Random;

public interface Riddle {
    public String translateNumToSentence(int num);
    public static int getNumber(int range1, int range2){
        int toReturn;
        Random r = new Random();
        toReturn = r.nextInt(range2-range1) + range1;
        return toReturn;
    }
    public static int[] getNumbers(int range1, int range2, int numOfParticipants){
        int[] toReturn = new int[numOfParticipants];
        Random r = new Random();
        for(int i = 0; i<numOfParticipants; i++) {
            toReturn[i] = getNumber(range1, range2);
        }
        return toReturn;
    }
}
