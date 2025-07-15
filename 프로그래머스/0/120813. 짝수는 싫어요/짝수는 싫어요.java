import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int k = 1;
        while(n >= k) {
            if(k%2 == 1) {
                list.add(k);
            }
            k++;
        }
        
        return list.stream().mapToInt(x -> x).toArray();
    }
}