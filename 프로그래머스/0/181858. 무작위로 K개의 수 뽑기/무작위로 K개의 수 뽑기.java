import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        int[] answer = new int[k];
        
        int idx = 0;
        for(int el : arr) {
            if(!set.contains(el)) {
                set.add(el);
                answer[idx++] = el;
                
                if(idx == k) break;
            }
        }
        for(int i = idx; i < k; i++) {
            answer[i] = -1;        
        }
        
        return answer;
    }
}