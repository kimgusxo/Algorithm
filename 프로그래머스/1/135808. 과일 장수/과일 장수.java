import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        List<Integer> arr = Arrays.stream(score).boxed().collect(Collectors.toList());
        Collections.sort(arr, Collections.reverseOrder());
        
        int idx = 0;
        for(Integer s : arr) {
            idx++;
            if(idx%m == 0) {
                answer += s*m;
            }
        }
        
        return answer;
    }
}