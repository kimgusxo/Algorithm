import java.util.*;

class Solution {
    
    static int answer = Integer.MAX_VALUE;
    static int[] visited = new int[1000001];
    
    public int solution(int x, int y, int n) {
        Arrays.fill(visited, Integer.MAX_VALUE);
        calc(x, y, n, 0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
     
    public static void calc(int x, int y, int n, int cnt) {
        if(x > y || cnt >= answer) {
            return;
        }
        
        if (cnt >= visited[y]) {
            return;
        }
        
        visited[y] = cnt;
        
        if(x == y) {
            answer = Math.min(cnt, answer);
            return;
        }
        
        
        if(y%3 == 0) {
            calc(x, y/3, n, cnt+1);
        }
        if(y%2 == 0) {
            calc(x, y/2, n, cnt+1);
        }
        calc(x, y-n, n, cnt+1);
    }
}