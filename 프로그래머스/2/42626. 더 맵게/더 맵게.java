import java.util.*;

class Solution {
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) {
            pq.add(s);
        }
        
        while(pq.peek() < K && pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            
            int c = a+(2*b);
            pq.add(c);
            answer++;
        }
        
        if(pq.peek() < K) {
            answer = -1;
        }
        
        return answer;
    }
}