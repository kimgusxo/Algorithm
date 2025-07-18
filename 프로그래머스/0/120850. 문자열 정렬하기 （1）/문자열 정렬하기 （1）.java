import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        String st = my_string.replaceAll("[a-z]", "");

        int[] answer = new int[st.length()];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = st.charAt(i) - '0';
        }
        Arrays.sort(answer);
        return answer;
    }
}