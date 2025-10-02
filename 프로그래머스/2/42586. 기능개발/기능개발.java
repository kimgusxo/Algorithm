import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        
        for(int i = 0; i < progresses.length; i++) {
            int n = (100-progresses[i]);
            n = n%speeds[i] == 0 ? n/speeds[i] : n/speeds[i]+1;
            queue.offer(n);
        }
        
        while(!queue.isEmpty()) {
            int cnt = 1;
            int el = queue.poll();
            while(!queue.isEmpty() && el >= queue.peek()) {
                queue.poll();
                cnt++;
            }
            answer.add(cnt);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}