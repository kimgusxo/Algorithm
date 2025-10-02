import java.util.*;

class Solution {
    
    // 1. Deque만들고 Stack 빠질때 answer에 값 넣기
    // 2. 100 - progress = n, n%speed == 0이면 n/speed, n/speed+1;
    // 3. while문 두개만들어서 ㄱㄱ
    
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