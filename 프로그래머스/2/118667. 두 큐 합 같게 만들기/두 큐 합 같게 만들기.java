import java.util.*;

class Solution {
    
    static int answer = 0;
    
    public int solution(int[] queue1, int[] queue2) {
        List<Integer> l1 = Arrays.asList(Arrays.stream(queue1).boxed().toArray(Integer[]::new));
        List<Integer> l2 = Arrays.asList(Arrays.stream(queue2).boxed().toArray(Integer[]::new));
        
        Deque<Integer> q1 = new ArrayDeque<>(l1);
        Deque<Integer> q2 = new ArrayDeque<>(l2);
        
        long q1Sum = q1.stream().mapToInt(i->i).sum();
        long q2Sum = q2.stream().mapToInt(i->i).sum();
        
        while(!(q1Sum == q2Sum)) {
            if(q1Sum > q2Sum) {
                int q1El = q1.poll();
                
                q2.offer(q1El);
                
                q1Sum -= q1El;
                q2Sum += q1El;
            } else {
                int q2El = q2.poll();
                
                q1.offer(q2El);
                
                q2Sum -= q2El;
                q1Sum += q2El;
            }
            
            answer++;
            
            if(q1.isEmpty() || q2.isEmpty()) {
                answer = -1;
                break;
            }
            
            if(answer > queue1.length*3) {
                answer = -1;
                break;
            }
        }
        
        return answer;
    }
}