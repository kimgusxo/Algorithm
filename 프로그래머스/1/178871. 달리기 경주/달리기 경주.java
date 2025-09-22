import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
            
        for(String call : callings) {
            int cur = map.get(call);
            int prev = map.get(call)-1;
            
            String temp = players[prev];
            
            players[prev] = call;
            map.replace(call, prev);
            
            players[cur] = temp;
            map.replace(temp, cur);
            
        }
        
        return players;
    }
}