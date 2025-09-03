import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for(int[] com : commands) {
            int[] temp = Arrays.copyOfRange(array, com[0]-1, com[1]);
            Arrays.sort(temp);
            answer[idx] = temp[com[2]-1];
            idx++;
        }
        return answer;
    }
}