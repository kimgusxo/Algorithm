import java.util.*;

class Solution {
    
    public int solution(int[] priorities, int location) {
        int answer = 1;
        
        Deque<Process> queue = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int loc = 0;
        
        for(int el : priorities) {
            pq.offer(el);
            queue.offer(new Process(el, loc));
            loc++;
        }
        
        while(!queue.isEmpty()) {
            Process p = queue.poll();
            if(p.priority == pq.peek()) {
                if(p.location == location) break;
                pq.poll();
                answer++;
            } else {
                queue.offer(p);
            }
        }
        
        return answer;
    }
}

class Process {
    int priority;
    int location;
    
    public Process(int priority, int location) {
        this.priority = priority;
        this.location = location;
    }
}