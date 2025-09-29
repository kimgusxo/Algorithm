import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        StringBuilder sb = new StringBuilder(s);
        while(true) {
            if(isCorrect(sb)) {
                answer++;
            }
            sb.append(sb.charAt(0)).deleteCharAt(0);

            if(sb.toString().equals(s)) break;
        }

        return answer;
    }

    public static boolean isCorrect(StringBuilder sb) {
        Deque<String> stack = new ArrayDeque<>();
        for(String s : sb.toString().split("")) {
            if(!stack.isEmpty()) {
                switch(s) {
                    case ")":
                        if(stack.peek().equals("(")) {
                            stack.pop();
                        } else {
                            stack.push(s);
                        }
                        break;
                    case "]":
                        if(stack.peek().equals("[")) {
                            stack.pop();
                        } else {
                            stack.push(s);
                        }
                        break;
                    case "}":
                        if(stack.peek().equals("{")) {
                            stack.pop();
                        } else {
                            stack.push(s);
                        }
                        break;
                    default:
                        stack.push(s);
                        break;
                }
            } else {
                stack.push(s);
            }
        }

        return stack.isEmpty();
    }
}