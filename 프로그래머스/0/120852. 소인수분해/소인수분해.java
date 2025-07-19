import java.util.*;

class Solution {
    public int[] solution(int n) {
        Set<Integer> answer = new TreeSet<>();
        int result = n;
        
        while(n > 1) {
            for(int i = 2; i <= n; i++) {
                if(n % i == 0) {
                    n /= i;
                    answer.add(i);
                    break;
                }
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}