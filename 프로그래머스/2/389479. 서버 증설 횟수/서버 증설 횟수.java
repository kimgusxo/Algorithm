class Solution {
    
    static int answer = 0;
    
    public int solution(int[] players, int m, int k) {
        int[] server = new int[players.length];
        
        for(int i = 0; i < players.length; i++) {
            if(players[i] >= (server[i]+1)*m) {   
                int add = (players[i]-(server[i]+1)*m)/m+1;
                addServer(server, i, k, add);
            }
            System.out.print(server[i] + " ");
        }
        
        return answer;
    }
    
    private static void addServer(int[] server, int curIdx, int k, int add) {
        answer += add;
        
        int length = curIdx+k <= server.length ? curIdx+k : server.length;
        for(int i = curIdx; i < length; i++) {
            server[i] += add;
        }
    }
}