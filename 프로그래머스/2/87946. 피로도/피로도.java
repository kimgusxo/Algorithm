class Solution {
    
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        boolean[] visited = new boolean[dungeons.length];
        backtracking(dungeons, visited, k, 0);
        
        return answer;
    }
    
    public static void backtracking(int[][] dungeons, boolean[] visited, int k, int val) {
        
        answer = Math.max(answer, val);

        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                k -= dungeons[i][1];
                visited[i] = true;
                val++;
                
                backtracking(dungeons, visited, k, val);
                
                val--;
                visited[i] = false;
                k += dungeons[i][1];   
            }
        }
    }
}