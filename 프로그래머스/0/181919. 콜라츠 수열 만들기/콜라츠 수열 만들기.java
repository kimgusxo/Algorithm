import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(n);
        while(n != 1) {
            n = n % 2 == 0 ? n/2 : 3*n+1;
            answer.add(n);
        }
        return answer.stream().mapToInt(x -> x).toArray();
    }
}