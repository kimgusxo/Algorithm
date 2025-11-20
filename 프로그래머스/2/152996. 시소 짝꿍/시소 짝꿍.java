import java.util.*;

class Solution {
    
    static long answer = 0;

    public long solution(int[] weights) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < weights.length; i++) {
            int el = weights[i];

            Set<Integer> set = new HashSet<>();

            set.add(el);
            set.add(el*2);
            if(el%2 == 0) {
                set.add(el/2);
                set.add(el/2*3);
            }
            if(el%3 == 0) {
                set.add(el/3*2);
                set.add(el/3*4);
            }
            if(el%4 == 0) {
                set.add(el/4*3);
            }


            for(Integer e : set) {
                answer += map.getOrDefault(e, 0);
            }

            map.put(el, map.getOrDefault(el, 0)+1);
        }

        return answer;
    }
}