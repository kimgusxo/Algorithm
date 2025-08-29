import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int cur = arr[0];
        list.add(cur);
        for(int i = 1; i< arr.length; i++) {
            if(cur != arr[i]) {
                cur = arr[i];
                list.add(cur);
            }
        }
        
        return list.stream().mapToInt(x->x).toArray();
    }
}