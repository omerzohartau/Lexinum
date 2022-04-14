public class Riddle2 implements Riddle {
    int[] mehalkim = {2, 3, 7, 11, 13};
    String[] tnaim = {"ארנב", "תמנון", "נחש", "צלופח", "נשר"};
    public String translateNumToSentence(int num){
        String toReturn = "אני מחזיק בידי ";
        for(int i = 0; i < mehalkim.length; i++){
            if(num % mehalkim[i] == 0){
                if(toReturn.charAt(toReturn.length() - 1) == ',' || toReturn.charAt(toReturn.length() - 1) == ' '){
                    toReturn += tnaim[i];
                }
                else{
                    toReturn += " " + tnaim[i];
                }
                if(i == 1){
                    if(sumDividesByNine(num))
                        toReturn += " עיוור";
                }
            }
        }
        toReturn += ". בכיס שלי יש";
        if((num%100)/10 > 8){
            toReturn += " אגוזים";
        }
        if(num%10 > 3){
            toReturn += " " + (num%10 - 3) + " תפוזים";
        }
        if(ordered(num)){
            toReturn += " אגסים";
        }
        toReturn += ".";
        return toReturn;
    }
    private boolean sumDividesByNine(int num){
        int sumnum = 0;
        while(num != 0){
            sumnum += num % 10;
            num /= 10;
        }
        return sumnum % 9 == 0;
    }
    private boolean ordered(int num){
        while(num>10){
            if(num%10 > (num%100)/10)
                return false;
        }
        return true;
    }
}
