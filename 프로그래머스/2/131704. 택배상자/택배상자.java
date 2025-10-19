import java.util.*;

class Solution {
public int solution(int[] order) {
        int answer = 0;

        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 1; i <= order.length; i++) {
            queue.offer(i);
        }

        boolean flag = false;
        for(int el : order) {
            if(flag) break;
            while(true) {
                if(!queue.isEmpty() && queue.peek() == el) {
                    queue.poll();
                    answer++;
                    break;
                } else if(!stack.isEmpty() && stack.peek() == el) {
                    stack.pop();
                    answer++;
                    break;
                } else {
                    if(!queue.isEmpty()) {
                        stack.push(queue.poll());
                    } else {
                        flag = true;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}