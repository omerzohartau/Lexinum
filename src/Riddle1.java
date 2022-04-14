public class Riddle1 implements Riddle {
    final char[] otiot = {'א', 'ב', 'ג', 'ד', 'ה', 'ו', 'ז', 'ח', 'ט', 'י', 'כ', 'ל', 'מ', 'נ', 'ס', 'ע', 'פ', 'צ', 'ק', 'ר', 'ש', 'ת'};
    public String translateNumToSentence(int num){
        String sentence = "";
        String binary = Integer.toBinaryString(num);
        char[] chars = binary.toCharArray();
        for(int i = chars.length-1; i >= 0; i--){
            if(chars[chars.length - i - 1] == '1') {
                sentence = otiot[i] + sentence;
            }
        }
        return sentence;
    }
}
