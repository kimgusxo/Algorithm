import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        Arrays.sort(spell);
        for(String s : dic) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            if(Arrays.toString(chars).equals(Arrays.toString(spell))) {
                answer = 1;
            }
        }
        return answer;
    }
}