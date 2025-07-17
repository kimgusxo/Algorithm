import java.util.*;

class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length/n][n];
        int k = 0;
        for(int i = 0; i < num_list.length; i += n) {
            answer[k] = Arrays.copyOfRange(num_list, i, i+n);
            k++;
        }
        return answer;
    }
}