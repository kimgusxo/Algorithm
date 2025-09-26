import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<String> stack = new Stack<>();
        
        for(String c : s.split("")) {
            if(!stack.isEmpty() && c.equals(stack.peek())) {
                stack.pop();
                continue;
            } else {
                stack.push(c);
            }
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
}