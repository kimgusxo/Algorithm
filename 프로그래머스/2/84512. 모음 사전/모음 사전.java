import java.util.*;

class Solution {

    static List<Character> alphabet = List.of(' ', 'A', 'E', 'I', 'O', 'U');

    public int solution(String word) {
        int answer = 0;

        char[] ch = new char[5];
        Arrays.fill(ch, ' ');

        int pointer = 0;
        while(!String.valueOf(ch).trim().equals(word)) {
            int index = alphabet.indexOf(ch[pointer]);

            if(index == 5) {
                ch[pointer] = alphabet.get(0);
                if(pointer > 0) {
                    pointer--;
                    answer--;
                }
            } else {
                ch[pointer] = alphabet.get(index+1);
                if(pointer < 4) {
                    pointer++;
                }
            }

            answer++;
        }

        return answer;
    }
}