import java.util.*;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        ArrayList<Integer> answer = new ArrayList<>();
        int idx = 0;
        for(boolean f : flag) {
            if(f) {
                for(int i = 0; i < arr[idx]*2; i++) {
                    answer.add(arr[idx]);
                }
            } else {
                for(int i = 0; i < arr[idx]; i++) {
                    answer.remove(answer.size()-1);
                }
            }
            idx++;
        }
        
        return answer.stream().mapToInt(x -> x).toArray();
    }
}