import java.util.*;

class Solution {
    
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> allMap = new HashMap<>();
        Map<Integer, Integer> firstMap = new HashMap<>();
        
        for(int tp : topping) {
            allMap.put(tp, allMap.getOrDefault(tp, 0)+1);
        }
        
        for(int tp : topping) {
            firstMap.put(tp, firstMap.getOrDefault(tp, 0)+1);
            allMap.put(tp, allMap.get(tp)-1);
            
            if(allMap.get(tp) <= 0) {
                allMap.remove(tp);
            }
            
            if(allMap.keySet().size() == firstMap.keySet().size()) {
                answer++;
            }
        }
        
        return answer;
    }
}