import java.util.*;

class Solution {
    
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        
        for(int en : enemy) {
            if(k == 0 && n < en) break;
            
            if(n >= en) {
                pq.offer(en);
                n -= en;
            } else {
                if(pq.peek() >= en) {
                    n += pq.poll();
                    n -= en;
                    pq.offer(en);
                }
                k--;
            }
            answer++;
        }
        
        return answer;
    }
}