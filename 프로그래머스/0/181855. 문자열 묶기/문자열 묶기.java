import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(String s : strArr) {
            map.compute(s.length(), (k, v) -> v == null ? 1 : v+1);
        }
        
        for(Integer el : map.values()) {
            answer = Math.max(el, answer);
        }
        
        return answer;
    }
}