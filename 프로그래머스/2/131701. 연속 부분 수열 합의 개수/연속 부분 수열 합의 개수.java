import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < elements.length; i++) {
            for(int j = 0; j < elements.length; j++) {
                int sum = 0;
                for(int q = j; q <= i+j; q++) {
                    int mod = q%elements.length;
                    sum += elements[mod];
                }
                set.add(sum);
            }
        }

        return set.size();
    }
}