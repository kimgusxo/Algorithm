import java.util.*;

class Solution {
    
    static int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        
        // 1. 초기화
        List<List<Integer>> tree = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        
        // 2. 값 넣기
        for(int[] w : wires) {
            tree.get(w[0]).add(w[1]);
            tree.get(w[1]).add(w[0]);
        }
        
        // 3. 반복 돌리기
        for(int[] w : wires) {
            boolean[] visited = new boolean[n+1];
            
            tree.get(w[0]).remove(Integer.valueOf(w[1]));
            tree.get(w[1]).remove(Integer.valueOf(w[0]));
            
            int a = bfs(tree, visited, w[0]);
            int b = bfs(tree, visited, w[1]);
            
            answer = Math.min(answer, Math.abs(a-b));
            
            tree.get(w[0]).add(w[1]);
            tree.get(w[1]).add(w[0]);
        }
        
        return answer;
    }
    
    public static int bfs(List<List<Integer>> tree, boolean[] visited, int n) {
        int cnt = 1;
        Deque<Integer> queue = new ArrayDeque<>();
        
        queue.offer(n);
        visited[n] = true;
        
        while(!queue.isEmpty()) {
            int el = queue.poll();
            
            for(Integer i : tree.get(el)) {
                if(!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}