import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int el : tangerine) {
            map.put(el, map.getOrDefault(el, 0)+1);
        }
        
        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort((o1, o2) -> {
            return map.get(o2) - map.get(o1);
        });
        
        for(Integer key : keys) {
            k -= map.get(key);
            answer++;
            if(k <= 0) {
                break;
            }
        }
        
        return answer;
    }
}