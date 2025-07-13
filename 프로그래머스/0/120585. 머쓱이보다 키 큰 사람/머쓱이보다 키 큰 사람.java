import java.util.*;

class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int el : array) {
            if(el > height) {
                list.add(el);
            }
        }
        return list.size();
    }
}