import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> answer = Arrays.stream(arr).boxed().collect(Collectors.toList());
        
        for(int delete : delete_list) {
            if(answer.contains(delete)) answer.remove(Integer.valueOf(delete));
        }
        
        return answer.stream().mapToInt(x -> x).toArray();
    }
}