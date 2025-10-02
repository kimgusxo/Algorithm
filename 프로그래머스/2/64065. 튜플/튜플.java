import java.util.*;

class Solution {
    
    public int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        
        String[] numbers = s.replace("{", "").replace("}", "").split(",");
        for(String num : numbers) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> Integer.compare(map.get(o2), map.get(o1)));
        
        return keySet.stream().mapToInt(x -> Integer.parseInt(x)).toArray();
    }
}