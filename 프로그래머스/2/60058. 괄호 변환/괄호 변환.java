import java.util.*;

class Solution {
    
    public static String solution(String p) {
        return balance(new StringBuilder(p)).toString();
    }

    private static StringBuilder balance(StringBuilder line) {
        if(line.length() == 0) return line;

        int idx = divide(line);
        StringBuilder u = new StringBuilder(line.substring(0,idx+1));
        StringBuilder v = new StringBuilder(line.substring(idx+1));

        if(isBalanced(u)) {
            return u.append(balance(v));
        } else {
            StringBuilder temp = new StringBuilder();

            temp.append("(");
            temp.append(balance(v));
            temp.append(")");

            u.deleteCharAt(0);
            u.deleteCharAt(u.length()-1);

            StringBuilder reverse = new StringBuilder();
            for(int i = 0; i < u.length(); i++) {
                if(u.charAt(i) == '(') {
                    reverse.append(")");
                } else {
                    reverse.append("(");
                }
            }

            return temp.append(reverse);
        }
    }

    private static int divide(StringBuilder line) {
        int idx = 0;
        int left = 0;
        int right = 0;
        for(int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if(left == right) {
                idx = i;
                break;
            }
        }

        return idx;
    }

    private static boolean isBalanced(StringBuilder line) {
        if(line.length() == 0) return true;

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if(c == '(') {
                stack.push("(");
            } else {
                if(!stack.isEmpty() && stack.peek().equals("(")) {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}