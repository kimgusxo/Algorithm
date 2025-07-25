import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(a, map.getOrDefault(a, 0) + 1);
        map.put(b, map.getOrDefault(b, 0) + 1);
        map.put(c, map.getOrDefault(c, 0) + 1);
        map.put(d, map.getOrDefault(d, 0) + 1);

        if(map.size() == 1){
            answer = a*1111;
        } else if(map.size() == 2){
            if(map.get(a) == 2) {
                int[] arr =map.keySet().stream().mapToInt(x->x).toArray();
                answer = (arr[0]+arr[1])*Math.abs(arr[0]-arr[1]);
            } else {
                int p = 0;
                int q = 0;
                for(int el : map.keySet()){
                    if(map.get(el) == 3) {
                        p = el;
                    } else {
                        q = el;
                    }
                }
                answer = (int) Math.pow(10*p+q, 2);
            }
        } else if(map.size() == 3) {
            int m = 1;
            for(int el : map.keySet()){
                if(map.get(el) != 2) {
                    m *= el;
                }
                answer = m;
            }
        } else if(map.size() == 4){
            int min = Integer.MAX_VALUE;
            for(int el : map.keySet()){
                min = Math.min(min, el);
            }
            answer = min;
        }

        return answer;
    }
}