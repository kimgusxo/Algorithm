import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int el : arr) {
            if(answer.isEmpty()) {
                answer.add(el);
            } else {
                if(answer.get(answer.size()-1) == el) {
                    answer.remove(answer.size()-1);
                } else {
                    answer.add(el);
                }
            }
        }
        
        return answer.isEmpty() ? new int[]{-1} : answer.stream().mapToInt(x -> x).toArray();
    }
}