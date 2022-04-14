public class Riddle3 implements Riddle {
    public String translateNumToSentence(int num){
        String toReturn = "";
        char[] numChars = (num + "").toCharArray();
        String paliNum = createPaliNum(numChars);
        String boomNum = createBoomNum(num);
        String swissNum = createSwissNum(numChars);
        String tinNum = createTinNum(num);
        int sumnum = createSumNum();
        toReturn = swissNum + System.lineSeparator() + paliNum + System.lineSeparator() + tinNum + System.lineSeparator() + boomNum + System.lineSeparator() + sumnum;
        return toReturn;
    }
    private String createPaliNum(char[] numChars){
        String paliNum = "";
        for(int i = numChars.length - 1; i >= 0; i--) {
            paliNum += numChars[i];
        }
        return paliNum;
    }
    private String createBoomNum(int num){
        return (num / 7) + "";
    }
    private String createSwissNum(char[] numChars){
        String swissNum = "";
        for(int i = numChars.length - 1; i >= 0; i--){
            if(i%2 == 1){
                swissNum = numChars[i] + swissNum;
            }
        }
        return swissNum;
    }
    private String createTinNum(int num){
        String tinNum = "";

        return tinNum;
    }
    private int createSumNum(){
        int sumnum = 0;

        return sumnum;
    }
}
