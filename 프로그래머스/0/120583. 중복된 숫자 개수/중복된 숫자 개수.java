import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int el : array) {
            map.put(el, map.getOrDefault(el, 0) + 1);
        }

        answer = map.getOrDefault(n, 0);
        return answer;
    }
}