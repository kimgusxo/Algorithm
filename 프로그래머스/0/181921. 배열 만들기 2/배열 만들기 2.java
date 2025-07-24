import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Integer> fives = new ArrayList<>();
        
        for(int i = 1; i < (int) Math.pow(2, 6); i++) {
            String s = Integer.toBinaryString(i).replaceAll("1", "5");
            fives.add(Integer.parseInt(s));
        }
        
        for(int el : fives) {
            if(l <= el && el <= r) {
                answer.add(el);
            }
        }
        
        return answer.isEmpty() ? new int[]{-1} : answer.stream().mapToInt(x -> x).toArray();
    }
}