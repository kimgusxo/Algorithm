import java.util.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int el : array) {
            map.put(el, map.getOrDefault(el, 0)+1);
        }

        ArrayList<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet, (o1, o2) -> map.get(o2) - map.get(o1));

        if(keySet.size() > 1) {
            if(map.get(keySet.get(0)) > map.get(keySet.get(1))) {
                return keySet.get(0);
            } else if(map.get(keySet.get(0)) < map.get(keySet.get(1))) {
                return keySet.get(1);
            } else {
                return -1;
            }
        } else {
            return keySet.get(0);
        }
    }
}