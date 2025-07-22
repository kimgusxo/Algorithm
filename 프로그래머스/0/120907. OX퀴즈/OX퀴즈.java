import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        int i = 0;

        for(String expr : quiz) {
            String[] tokens = expr.split(" ");

            int left = 0;
            int right = Integer.parseInt(tokens[4]);
            if(tokens[1].equals("+")) {
                left = Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[2]);
            } else {
                left = Integer.parseInt(tokens[0]) - Integer.parseInt(tokens[2]);
            }

            if(left == right) {
                answer[i] = "O";
            } else {
                answer[i] = "X";
            }
            i++;
        }
        return answer;
    }
}