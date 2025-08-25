import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int el : arr) {
            if(el % divisor == 0) answer.add(el); 
        }
        
        if(answer.isEmpty()) answer.add(-1);
        
        return answer.stream().mapToInt(x->x).sorted().toArray();
    }
}