import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Deque<String> queue = new ArrayDeque<>();
        
        for(String city : cities) {
            String processed = city.toLowerCase();
            if(!queue.contains(processed)) {
                if(queue.size() < cacheSize) {
                    queue.offer(processed);
                } else {
                    queue.offer(processed);
                    queue.poll();
                }
                answer += 5;
            } else {
                queue.remove(processed);
                queue.offer(processed);
                answer += 1;
            }
        }
        
        return answer;
    }
}