import java.util.*;

class Solution {
    public String[] solution(String[] picture, int k) {
        ArrayList<String> answer = new ArrayList<>();

        for(String p : picture) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < p.length(); j++) {
                sb.append(String.valueOf(p.charAt(j)).repeat(k));
            }
            
            for(int i = 0; i < k; i++) {                
                answer.add(sb.toString());
            }
        }

        return answer.stream().toArray(String[]::new);
    }
}