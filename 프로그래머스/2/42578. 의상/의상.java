import java.util.*;

class Solution {
    
    static int answer = 1;
    
    public int solution(String[][] clothes) {
        Map<String, Set<String>> map = new HashMap<>();
        for(String[] c : clothes) {
            Set<String> set = map.getOrDefault(c[1], new HashSet<>());
            set.add(c[0]);
            
            map.put(c[1], set);
        }
        
        for(String c : map.keySet()) {
            answer *= map.get(c).size() + 1;
        }
        
        
        return answer-1;
    }
}