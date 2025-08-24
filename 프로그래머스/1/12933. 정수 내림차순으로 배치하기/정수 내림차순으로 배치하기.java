import java.util.*;

class Solution {
    public long solution(long n) {
        PriorityQueue<Character> list = new PriorityQueue<>(Collections.reverseOrder());
        for(char c : String.valueOf(n).toCharArray()) {
            list.add(c);
        }
        
        StringBuilder answer = new StringBuilder();
        while(!list.isEmpty()) {
            answer.append(list.poll());
        }
            
        return Long.parseLong(answer.toString());
    }
}