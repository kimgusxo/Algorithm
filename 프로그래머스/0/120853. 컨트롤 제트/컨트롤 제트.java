import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        for(String c : s.split(" ")) {
            if(c.equals("Z")) {
                answer -= stack.pop();
            } else {
                int el = Integer.parseInt(c);
                answer += el;
                stack.push(el);
            }
        }
        
        return answer;
    }
}