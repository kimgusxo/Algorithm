import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int el : arr) {
            for(int i = 0; i < el; i++) {
                answer.add(el);
            }
        }
        
        return answer.stream().mapToInt(x -> x).toArray();
    }
}