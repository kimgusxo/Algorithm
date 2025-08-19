import java.util.*;

class Solution {
    public int[] solution(String myString) {
        ArrayList<String> s = new ArrayList<>(Arrays.asList(myString.split("x")));
        if(myString.charAt(myString.length()-1) == 'x') {
            s.add("");
        }
        int[] answer = new int[s.size()];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = s.get(i).length();
        }
        
        return answer;
    }
}