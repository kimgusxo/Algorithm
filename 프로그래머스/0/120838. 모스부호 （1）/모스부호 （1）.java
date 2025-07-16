import java.util.Arrays;
import java.util.List;

class Solution {
    static List<String> morse = List.of(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..");
    
    public String solution(String letter) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(letter.split(" ")).forEach(s -> sb.append((char) (morse.indexOf(s)+'a')));
        return sb.toString();
    }
}