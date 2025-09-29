import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int c : citations) {
            for(int i = 0; i <= c; i++) {
                map.put(i, map.getOrDefault(i, 0)+1);
            }
        }
        
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, Collections.reverseOrder());
        
        for(Integer key : keys) {
            if(key <= map.get(key)) {
                answer = key;
                break;
            }
        }
        
        return answer;
    }
}